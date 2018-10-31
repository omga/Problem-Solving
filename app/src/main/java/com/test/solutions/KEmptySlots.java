package com.test.solutions;

import java.util.Arrays;

/**
 * @author a.hatrus
 */

public class KEmptySlots {

    public static void main(String[] args) {
        int[] flowers1 = {8, 5, 6, 2, 4, 10, 9, 1, 7, 3};
        int[] flowers2 = {1, 3, 2};
        int[] flowers3 = {4, 2, 1, 5, 3};

        Solution solution = new Solution();
        System.out.println("answer1 = " + Arrays.toString(solution.makeGardenArray(flowers1)));
        System.out.println("answer1 = " + Arrays.toString(solution.makeGardenArray(flowers2)));
        System.out.println("answer1 = " + Arrays.toString(solution.makeGardenArray(flowers3)));
        System.out.println("answer1 = " + solution.kEmptySlots(flowers1, 5));
        System.out.println("answer2 = " + solution.kEmptySlots(flowers2, 1));
        System.out.println("answer3 = " + solution.kEmptySlots(flowers3, 1));

    }

    static class Solution {
        public int kEmptySlots(int[] flowers, int k) {
            int N = flowers.length;
            int[] garden = makeGardenArray(flowers);
            int minimumMatchingDay = Integer.MAX_VALUE;

            if (k == 0) {
                for (int i = 0; i < N - 1; i++) {
                    minimumMatchingDay = Math.min(Math.max(garden[i], garden[i + 1]),
                            minimumMatchingDay);
                }
                return minimumMatchingDay == Integer.MAX_VALUE ? -1 : minimumMatchingDay;
            }

            for (int i = 0; i < N - k - 1; i++) {
                int day = garden[i];
                int j = i + 1;
                int minDay = garden[j];
                while (minDay > day) {
                    if (j == i + k) {
                        if (garden[j + 1] < minDay) {
                            minimumMatchingDay = Math.min(Math.max(day, garden[j + 1]),
                                    minimumMatchingDay);
                        }
                        break;
                    }
                    j++;
                    minDay = Math.min(garden[j], minDay);
                }
            }
            return minimumMatchingDay == Integer.MAX_VALUE ? -1 : minimumMatchingDay;
        }

        public int[] makeGardenArray(int[] input) {
            int[] garden = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                garden[input[i] - 1] = i + 1;
            }
            return garden;
        }
    }
}
