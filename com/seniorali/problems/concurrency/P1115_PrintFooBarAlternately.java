package com.seniorali.problems.concurrency;

/**
 * Problem: <a href="https://leetcode.com/problems/print-foobar-alternately">1115. Print FooBar Alternately</a><br/>
 * <p>
 * Difficulty: <code>Medium</code>
 * <p>
 * Topics: <code>Concurrency</code>
 */
public class P1115_PrintFooBarAlternately {
    class FooBar {
        private int n;
        private boolean fooTurn;

        public FooBar(int n) {
            this.n = n;
            fooTurn = true;
        }

        public synchronized
        void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!fooTurn) wait();
                printFoo.run();
                fooTurn = false;
                notifyAll();
            }
        }

        public synchronized
        void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (fooTurn) wait();
                printBar.run();
                fooTurn = true;
                notifyAll();
            }
        }
    }
}
