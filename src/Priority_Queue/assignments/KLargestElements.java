package Priority_Queue.assignments;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static class Solution {
        public static ArrayList<Integer> kLargest(int input[], int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for(int i=0; i<input.length; i++){
                if(i<k)
                    priorityQueue.add(input[i]);
                else {
                    if(priorityQueue.element()<input[i]){
                        priorityQueue.poll();
                        priorityQueue.add(input[i]);
                    }
                }
            }
            ArrayList<Integer> output = new ArrayList<>();
            while (!priorityQueue.isEmpty()){
                output.add(priorityQueue.remove());
            }
            return output;
        }
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }
        int k = s.nextInt();
        ArrayList<Integer> output = Solution.kLargest(input, k);
        for(int i : output) {
            System.out.println(i);
        }

    }
}
