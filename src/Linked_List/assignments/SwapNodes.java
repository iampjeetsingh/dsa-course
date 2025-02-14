package Linked_List.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapNodes {
    public static class Solution {
        public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
            LinkedListNode<Integer> temp = head, nodeI = null, nodeJ = null;
            int index = 0;
            while (temp!=null){
                if(index==i)
                    nodeI = temp;
                if(index==j)
                    nodeJ = temp;
                index++;
                temp = temp.next;
            }
            if(nodeI!=null && nodeJ!=null){
                int t = nodeI.data;
                nodeI.data = nodeJ.data;
                nodeJ.data = t;
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
            String[] i_j = br.readLine().trim().split("\\s");

            int i = Integer.parseInt(i_j[0]);
            int j = Integer.parseInt(i_j[1]);

            LinkedListNode<Integer> newHead = Solution.swapNodes(head, i, j);
            print(newHead);

            t -= 1;
        }

    }
}
