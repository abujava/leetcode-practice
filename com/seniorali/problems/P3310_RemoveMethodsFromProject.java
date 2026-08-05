package com.seniorali.problems;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-methods-from-project/">3310. Remove Methods From Project</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Depth-First Search}, {@code Breadth-First Search}, {@code Graph}
 */
public class P3310_RemoveMethodsFromProject {

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        if (n == 1) return k == 0 ? List.of() : List.of(0);
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] inv : invocations) {
            graph.computeIfAbsent(inv[0], x -> new ArrayList<>()).add(inv[1]);
        }
        Set<Integer> suspicious = findSuspicious(graph, k);

        System.out.println(suspicious);

        for (int[] inv : invocations) {
            if (!suspicious.contains(inv[0]) && suspicious.contains(inv[1])) {
                var list = new ArrayList<Integer>(n);
                for (int i = 0; i < n; i++) {
                    list.add(i);
                }
                return list;
            }
        }

        var list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i))
                list.add(i);
        }
        return list;
    }

    public static Set<Integer> findSuspicious(HashMap<Integer, ArrayList<Integer>> graph, int k) {
        HashSet<Integer> suspicious = new HashSet<>();
        suspicious.add(k);

        ArrayList<Integer> list1 = graph.get(k);
        if (list1 == null) return suspicious;
        Queue<Integer> queue = new LinkedList<>(list1);
        while (!queue.isEmpty()) {
            var invoker = queue.poll();
            suspicious.add(invoker);
            ArrayList<Integer> list = graph.get(invoker);
            if (list == null)
                continue;
            for (int i : list) {
                if (!suspicious.contains(i)) {
                    queue.offer(i);
                    suspicious.add(i);
                }
            }

        }
        return suspicious;
    }

    public static void main(String[] args) {
        var inv = new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}};
        var result = remainingMethods(5, 0, inv);
        System.out.println(result);
    }
}

