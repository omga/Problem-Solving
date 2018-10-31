package com.test.solutions.amazon.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author a.hatrus
 */
public class Solution_1 {
    public static void main(String[] args) {
        Solution_1 s1 = new Solution_1();

        System.out.print(s1.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k)
            return -1;
        Queue maxQ = new PriorityQueue(k);//, Collections.reverseOrder());
        maxQ.offer(nums[0]);
        for (int j = 1; j < nums.length; j++) {
            int num = nums[j];
            if (num < (int) maxQ.peek() && maxQ.size() == k)
                continue;
            if (maxQ.size() >= k)
                maxQ.poll();
            maxQ.offer(num);
        }
        return (int) maxQ.peek();
    }
}