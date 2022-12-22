package cn.soft.common.util;

import cn.soft.common.constant.CommonConstant;

import java.util.Random;

/**
 * @ClassName ConvertUtil
 * @Description 常用转换工具类
 * @Author 叶丛林
 * @Date 2022/11/7 22:22
 * @Version 1.0
 **/
public class ConvertUtil {

    /**
     * 判断对象是否为空
     *
     * @param obj 对象
     * @return true 空  false 非空
     */
    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj) || CommonConstant.STRING_NULL.equals(obj);
    }

    /**
     * 随机数
     *
     * @param place 定义随机数的位数
     */
    public static String randomGen(int place) {
        String base = "qwertyuioplkjhgfdsazxcvbnmQAZWSXEDCRFVTGBYHNUJMIKLOP0123456789";
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < place; i++) {
            sb.append(base.charAt(rd.nextInt(base.length())));
        }
        return sb.toString();
    }
}
