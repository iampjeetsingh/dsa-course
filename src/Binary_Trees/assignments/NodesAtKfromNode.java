package Binary_Trees.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NodesAtKfromNode {
    public static class Solution {
        private static int nodesAtK(BinaryTreeNode<Integer> root, int node, int k, int distance){
            int d = distance;
            if(root==null) {
                return -1;
            }

            if(root.data==node)
                d = 0;
            int left = nodesAtK(root.left, node, k, d!=-1? d+1 : d);
            if(d==-1 && left!=-1){
                d = left;
            }
            int right = nodesAtK(root.right, node, k, d!=-1? d+1 : d);
            if(d==-1 && right != -1){
                d = right;
                nodesAtK(root.left, node, k, d+1);
            }

            if(k==d){
                System.out.println(root.data);
            }

            if(distance==-1){
                return d!=-1? d+1 : d;
            }
            return d - 1;
        }
        public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
            nodesAtK(root, node, k, -1);
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
        String[] target_k = br.readLine().trim().split(" ");

        int target = Integer.parseInt(target_k[0].trim());
        int k = Integer.parseInt(target_k[1].trim());

        Solution.nodesAtDistanceK(root, target, k);
    }
}
