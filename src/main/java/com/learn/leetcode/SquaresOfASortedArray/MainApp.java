package com.learn.leetcode.SquaresOfASortedArray;

import java.util.Arrays;

//977. Squares of a Sorted Array
public class MainApp {
    public static int[] sortedSquares(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int indexStart = 0;
        int indexEnd = nums.length - 1;

        while (indexEnd >= 0) {
            if (Math.abs(nums[indexStart]) > Math.abs(nums[indexEnd])) {
                int temp = nums[indexStart];
                nums[indexStart] = nums[indexEnd];
                nums[indexEnd] = temp;
//                indexEnd--;
            } else {
                if (indexStart == indexEnd) {
                    indexStart = 0;
                    nums[indexEnd] = (int) Math.pow(nums[indexEnd], 2);
                    indexEnd--;
                } else indexStart++;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
