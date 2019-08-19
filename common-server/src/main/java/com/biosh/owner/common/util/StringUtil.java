package com.biosh.owner.common.util;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * @description
 * @date 2019/6/20
 */
public class StringUtil {

    /**
     * UUID
     */
    public static String generateToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 字符串拼接
     */
    public static String joinToSeparator(Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(StringUtils.join(objects, ","));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(joinToSeparator(1, 2, 3));
        System.out.println(generateToken());
    }

}
