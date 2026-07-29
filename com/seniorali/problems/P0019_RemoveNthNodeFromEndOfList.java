package com.seniorali.problems;

import com.seniorali.utils.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Linked List}, {@code Two Pointers}
 */
public class P0019_RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode delay = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            delay = delay.next;
        }
        delay.next = delay.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        var head = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(head, 2));
    }
}