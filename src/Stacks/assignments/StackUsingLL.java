package Stacks.assignments;

import java.util.Scanner;

public class StackUsingLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static class Stack {
        private Node head;
        private int size;

        public Stack() {
            head = null;
            size = 0;
        }

        public void push(int t){
            Node node = new Node(t);
            node.next = head;
            head = node;
            size++;
        }

        public int pop(){
            if(head==null)
                return -1;
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }

        public int top(){
            if(head==null)
                return -1;
            return head.data;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public int getSize() {
            return size;
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
