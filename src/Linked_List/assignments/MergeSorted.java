package Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSorted {
    public static class Solution {
        public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
            LinkedListNode<Integer> head = null, tail = null;
            if(head1==null)
                return head2;
            if(head2==null)
                return head1;
            while (head1!=null && head2!=null){
                if(head1.data<head2.data){
                    if(head==null){
                        head = head1;
                        tail = head1;
                        head1 = head1.next;
                        continue;
                    }
                    tail.next = head1;
                    tail = head1;
                    head1 = head1.next;
                }else {
                    if(head==null){
                        head = head2;
                        tail = head2;
                        head2 = head2.next;
                        continue;
                    }
                    tail.next = head2;
                    tail = head2;
                    head2 = head2.next;
                }
            }
            if(head1!=null){
                tail.next = head1;
            }

            if(head2!=null){
                tail.next = head2;
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

            LinkedListNode<Integer> head1 = takeInput();
            LinkedListNode<Integer> head2 = takeInput();

            LinkedListNode<Integer> newHead = Solution.mergeTwoSortedLinkedLists(head1, head2);
            print(newHead);

            t -= 1;
        }

    }
}
