package com.learn.leetcode.LetterCombinationsOfPhoneNumber;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        if (digits.length() <= 4) {
            return Collections.emptyList();
        }
        return null;

    }

    public static void main(String[] args) {

    }
}
