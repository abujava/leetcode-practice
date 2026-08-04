package com.seniorali.problems;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/find-missing-elements">3731. Find Missing Elements</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Sorting}
 */
public class P3731_FindMissingElements {

    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = 101, max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(num, max);
        }

        int[] arr = new int[max - min + 1];
        for (int i : nums) {
            arr[i - min]++;
        }

        for (int i = min + 1; i < max; i++) {
            if (arr[i - min] == 0)
                list.add(i);
        }
        return list;
    }

    /*public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums); // O(n log n)

        // O(n)
        for (int i = nums[0] + 1; i < nums[nums.length - 1]; i++) {
            var ind = i - nums[0] - list.size();
            if (ind > nums.length - 1 || nums[ind] != i)
                list.add(i);
        }
        return list;
    }*/

    /*public static List<Integer> findMissingElements(int[] nums) {
        int min = 101, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = (min < num) ? min : num;
            max = (num < max) ? max : num;

            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i))
                list.add(i);
        }
        return list;
    }*/

    public static void main(String[] args) {
        System.out.println(findMissingElements(new int[]{100, 105}));
    }
}
