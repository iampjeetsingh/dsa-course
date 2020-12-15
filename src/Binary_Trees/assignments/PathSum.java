package Binary_Trees.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathSum {
    public static class Solution {
        private static void rootToLeafPathSum(BinaryTreeNode<Integer> root, int k, String toPrint){
            if(root==null)
                return;
            if(root.left==null && root.right==null && k-root.data==0){
                System.out.println(toPrint+root.data);
                return;
            }
            rootToLeafPathSum(root.left, k-root.data, toPrint+root.data+" ");
            rootToLeafPathSum(root.right, k-root.data, toPrint+root.data+" ");
        }
        public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
            rootToLeafPathSum(root, k, "");
        }
    }

    static class QueueEmptyException extends Exception {

    }

    static class QueueUsingLL<T> {

        class Node<T> {
            T data;
            Node<T> next;
            Node(T data){
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            if(size == 0){
                return true;
            }
            return false;
        }

        public T front() throws QueueEmptyException{
            if(size == 0){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }

            return head.data;
        }


        public void enqueue(T element){
            Node<T> newNode = new Node<T>(element);

            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        public T dequeue() throws QueueEmptyException{
            if(head == null){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if(head == tail){
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
        QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        int start = 0;

        String[] nodeDatas = br.readLine().trim().split(" ");

        if (nodeDatas.length == 1) {
            return null;
        }

        int rootData = Integer.parseInt(nodeDatas[start]);
        start += 1;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }

            int leftChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(leftChildData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }

            int rightChildData = Integer.parseInt(nodeDatas[start]);
            start += 1;

            if(rightChildData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BinaryTreeNode<Integer> root = takeInput();
        int k = Integer.parseInt(br.readLine().trim());

        Solution.rootToLeafPathsSumToK(root, k);
    }
}
