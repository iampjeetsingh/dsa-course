package Queues;


public class QueueUsingArray {
    private int[] data;
    private int size;
    private int front, rear;

    public QueueUsingArray() {
        data = new int[5];
        size = 0;
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int front() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();
        return data[front];
    }

    public void enqueue(int elem) throws QueueFullException {
        if(size==data.length){
            doubleCapacity();
        }
        if(size==0){
            front = 0;
        }
        rear = (rear+1)%data.length;
        data[rear] = elem;
        size++;
    }

    public int dequeue() throws QueueEmptyException{
        if(size==0)
            throw new QueueEmptyException();
        int temp = data[front];
        front = (front+1)%data.length;
        size--;
        if(size==0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

    private void doubleCapacity(){
        int[] temp = data;
        data = new int[temp.length*2];
        int i = front, count = 0;
        while (count!=temp.length){
            data[count++] = temp[i];
            i++;
            if(i==temp.length)
                i=0;
        }
        front = 0;
        rear = count-1;
    }
}
