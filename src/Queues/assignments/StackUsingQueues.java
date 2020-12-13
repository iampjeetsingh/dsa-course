package Queues.assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {
    public static class Stack {
        private Queue<Integer> queue, helper;
        public Stack() {
            queue = new LinkedList<>();
            helper = new LinkedList<>();
        }

        public int getSize() {
            return queue.size();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void push(int element) {
            helper.add(element);
            while (!queue.isEmpty()){
                helper.add(queue.remove());
            }
            while (!helper.isEmpty()){
                queue.add(helper.remove());
            }
        }

        public int pop() {
            try {
                return queue.poll();
            }catch (NullPointerException e){
                return -1;
            }
        }

        public int top() {
            try {
                return queue.peek();
            }catch (NullPointerException e){
                return -1;
            }
        }
    }


    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Stack stack = new Stack();

        int q = s.nextInt();

        while (q > 0) {
            int choice, input;
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    input = s.nextInt();
                    stack.push(input);
                    break;

                case 2:
                    System.out.println(stack.pop());
                    break;

                case 3:
                    System.out.println(stack.top());
                    break;

                case 4:
                    System.out.println(stack.getSize());
                    break;

                default:
                    System.out.println((stack.isEmpty()) ? "true" : "false");
            }

            q -= 1;
        }

    }
}
