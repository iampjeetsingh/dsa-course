package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaxPriorityQueue {
    public static class PQ {
        private ArrayList<Integer> heap;
        public PQ(){
            heap = new ArrayList<>();
        }

        boolean isEmpty() {
            return heap.isEmpty();
        }

        int getSize() {
            return heap.size();
        }

        int getMax() {
            if(getSize()==0)
                return Integer.MAX_VALUE;
            return heap.get(0);
        }

        void insert(int element) {
            int index = getSize();
            heap.add(element);
            while (index>0){
                int parentIndex = (index-1)/2;
                int parent = heap.get(parentIndex);
                int current = heap.get(index);
                if(parent<current){
                    heap.set(parentIndex, current);
                    heap.set(index, parent);
                    index = parentIndex;
                }else
                    break;
            }
        }

        int removeMax() {
            if(getSize()==0)
                return Integer.MAX_VALUE;
            int first = heap.get(0);
            int last = heap.get(heap.size()-1);
            heap.set(0, last);
            heap.remove(heap.size()-1);
            int index = 0;
            int leftIndex = 1;
            int rightIndex = 2;
            while (leftIndex<heap.size()){
                int current = heap.get(index);
                int maxIndex = index;
                int leftChild = heap.get(leftIndex);
                if(leftChild>current)
                    maxIndex = leftIndex;
                if(rightIndex<heap.size()){
                    int rightChild = heap.get(rightIndex);
                    if(rightChild>heap.get(maxIndex))
                        maxIndex = rightIndex;
                }
                if(maxIndex==index)
                    break;
                int maxItem = heap.get(maxIndex);
                heap.set(maxIndex, current);
                heap.set(index, maxItem);
                index = maxIndex;
                leftIndex = 2*index+1;
                rightIndex = 2*index+2;
            }
            return first;
        }
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
                case 2 : // getMax
                    System.out.println(pq.getMax());
                    break;
                case 3 : // removeMax
                    System.out.println(pq.removeMax());
                    break;
                case 4 : // size
                    System.out.println(pq.getSize());
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
