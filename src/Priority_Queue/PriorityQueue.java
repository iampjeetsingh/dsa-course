package Priority_Queue;

import java.util.ArrayList;

public class PriorityQueue<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> element = new Element<>(priority, value);
        int index = heap.size();
        heap.add(element);
        while (index>0){
            int parentIndex = (index-1)/2;
            Element<T> parent = heap.get(parentIndex);
            if(parent.priority > element.priority){
                heap.set(parentIndex, element);
                heap.set(index, parent);
                index = parentIndex;
            }else {
                break;
            }
        }
    }

    public void printHeap(){
        for (Element<T> element : heap){
            System.out.print(element.value+" ");
        }
        System.out.println();
    }

    public T getMin() throws PriorityQueueException {
        if(size()==0)
            throw new PriorityQueueException();
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException {
        if(size()==0)
            throw new PriorityQueueException();
        Element<T> first = heap.get(0);
        Element<T> last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.remove(heap.size()-1);
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex<heap.size()){
            Element<T> parent = heap.get(parentIndex);
            Element<T> left = heap.get(leftChildIndex);
            Element<T> right = null;
            if(rightChildIndex<heap.size()) {
                right = heap.get(rightChildIndex);
            }
            if(left.priority<parent.priority && (right==null || left.priority<right.priority)){
                heap.set(parentIndex, left);
                heap.set(leftChildIndex, parent);
                parentIndex = leftChildIndex;
            }else if(right!=null && right.priority<parent.priority && right.priority<last.priority){
                heap.set(parentIndex, right);
                heap.set(rightChildIndex, parent);
                parentIndex = rightChildIndex;
            }else {
                break;
            }
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
        return first.value;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
