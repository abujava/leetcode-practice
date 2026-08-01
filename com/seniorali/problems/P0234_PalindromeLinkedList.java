package com.seniorali.problems;

import com.seniorali.utils.ListNode;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/palindrome-linked-list/">234. Palindrome Linked List</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Linked List}, {@code Two Pointers}, {@code Stack}, {@code Recursion}
 */
public class P0234_PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

//    // 12 ms Ultra Slow
//    public static boolean isPalindrome(ListNode head) {
//        var slow = head;
//        var fast = head;
//
//        var stack = new Stack<Integer>();
//        while (fast != null && fast.next != null) {
//            stack.push(slow.val);
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        if (fast != null)
//            slow = slow.next;
//
//        while (!stack.isEmpty()) {
//            if (stack.pop() != slow.val) {
//                return false;
//            }
//            slow = slow.next;
//        }
//        return true;
//    }
}