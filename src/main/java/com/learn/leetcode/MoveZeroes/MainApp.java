package com.learn.leetcode.MoveZeroes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 283. Move Zeroes
 */
public class MainApp {
    public static void moveZeroes(int[] nums) {
        AtomicInteger numberZero = new AtomicInteger();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> listNonZero = list.stream().filter(item -> item != 0).collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            if (i <= listNonZero.size() - 1) {
                nums[i] = listNonZero.get(i);
            } else nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 4, 5, 0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
