package me.iampjeetsingh.Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenAfterOdd {
    public static class Solution {
        public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
            LinkedListNode<Integer> oddHead = null, evenHead = null, oddTail = null, evenTail = null;
            while (head!=null){
                if(head.data%2==0){
                    if(evenHead==null){
                        evenHead = head;
                    }else {
                        evenTail.next = head;
                    }
                    evenTail = head;
                    head = head.next;
                    evenTail.next = null;
                }else {
                    if(oddHead==null){
                        oddHead = head;
                    }else {
                        oddTail.next = head;
                    }
                    oddTail = head;
                    head = head.next;
                    oddTail.next = null;
                }
            }
            if(oddTail!=null)
                oddTail.next = evenHead;
            else
                return evenHead;
            return oddHead;
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

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();

            LinkedListNode<Integer> newHead = Solution.evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }

}
