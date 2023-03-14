package com.learn.leetcode.CompareVersion;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

    /**
     * version 1 = version 2 -> return 0
     * version 1 > version 2 -> return 1
     * version 1 < version 2 -> return 2
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.isEmpty() || version2.isEmpty()) {
            return -1;
        }
        Map<Integer, Integer> mapIndexVersion1 = new HashMap<>();
        Map<Integer, Integer> mapIndexVersion2 = new HashMap<>();
        String[] arrVersion1 = version1.split("\\.");
        String[] arrVersion2 = version2.split("\\.");

        for (int i = 0; i < Math.max(arrVersion1.length, arrVersion2.length); i++) {
            if (i < arrVersion1.length) {
                mapIndexVersion1.put(i, Integer.valueOf(arrVersion1[i]));
            }
            if (i < arrVersion2.length) {
                mapIndexVersion2.put(i, Integer.valueOf(arrVersion2[i]));
            }
        }

        for (int i = 0; i < Math.min(arrVersion1.length, arrVersion2.length); i++) {
            if (mapIndexVersion1.get(i) > mapIndexVersion2.get(i)) {
                return 1;
            } else if (mapIndexVersion1.get(i) < mapIndexVersion2.get(i)) {
                return 2;
            }
        }
        if (arrVersion1.length > arrVersion2.length) {
            for (int i = arrVersion2.length - 1; i < arrVersion1.length; i++) {
                if (mapIndexVersion1.get(i) > 0) {
                    return 1;
                }
            }
        }
        if (arrVersion2.length > arrVersion1.length) {
            for (int i = arrVersion1.length - 1; i < arrVersion2.length; i++) {
                if (mapIndexVersion2.get(i) > 0) {
                    return 2;
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.0", "1.0.0.0.0.0"));
        System.out.println(compareVersion("1.0.0", "1.0.0.0.0.1"));
        System.out.println(compareVersion("1.0.0", "2.0.0.0.0.0"));
        System.out.println(compareVersion("2.0.0", "1.0.0.0.0.0"));
    }
}
