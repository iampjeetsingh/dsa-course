package Priority_Queue;

import java.util.PriorityQueue;

public class PQUse {
    public static void main(String[] args) throws PriorityQueueException {
        /*PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.insert(8, 8);
        priorityQueue.printHeap();
        priorityQueue.insert(10,10);
        priorityQueue.printHeap();
        priorityQueue.insert(5,5);
        priorityQueue.printHeap();
        priorityQueue.insert(3,3);
        priorityQueue.printHeap();
        priorityQueue.insert(2,2);
        priorityQueue.printHeap();
        System.out.println(priorityQueue.removeMin());
        priorityQueue.printHeap();
        System.out.println(priorityQueue.removeMin());
        priorityQueue.printHeap();*/
        int[] arr = {4,3,7,6,9,10,1,2};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : arr)
            priorityQueue.add(i);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.peek());
            priorityQueue.remove();
        }
    }
}
