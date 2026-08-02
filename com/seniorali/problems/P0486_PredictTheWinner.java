package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/predict-the-winner/">486. Predict the Winner</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Recursion}, {@code Game Theory}
 */
public class P0486_PredictTheWinner {

    public static boolean predictTheWinner(int[] nums) {
        return getScoreDiff(nums, 0, nums.length - 1) >= 0;
    }

    private static int getScoreDiff(int[] nums, int front, int end) {
        if (front == end) return nums[front];

        int pickFront = nums[front] - getScoreDiff(nums, front + 1, end);
        int pickEnd = nums[end] - getScoreDiff(nums, front, end - 1);

        return Math.max(pickFront, pickEnd);
    }

    public static void main(String[] args) {
        // 1, 5, 2
        // 0, 1, 2
        // ^     ^
        // 1, 2, 3, 4, 5, 6, 7
        // ^                 ^
        System.out.println(predictTheWinner(new int[]{1,5,2}));
    }
}