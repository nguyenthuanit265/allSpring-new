package com.learn.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class MainApp {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        // map character by index
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>(List.of(s.split("")));
        int start = 0, run = 0, maxLength = 1;
        while ((start < list.size()) && (run < list.size())) {
            if (map.get(list.get(run)) == null) {
                map.put(list.get(run), run);
                run++;
            } else {
                if ((run - 1) - start + 1 > maxLength) {
                    maxLength = (run - 1) - start + 1;
                }
                start = map.get(list.get(run)) + 1;
                if (start < list.size()) {
                    map = new HashMap<>();
                    map.put(list.get(start), start);
                    run = start + 1;
                }
            }
        }
        return Math.max(maxLength, (run - 1) - start + 1);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
