package com.cda.util.general;

/**
 * @description 自定义工具类
 */

public class MyUtils {
    public static String getCode(int length) {
        String str = String.valueOf(System.currentTimeMillis());
        System.out.println(str);
        return str.substring(str.length() - length);
    }

    private MyUtils() {
    }
}
