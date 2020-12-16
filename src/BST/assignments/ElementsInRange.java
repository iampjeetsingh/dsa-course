package BST.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ElementsInRange {
    public static class Solution {
        public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2){
            if(root==null)
                return;
            if(root.data>k2){
                elementsInRangeK1K2(root.left, k1, k2);
            }else if(root.data<k1){
                elementsInRangeK1K2(root.right, k1, k2);
            }else {
                elementsInRangeK1K2(root.left, k1, k2);
                System.out.print(root.data+" ");
                elementsInRangeK1K2(root.right, k1, k2);
            }
        }
    }

    static class QueueEmptyException extends Exception {
    }

    static class QueueUsingLL<T> {

        class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        public T front() throws QueueEmptyException {
            if (size == 0) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }

            return head.data;
        }

        public void enqueue(T element) {
            Node<T> newNode = new Node<T>(element);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        public T dequeue() throws QueueEmptyException {
            if (head == null) {
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if (head == tail) {
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
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
        st = new StringTokenizer(br.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        Solution.elementsInRangeK1K2(root, k1, k2);
    }
}
