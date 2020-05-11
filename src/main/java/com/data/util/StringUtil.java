package com.data.util;

import org.springframework.util.StringUtils;

public class StringUtil {
    public static boolean isEmpty(String... args) {
        for (String item : args) {
            if (StringUtils.isEmpty(item)) return true;
        }
        return false;
    }
}
