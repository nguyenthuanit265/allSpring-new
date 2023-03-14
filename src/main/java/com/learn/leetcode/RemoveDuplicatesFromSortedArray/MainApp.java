package com.learn.leetcode.RemoveDuplicatesFromSortedArray;

import java.util.HashMap;
import java.util.Map;

public class MainApp {
    public static int removeDuplicates(int[] nums) {
        int[] response = new int[nums.length];
        int res = 0;
        int index = 1;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}
