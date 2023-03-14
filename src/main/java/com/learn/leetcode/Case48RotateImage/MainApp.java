package com.learn.leetcode.Case48RotateImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 48. Rotate Image
 */
public class MainApp {
    public void rotate(int[][] matrix) {

        // Mapping col -> list value
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (map.get(col) == null) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(matrix[row][col]);
            }
        }

        // Rotate
        int index = matrix.length - 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = map.get(row).get(index--);
                if (index < 0) {
                    index = matrix.length - 1;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
