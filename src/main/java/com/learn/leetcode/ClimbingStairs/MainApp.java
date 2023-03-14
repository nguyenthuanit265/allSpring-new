package com.learn.leetcode.ClimbingStairs;

public class MainApp {
    public static int climbStairs(int n) {
        if (n <= 1 && n >= 0) {
            return n;
        }
        return 1 + climbStairs(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
