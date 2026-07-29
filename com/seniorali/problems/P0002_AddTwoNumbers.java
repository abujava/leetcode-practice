package com.seniorali.problems;

import com.seniorali.utils.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Linked List}, {@code Math}, {@code Recursion}
 */
public class P0002_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int prevMod) {
        if (l1 == null && l2 == null && prevMod == 0) return null;

        var l1Val = l1 == null ? 0 : l1.val;
        var l2Val = l2 == null ? 0 : l2.val;

        var sum = (l1Val + l2Val + prevMod);
        return new ListNode(
                sum % 10,
                addTwoNumbers(
                        l1 == null ? null : l1.next,
                        l2 == null ? null : l2.next,
                        sum / 10
                )
        );
    }
}