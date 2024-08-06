package cn.net.framework.security;

import cn.net.base.enums.Encrypt;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @ClassName DecryptedHttpInputMessage
 * @Description 输入流解密
 * @Author ycl
 * @Date 2024/8/5 下午5:29
 * @Version 1.0
 */
public class DecryptedHttpInputMessage implements HttpInputMessage {

    // 请求头
    private final HttpHeaders headers;
    // 请求体
    private final InputStream body;

    public DecryptedHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
        this.headers = inputMessage.getHeaders();
        String encryptedKey = headers.getFirst("encryptKey");
        if (encryptedKey == null) {
            throw new IllegalArgumentException("加密秘钥缺失");
        }
        // 解密AES 秘钥
        String privateKeyStr = Encrypt.RASPrivateKey;
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedKeyBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedKey));
        String aesKey = new String(decryptedKeyBytes, StandardCharsets.UTF_8);

        // 读取请求体并解密
        String encryptedData = inputStreamToString(inputMessage.getBody());
        String decryptedData = decrypt(encryptedData, aesKey);
        this.body = new ByteArrayInputStream(decryptedData.getBytes());
    }

    /**
     * Return the body of the message as an input stream.
     *
     * @return the input stream body (never {@code null})
     * @throws IOException in case of I/O errors
     */
    @Override
    public InputStream getBody() throws IOException {
        return body;
    }

    /**
     * Return the headers of this message.
     *
     * @return a corresponding HttpHeaders object (never {@code null})
     */
    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

    /**
     * 秘钥构建
     *
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    private PrivateKey getPrivateKey(String privateKeyStr) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", ""));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 解密数据
     *
     * @param data
     * @param aesKey
     * @return
     * @throws Exception
     */
    private String decrypt(String data, String aesKey) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(aesKey.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        byte[] decryptedBytes = aesCipher.doFinal(decodedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    /**
     * 输入流转字符串（读取流）
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];
        try (Reader reader = new InputStreamReader(inputStream)) {
            int length;
            while ((length = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, length);
            }
        }
        return sb.toString();
    }
}
