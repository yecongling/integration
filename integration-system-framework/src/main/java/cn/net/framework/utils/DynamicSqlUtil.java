package cn.net.framework.utils;

import cn.net.framework.annotation.Column;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DynamicSqlUtil
 * @Description 动态sql工具
 * @Author ycl
 * @Date 2024/7/8 下午12:45
 * @Version 1.0
 */
public class DynamicSqlUtil {

    /**
     * 生成动态更新sql
     *
     * @param object    对象
     * @param tableName 表名
     * @param idField   主键
     * @return sql
     * @throws IllegalAccessException -
     */
    public static String generateUpdateSql(Object object, String tableName, String idField) throws IllegalAccessException {
        Map<String, Object> fieldMap = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null && !field.getName().equals(idField)) {
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    fieldMap.put(column.value(), value);
                } else {
                    fieldMap.put(field.getName(), value);
                }
            }
        }

        return new SQL() {{
            UPDATE(tableName);
            fieldMap.forEach((field, value) -> SET(field + " = #{" + field + "}"));
            WHERE(idField + " = #{" + idField + "}");
        }}.toString();
    }

}
