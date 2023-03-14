package com.learn.leetcode.Case49GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 */
public class MainApp {
    public static boolean isEmpty(String str) {
        return str == null || str.strip().length() == 0;
    }

    public static String getKey(String str) {
        if (isEmpty(str)) {
            return "";
        }

        String[] arr = str.split("");
        return Arrays.stream(arr).sorted().collect(Collectors.joining("-"));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String item : strs) {
            String key = getKey(item);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(item);
        }

        System.out.println(map);
        res = new ArrayList<>(map.values());

        System.out.println(res);

        return res;

    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr);

        String[] arr1 = {""};
        groupAnagrams(arr1);

        String[] arr2 = {"a"};
        groupAnagrams(arr2);
    }
}
