package com.test.solutions;

/**
 * @author a.hatrus
 */

public class MaximumSizeSubarraySums {

    public static void main(String[] args) {
        int[] arr1 = {1, -1, 5, -2, 3};
        int[] arr2 = {-2, -1, 2, 1};
        Solution s = new Solution();
        System.out.println("s1: " + s.maxSubArrayLen(arr1, 3));
        System.out.println("s2: " + s.maxSubArrayLen(arr2, 1));

    }

    static class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int maxlen = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        maxlen = Math.max(maxlen, Math.abs(i - j) + 1);
                    }
                }
            }
            return maxlen;
        }
    }
}
