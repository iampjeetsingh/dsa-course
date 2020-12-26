package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KthLargestElement {
    public static class Solution {
        public static int kthLargest(int n, int[] input, int k) {
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
            return priorityQueue.element();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(Solution.kthLargest(n, input, k));
    }
}
