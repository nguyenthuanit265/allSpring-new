package com.learn.leetcode.ZigzagConversion;

import java.util.*;

/*
 * 6. Zigzag Conversion
 * */
public class MainApp {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || s.length() < numRows) {
            return s;
        }
        List<String> stringList = List.of(s.split(""));
        Map<Integer, List<String>> map = new HashMap<>();
        int indexRow = 0;
        int spaceColumns = numRows - 2;
        for (int i = 0; i < stringList.size(); ) {
            if (indexRow > numRows - 1) {
                indexRow = numRows - 1;
                for (int j = 0; j < spaceColumns; j++) {
                    if (i >= stringList.size()) {
                        break;
                    }
                    indexRow--;
                    if (map.get(indexRow) != null) {
                        map.get(indexRow).add(stringList.get(i++));
                    } else {
                        map.put(indexRow, new ArrayList<>(Arrays.asList(stringList.get(i))));
                    }
                }
                indexRow = 0;
                continue;
            }
            if (map.get(indexRow) != null && map.get(indexRow).size() > 0) {
                map.get(indexRow++).add(stringList.get(i++));
            } else {
                map.put(indexRow++, new ArrayList<>(Arrays.asList(stringList.get(i++))));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(String.join("", map.get(i)));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ABCDE", 4));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));

        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }
}
