package com.seniorali.problems;

import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/implement-queue-using-stacks/">232. Implement Queue using Stacks</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Stack}, {@code Design}, {@code Queue}
 */
public class P0232_ImplementQueueUsingStacks {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public P0232_ImplementQueueUsingStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) // Amortized O(1)
            while (!s1.isEmpty())
                s2.push(s1.pop());
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) //  Amortized O(1)
            while (!s1.isEmpty())
                s2.push(s1.pop());
        return s2.pop();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
