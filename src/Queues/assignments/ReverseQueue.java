package Queues.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static class Solution {
        public static void reverseQueue(Queue<Integer> input) {
            if(input.isEmpty())
                return;
            int temp = input.remove();
            reverseQueue(input);
            input.add(temp);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Queue<Integer> takeInput() throws NumberFormatException, IOException {

        int n = Integer.parseInt(br.readLine().trim());

        String[] values = br.readLine().trim().split(" ");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(values[i]));
        }

        return queue;

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            Queue<Integer> queue = takeInput();
            Solution.reverseQueue(queue);

            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }

            System.out.println();

            t -= 1;
        }
    }
}
