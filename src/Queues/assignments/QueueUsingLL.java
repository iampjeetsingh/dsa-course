package Queues.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QueueUsingLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue {
        private Node front, rear;
        private int size;
        public Queue() {
            front = null;
            rear = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public void enqueue(int data) {
            Node node = new Node(data);
            if(size==0){
                front = node;
            }else {
                rear.next = node;
            }
            rear = node;
            size++;
        }

        public int dequeue() {
            if(size==0)
                return -1;
            int temp = front.data;
            front = front.next;
            size--;
            return temp;
        }

        public int front() {
            if(size==0)
                return -1;
            return front.data;
        }
    }

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Queue queue = new Queue();

        int q = s.nextInt();

        while (q > 0) {
            int choice, input;
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    input = s.nextInt();
                    queue.enqueue(input);
                    break;

                case 2:
                    System.out.println(queue.dequeue());
                    break;

                case 3:
                    System.out.println(queue.front());
                    break;

                case 4:
                    System.out.println(queue.getSize());
                    break;

                default:
                    System.out.println((queue.isEmpty()) ? "true" : "false");
            }

            q -= 1;
        }

    }
}
