package com.test.solutions;

import java.util.Arrays;

/**
 * @author a.hatrus
 */
class Solution {

    public static void main(String... args) {
        Solution s = new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr2 = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.print("arr1: " + Arrays.toString(s.maxSlidingWindow3(arr, 3)));
        System.out.print("arr1: " + Arrays.toString(s.maxSlidingWindow3(arr2, 5)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums.length < 2)
            return nums;
        int indexOfMax = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[i - 1]) {
                indexOfMax = i;
            }
        }
        res[0] = nums[indexOfMax];
        return calcMax(nums, 1, k, indexOfMax, res);

    }

    public int[] calcMax(int[] input, int startIndex, int endIndex, int maxValueIndex, int res[]) {
        if (endIndex == input.length)
            return res;
        int newMaxIndex = maxValueIndex;
        if (maxValueIndex >= startIndex) {
            if (input[endIndex] > input[maxValueIndex])
                newMaxIndex = endIndex;
        } else {
            newMaxIndex = findMaxIndex(input, startIndex, endIndex);
        }
        res[startIndex] = input[newMaxIndex];
        return calcMax(input, startIndex + 1, endIndex + 1, newMaxIndex, res);
    }

    public int findMaxIndex(int[] input, int startIndex, int endIndex) {
        int indexOfMax = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (input[i] > input[indexOfMax]) {
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums.length < 2)
            return nums;
        int i = 0;
        while (i + k <= nums.length) {
            int max = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
            i++;
        }
        return res;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        if (nums.length < 2)
            return nums;

        int startIndex = 0;
        int endIndex = k - 1;
        int maxValueIndex = -1;

        while (true) {
            if (endIndex == nums.length)
                return res;
            if (maxValueIndex >= startIndex) {
                if (nums[endIndex] > nums[maxValueIndex])
                    maxValueIndex = endIndex;
            } else {
                maxValueIndex = findMaxIndex(nums, startIndex, endIndex);
            }
            res[startIndex] = nums[maxValueIndex];
            startIndex++;
            endIndex++;
        }
    }
}