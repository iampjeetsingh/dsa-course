package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RemoveMin {
    public static class PQ {

        private ArrayList<Integer> heap;

        public PQ() {
            heap = new ArrayList<Integer>();
        }

        boolean isEmpty() {
            return heap.size() == 0;
        }

        int size() {
            return heap.size();
        }

        int getMin() throws PriorityQueueException {
            if (isEmpty()) {
                // Throw an exception
                throw new PriorityQueueException();
            }
            return heap.get(0);
        }

        void insert(int element) {
            heap.add(element);
            int childIndex = heap.size() - 1;
            int parentIndex = (childIndex - 1) / 2;

            while (childIndex > 0) {
                if (heap.get(childIndex) < heap.get(parentIndex)) {
                    int temp = heap.get(childIndex);
                    heap.set(childIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                } else {
                    return;
                }
            }
        }

        int removeMin() throws PriorityQueueException {
            if(size()==0)
                throw new PriorityQueueException();
            int first = heap.get(0);
            int last = heap.get(heap.size()-1);
            heap.set(0, last);
            heap.remove(heap.size()-1);

            int index = 0;
            int leftIndex = 1;
            int rightIndex = 2;
            while (leftIndex<heap.size()){
                int parent = heap.get(index);
                int leftChild = heap.get(leftIndex);
                int rightChild = rightIndex<heap.size() ? heap.get(rightIndex) : -1;
                if(leftChild<parent && (rightIndex>=heap.size() || leftChild<rightChild)){
                    heap.set(index, leftChild);
                    heap.set(leftIndex, parent);
                    index = leftIndex;
                }else if(rightIndex<heap.size() && rightChild<parent && rightChild<leftChild){
                    heap.set(index, rightChild);
                    heap.set(rightIndex, parent);
                    index = rightIndex;
                }else
                    break;
                leftIndex = 2*index+1;
                rightIndex = 2*index+2;
            }
            return first;
        }
    }

    static class PriorityQueueException extends Exception {

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        PQ pq = new PQ();
        int choice = Integer.parseInt(st.nextToken());
        while(choice != -1) {
            switch(choice) {
                case 1 : // insert
                    int element = Integer.parseInt(st.nextToken());
                    pq.insert(element);
                    break;
                case 2 : // getMin
                    try {
                        System.out.println(pq.getMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 3 : // removeMin
                    try {
                        System.out.println(pq.removeMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 4 : // size
                    System.out.println(pq.size());
                    break;
                case 5 : // isEmpty
                    System.out.println(pq.isEmpty());
                default :
                    return;
            }
            choice = Integer.parseInt(st.nextToken());
        }
    }
}
