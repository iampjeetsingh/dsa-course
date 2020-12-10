package me.iampjeetsingh.Linked_List_1.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static class Solution {
        public static boolean areEqual(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
            boolean result = true;
            while (head1!=null && head2!=null){
                if(!head1.data.equals(head2.data)){
                    result = false;
                    break;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return result && head1 == null && head2 == null;
        }
        public static boolean isPalindrome(LinkedListNode<Integer> head) {
            LinkedListNode<Integer> temp = head, revHead = null;
            while (temp!=null){
                LinkedListNode<Integer> node = new LinkedListNode<>(temp.data);
                node.next = revHead;
                revHead = node;
                temp = temp.next;
            }
            return areEqual(revHead, head);
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

            boolean ans = Solution.isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }

    }
}
