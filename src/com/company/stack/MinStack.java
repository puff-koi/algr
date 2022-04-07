package com.company.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
        minStack.offer(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.offer(val);
        minStack.offer(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
return minStack.peek();
    }
}
