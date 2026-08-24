package com.seniorali.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/pascals-triangle/">118. Pascal's Triangle</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Dynamic Programming}
 */
public class P0118_PascalsTriangle {

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>(n);
        list.add(List.of(1));
        if (n == 1) return list;
        list.add(List.of(1, 1));

        for (int i = 3; i <= n; i++) {
            List<Integer> subList = new ArrayList<>(i);
            subList.add(1);

            List<Integer> prev = list.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                subList.add(prev.get(j) + prev.get(j - 1));
            }
            subList.add(1);
            list.add(subList);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
/*

[1]
[1, 1]
[1, 2, 1]
[1, 3, 3, 1]
[1, 4, 6, 4, 1]

* * */