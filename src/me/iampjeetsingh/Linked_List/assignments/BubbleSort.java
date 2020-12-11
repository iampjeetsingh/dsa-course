package me.iampjeetsingh.Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
    public static class Solution {
        public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
            LinkedListNode<Integer> i = head, j;
            while (i!=null){
                j = i.next;
                while (j!=null){
                    if(i.data>j.data){
                        int t = i.data;
                        i.data = j.data;
                        j.data = t;
                    }
                    j = j.next;
                }
                i = i.next;
            }
            return head;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        LinkedListNode<Integer> head = takeInput();

        head = Solution.bubbleSort(head);
        print(head);
    }
}
