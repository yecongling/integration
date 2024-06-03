package cn.net.base.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName DateUtils
 * @Description 时间工具类
 * @Author ycl
 * @Date 2024/6/3 下午4:28
 * @Version 1.0
 */
public class DateUtils {

    // 使用DateTimeFormatter，是因为DateTimeFormatter是线程安全的
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     *
     * @return 获取当前时间字符串
     */
    public static String getCurrentDate() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }
}
