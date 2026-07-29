package com.seniorali.problems;

import com.seniorali.utils.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-linked-list-elements/">203. Remove Linked List Elements</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Linked List}, {@code Recursion}
 */
public class P0203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        var result = new ListNode(-1);
        var temp = result;
        while (head != null){
            if (head.val != val){
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }

        return result.next;
    }
}
