package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KSmallestElements {
    public static class Solution {
        public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<input.length; i++){
                if(i<k)
                    priorityQueue.add(input[i]);
                else {
                    if(priorityQueue.element()>input[i]){
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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> output = Solution.kSmallest(n, input, k);
        Collections.sort(output);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
