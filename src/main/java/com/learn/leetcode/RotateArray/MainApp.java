package com.learn.leetcode.RotateArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 189. Rotate Array
 */
public class MainApp {
    public static void rotate(int[] nums, int k) {
        int locationHead = k % nums.length;
        int newK = nums.length - locationHead;
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(nums).forEach(num -> queue.add(num));
        while (newK > 0) {
            queue.add(queue.poll());
            newK--;
        }
        System.out.println(queue);
        int i = 0;
        while (!queue.isEmpty()){
            nums[i++] = queue.poll();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(a));
        rotate(a, 3);
        System.out.println("after: " + Arrays.toString(a));
    }
}
