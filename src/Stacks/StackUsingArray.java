package Stacks;

public class StackUsingArray {
    private int[] data;
    private int topIndex;

    public StackUsingArray() {
        data = new int[10];
        topIndex = -1;
    }

    public StackUsingArray(int capacity) {
        data = new int[capacity];
        topIndex = -1;
    }

    public void push(int i) throws StackFullException {
        if(topIndex==data.length-1){
            doubleCapacity();
        }
        data[++topIndex] = i;
    }

    public int pop() throws StackEmptyException {
        if(topIndex==-1)
            throw new StackEmptyException();
        return data[topIndex--];
    }

    public int top() throws StackEmptyException {
        if(topIndex==-1)
            throw new StackEmptyException();
        return -1;
    }

    public int size() {
        return topIndex+1;
    }

    public boolean isEmpty() {
        return topIndex==-1;
    }

    private void doubleCapacity(){
        int[] temp = data;
        data = new int[data.length*2];
        for(int i=0; i<temp.length; i++)
            data[i] = temp[i];
    }
}
