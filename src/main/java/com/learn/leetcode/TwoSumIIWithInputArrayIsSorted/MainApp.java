package com.learn.leetcode.TwoSumIIWithInputArrayIsSorted;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 167. Two Sum II - Input Array Is Sorted
 */
public class MainApp {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int indexStart = 0; indexStart < numbers.length - 1; indexStart++) {
            for (int indexEnd = numbers.length - 1; indexEnd >= 0; ) {
                if (numbers[indexStart] + numbers[indexEnd] == target) {
                    res[0] = indexStart + 1;
                    res[1] = indexEnd + 1;
                    return res;
                } else if (numbers[indexStart] + numbers[indexEnd] > target) {
                    indexEnd--;
                } else {
                    indexStart++;
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(twoSum(new int[]{2, 3, 4, 9}, 6)).boxed()
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(twoSum(new int[]{-1, -1, -1, -1, 1, 1}, 2)).boxed()
                .collect(Collectors.toList()));
    }
}
