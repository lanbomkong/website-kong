package com.biosh.owner.common.util;

import java.util.UUID;

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

//    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid.toString().replaceAll("-", ""));
//    }
}
