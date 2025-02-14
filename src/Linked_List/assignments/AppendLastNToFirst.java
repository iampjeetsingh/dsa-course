package Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendLastNToFirst {
    public static class Solution {
        public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
            LinkedListNode<Integer> tail = null, temp = head;
            int l = 0;
            while (temp!=null){
                l++;
                tail = temp;
                temp = temp.next;
            }
            temp = head;
            int count = 0;
            while (temp!=null){
                count++;
                if(l-count==n){
                    tail.next = head;
                    head = temp.next;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
            return head;
        }

    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
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

            int n = Integer.parseInt(br.readLine().trim());
            head = Solution.appendLastNToFirst(head, n);
            print(head);

            t -= 1;
        }

    }
}
