package Queues;

import Linked_List.Node;

public class QueueUsingLL<T> {
    private Node<T> front, rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T front() throws QueueEmptyException {
        if(front==null)
            throw new QueueEmptyException();
        return front.data;
    }

    public void enqueue(T elem) {
        Node<T> node = new Node<>(elem);
        if(size==0){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
        size++;
    }

    public T dequeue() throws QueueEmptyException{
        if(size==0)
            throw new QueueEmptyException();
        T temp = front.data;
        front = front.next;
        size--;
        return temp;
    }
}
