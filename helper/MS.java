package helper;

import java.util.Stack;

public class MS {
    Stack<Long> mainStack = new Stack<>();
    Stack<Long> trackStack = new Stack<>();

    void push(long x) {
        mainStack.push(x);
        if (trackStack.isEmpty())
            trackStack.push(x);
        else
            trackStack.push(Math.min(x, trackStack.peek()));
    }

    void pop() {
        mainStack.pop();
        trackStack.pop();
    }

    long getMin() {
        if (trackStack.isEmpty())
            return -1;
        return trackStack.peek();
    }

    int size() {
        return mainStack.size();
    }

    long top() {
        return mainStack.peek();
    }

    boolean empty() {
        return trackStack.isEmpty();
    }
}

class MQ {
    MS front = new MS();
    MS back = new MS();

    void push(long x) {
        back.push(x);
    }

    void pop() {
        if (front.size() == 0) {
            while (!back.empty()) {
                front.push(back.top());
                back.pop();
            }
        }
        front.pop();
    }

    long getMin() {
        long minVal = Long.MAX_VALUE;
        if (back.size() > 0)
            minVal = Math.min(back.getMin(), minVal);
        if (front.size() > 0)
            minVal = Math.min(front.getMin(), minVal);
        return minVal;
    }

}
