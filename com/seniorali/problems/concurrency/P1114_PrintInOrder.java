package com.seniorali.problems.concurrency;

/**
 * Problem: <a href="https://leetcode.com/problems/print-in-order">1114. Print in Order</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Concurrency</code>
 */
public class P1114_PrintInOrder {
    class Foo {
        private boolean firstDone;
        private boolean secondDone;

        public Foo() {
            firstDone = false;
            secondDone = false;
        }

        public synchronized
        void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            firstDone = true;
            notifyAll();
        }

        public synchronized
        void second(Runnable printSecond) throws InterruptedException {
            while (!firstDone) wait();
            printSecond.run();
            secondDone = true;
            notifyAll();
        }

        public synchronized
        void third(Runnable printThird) throws InterruptedException {
            while (!secondDone) wait();
            printThird.run();
        }
    }
}
