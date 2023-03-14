package com.learn.common;

import com.google.gson.Gson;

public class LoggerUtils {
    public static String toJsonG(Object object) {
        if (object instanceof Integer || object instanceof Short || object instanceof Byte
                || object instanceof Long || object instanceof Character || object instanceof Boolean
                || object instanceof Double || object instanceof String || object instanceof Float) {
            return String.valueOf(object);
        }
        return new Gson().toJson(object);
    }
}
