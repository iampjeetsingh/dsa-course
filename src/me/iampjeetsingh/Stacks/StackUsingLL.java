package me.iampjeetsingh.Stacks;

import me.iampjeetsingh.Linked_List.Node;

public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    public StackUsingLL() {
        head = null;
        size = 0;
    }

    public void push(T t){
        Node<T> node = new Node<>(t);
        node.next = head;
        head = node;
        size++;
    }

    public T pop() throws StackEmptyException {
        if(head==null)
            throw new StackEmptyException();
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public T top() throws StackEmptyException {
        if(head==null)
            throw new StackEmptyException();
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
}
