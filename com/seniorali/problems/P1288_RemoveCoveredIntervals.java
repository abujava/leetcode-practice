package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-covered-intervals/">1288. Remove Covered Intervals</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Sorting}
 */
public class P1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 1;

        int count = intervals.length;

        mainLoop:
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) continue;
                if (intervals[i][0] >= intervals[j][0]
                        && intervals[i][1] <= intervals[j][1]){
                    count--;
                    continue mainLoop;
                }
            }
        }
        return count;
    }
}