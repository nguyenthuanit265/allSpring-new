package com.learn.leetcode.medium.FindFirstAndLastPosition;

import java.util.Optional;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class MainApp {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = first(nums, target);
        res[1] = last(nums, target);

        return res;
    }

    public static int first(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int start = 0;
        int res = -1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                res = mid;
                end--;
            }
        }
        return res;
    }

    public static int last(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int start = 0;
        int res = -1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid - 1;
            } else if (nums[mid] > target) {
                start = mid + 1;
            } else {
                res = mid;
                start++;
            }
        }
        return res;
    }
    static String B() {
        System.out.println("B()...");
        return "B";
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 8, 8, 9}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 8, 8, 8}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Optional.of("A").orElse(B()));
//        System.out.println(Optional.of("A").orElseGet(() -> B()));
    }
}
