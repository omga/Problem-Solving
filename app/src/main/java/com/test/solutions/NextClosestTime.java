package com.test.solutions;

import java.util.Arrays;

/**
 * @author a.hatrus
 */

public class NextClosestTime {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s1: " + s.nextClosestTime("19:34"));
        System.out.println("s1: " + s.nextClosestTime("23:59"));

    }

    static class Solution {
        public String nextClosestTime(String time) {
            int[] timeInt = new int[4];
            int[] sorted = new int[4];
            int[] result = new int[4];
            timeInt[0] = Integer.parseInt(time.substring(0, 1));
            timeInt[1] = Integer.parseInt(time.substring(1, 2));
            timeInt[2] = Integer.parseInt(time.substring(3, 4));
            timeInt[3] = Integer.parseInt(time.substring(4, 5));
            System.arraycopy(timeInt, 0, sorted, 0, 4);
            System.arraycopy(timeInt, 0, result, 0, 4);
            Arrays.sort(sorted);

            for (int i = 3; i > 0; i--) {
                if (timeInt[i] >= sorted[3]) {
                    result[i] = timeInt[3];
                } else {
                    for (int j = 1; j <= 3; j++) {
                        if (sorted[j] > timeInt[i]) {
                            result[i] = sorted[j];
                            return arrToTime(result);
                        }
                    }
                }

            }
            return arrToTime(result);
        }

        public String arrToTime(int[] arr) {
            return String.valueOf(arr[0]) +
                    String.valueOf(arr[1]) +
                    ":" +
                    String.valueOf(arr[2]) +
                    String.valueOf(arr[3]);
        }

    }
}
