package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BuyTheTicket {
    public static class Solution {
        private static class Person{
            int index;
            int priority;

            public Person(int index, int priority) {
                this.index = index;
                this.priority = priority;
            }
        }
        public static int buyTicket(int input[], int k) {
            Queue<Person> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<input.length; i++){
                priorityQueue.add(input[i]);
                queue.add(new Person(i, input[i]));
            }
            int time = 0;
            while (!queue.isEmpty()){
                if(priorityQueue.element()==queue.peek().priority){
                    time++;
                    if(queue.element().index==k)
                        break;
                    priorityQueue.remove();
                    queue.remove();
                }else {
                    queue.add(queue.remove());
                }
            }
            return time;
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
        System.out.println(Solution.buyTicket(input, k));
    }
}
