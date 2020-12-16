package BST.assignments;

import Binary_Trees.BinaryTreeNode;
import Linked_List.assignments.LinkedListNode;
import Queues.QueueEmptyException;
import Queues.QueueUsingLL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BSTtoLL {
    public static class Solution {
        static class LinkedList{
            LinkedListNode<Integer> head, tail;
            public LinkedList(LinkedListNode<Integer> head, LinkedListNode<Integer> tail) {
                this.head = head;
                this.tail = tail;
            }
        }
        public static LinkedList construct(BinaryTreeNode<Integer> root) {
            if(root==null){
                return new LinkedList(null, null);
            }
            LinkedList leftLL = construct(root.left);
            LinkedListNode<Integer> mid = new LinkedListNode<>(root.data);
            if(leftLL.tail==null){
                leftLL.head = mid;
                leftLL.tail = mid;
            }else {
                leftLL.tail.next = mid;
            }
            LinkedList rightLL = construct(root.right);
            mid.next = rightLL.head;
            if(rightLL.tail==null){
                rightLL.tail = mid;
            }
            return new LinkedList(leftLL.head, rightLL.tail);
        }
        public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
            return construct(root).head;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        LinkedListNode<Integer> head = Solution.constructLinkedList(root);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
