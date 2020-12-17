package BST.assignments;

import Binary_Trees.BinaryTreeNode;
import Queues.QueueEmptyException;
import Queues.QueueUsingLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PairSumInBST {
    public static class Solution {
        private static HashMap<Integer, Integer> map = new HashMap<>();
        private static boolean isPresent(BinaryTreeNode<Integer> root, int s){
            if(root==null)
                return false;
            if(root.data==s)
                return true;
            if(s<root.data)
                return isPresent(root.left, s);
            return isPresent(root.right, s);
        }
        public static void printNodesSumToS(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> root, int s) {
            if(node==null)
                return;
            if(s<= node.data){
                printNodesSumToS(node.left, root, s);
            }else {
                if(isPresent(root,s-node.data)){
                    int a = Math.min(node.data, s- node.data);
                    int b = Math.max(node.data, s- node.data);
                    if(a!=b && !map.containsKey(a)){
                        System.out.println(a+" "+b);
                        map.put(a, b);
                    }
                }
                printNodesSumToS(node.left, root, s);
                printNodesSumToS(node.right, root, s);
            }
        }
        public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
            printNodesSumToS(root, root, s);
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
        int s = Integer.parseInt(br.readLine());
        Solution.printNodesSumToS(root,s);
    }
}
