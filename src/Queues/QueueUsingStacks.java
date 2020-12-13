package Queues;

import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> helper, stack;

    public QueueUsingStacks() {
        helper = new Stack<>();
        stack = new Stack<>();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public T front() throws QueueEmptyException {
        return stack.peek();
    }

    public void enqueue(T elem) {
        while (!stack.isEmpty())
            helper.push(stack.pop());
        helper.push(elem);
        while (!helper.isEmpty())
            stack.push(helper.pop());
    }

    public T dequeue() throws QueueEmptyException{
        return stack.pop();
    }
}
