package com.seniorali.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/cinema-seat-allocation">1386. Cinema Seat Allocation</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code HashTable}, {@code Linked List}, {@code Greedy}, {@code Bit Manipulation}
 * <p>
 */
public class P1386_CinemaSeatAllocation {
    static final byte DEFAULT_BYTE = 0b00000000;

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int capacity = Math.min(n, Math.min(10_000, reservedSeats.length));
        Map<Integer, Byte> map = new HashMap<>(capacity);
        for (int[] rs : reservedSeats) {
            int row = rs[0], col = rs[1];
            if (col > 1 && col < 10) {
                map.merge(row, (byte) (1 << col - 2), (x, y) -> (byte) (x | y));
            }
        }

        int count = (n - map.size()) * 2;
        int[] masks = {0b11110000, 0b00001111, 0b00111100};
        for (int x : map.values()) {
            for (int mask : masks) {
                if ((x & mask) == 0) {
                    x |= mask;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] rs = new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println(maxNumberOfFamilies(n, rs));
    }
}
