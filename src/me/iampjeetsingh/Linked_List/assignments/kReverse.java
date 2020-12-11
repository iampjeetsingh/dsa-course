package me.iampjeetsingh.Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kReverse {
    public static class Solution {
        public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
            if(head==null || head.next==null)
                return head;
            LinkedListNode<Integer> reversedHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return reversedHead;
        }
        public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
            if(k==0)
                return head;
            LinkedListNode<Integer> temp = head, tail = null;
            head = null;
            while (temp!=null && temp.next!=null){
                LinkedListNode<Integer> start = temp, end = temp;
                int n = k;
                while (n--!=0 && temp!=null){
                    end = temp;
                    temp = temp.next;
                }
                end.next = null;
                LinkedListNode<Integer> revHead = reverse(start);
                if(head==null){
                    head = revHead;
                }else{
                    tail.next = revHead;
                }
                tail = start;
                start.next = temp;
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

        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput();
            int k = Integer.parseInt(br.readLine().trim());

            LinkedListNode<Integer> newHead = Solution.kReverse(head, k);
            print(newHead);

            t -= 1;
        }

    }
}
