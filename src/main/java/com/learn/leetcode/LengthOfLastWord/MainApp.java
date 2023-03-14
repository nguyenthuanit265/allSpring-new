package com.learn.leetcode.LengthOfLastWord;

import java.util.List;

public class MainApp {
    public int lengthOfLastWord(String s) {
        List<String> arrString = List.of(s.split(" "));
        return arrString.get(arrString.size()-1).length();
    }
}
