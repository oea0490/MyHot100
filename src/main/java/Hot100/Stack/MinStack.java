package Hot100.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> xstack;
    Deque<Integer> minstack;
    public MinStack() {
        xstack = new LinkedList<>();
        minstack = new LinkedList<>();
    }

    public void push(int val) {
        xstack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()) {
            minstack.push(val);
        } else {
            minstack.push(minstack.peek());
        }
    }

    public void pop() {
        xstack.pop();
        minstack.pop();
    }

    public int top() {
        return xstack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
