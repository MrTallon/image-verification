package com.tallon.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 临时缓存
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-10 11:27
 */
public class CaceUtil {
    public static Map<String, String> map = new HashMap<>();

    public static void addMap(String key, String value) {
        map.put(key, value);
    }

    public static String getVal(String key) {
        return map.get(key);
    }
}
