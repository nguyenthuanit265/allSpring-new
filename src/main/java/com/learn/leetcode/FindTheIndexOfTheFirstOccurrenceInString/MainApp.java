package com.learn.leetcode.FindTheIndexOfTheFirstOccurrenceInString;

/**
 * 28. Find the Index of the First Occurrence in a String
 */
public class MainApp {
    public static int strStr2(String haystack, String needle) {
        // Validate
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        String[] arr = haystack.split(needle);
        if (arr.length == 0) {
            return 0;
        }

        if (arr[0].length() == haystack.length()) {
            return -1;
        }

        return arr[0].length();
    }

    public static int strStr(String haystack, String needle) {
        // Validate
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.split("").length; i++) {
            for (int j = 0; j < needle.split("").length; j++) {
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.split("").length - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("sadbutsad", "a"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("bbbbbbbbb", "b"));
        System.out.println(strStr("bbbbbabacja", "b"));
        System.out.println(strStr("bbbbbbbbb", "bb"));
    }

}
