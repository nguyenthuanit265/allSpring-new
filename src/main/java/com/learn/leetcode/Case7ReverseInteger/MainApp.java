package com.learn.leetcode.Case7ReverseInteger;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainApp {
    public static int reverse(int x) {
        if (x > Math.pow(2, 31) - 1 || x < Math.pow(-2, 31)) return 0;
        if (String.valueOf(x).length() < 2) return x;
        Queue<Integer> queue = new LinkedBlockingDeque<>();
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = x * (-1);
        }

        int remain = 0;
        do {
            remain = x % 10;
            x = x / 10;
            queue.add(remain);
        } while (x != 0);

        long result = 0;
        while (!queue.isEmpty()) {
            result = result * 10 + queue.poll();
            if (result > Math.pow(2, 31) - 1 || result < Math.pow(-2, 31)) return 0;
        }

        return (int) (isNegative ? (-1) * result : result);
    }

    public static int countOdds(int low, int high) {
        if (high == low && low % 2 == 0) return 0;

        if (high == low && low % 2 != 0) return 1;

        if (low % 2 != 0 && high % 2 != 0) {
            return 2 + (high - low - 1) / 2;
        }
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }
        if ((low % 2 != 0 && high % 2 == 0) || (low % 2 == 0 && high % 2 != 0)) {
            return 1 + (high - low - 1) / 2;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(901000));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));


    }
}
