package cn.net.integration.core.common.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description 生成UUID
 * @Author ycl
 * @Date 2023/8/14 11:16
 * @Version 1.0
 */
public class UUIDUtil {

    /**
     * 获取唯一ID，使用UUID
     *
     * @return 返回唯一ID
     */
    public static String getUniqueId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
