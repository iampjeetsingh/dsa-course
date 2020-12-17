package BST.assignments;

import Binary_Trees.BinaryTreeNode;
import Linked_List.assignments.LinkedListNode;
import Queues.QueueEmptyException;
import Queues.QueueUsingLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LevelWiseLinkedList {
    public static class Solution {
        public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
            if(root==null)
                return null;
            ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();
            LinkedListNode<Integer> head = null, tail = null;
            Queue<BinaryTreeNode<Integer>> primary = new LinkedList<>();
            Queue<BinaryTreeNode<Integer>> secondary = new LinkedList<>();
            primary.add(root);
            while (!primary.isEmpty()){
                BinaryTreeNode<Integer> node = primary.poll();
                LinkedListNode<Integer> llNode = new LinkedListNode<>(node.data);
                if(tail==null){
                    head = llNode;
                    tail = llNode;
                }else {
                    tail.next = llNode;
                    tail = llNode;
                }
                if(node.left!=null){
                    secondary.add(node.left);
                }
                if(node.right!=null){
                    secondary.add(node.right);
                }
                if(primary.isEmpty()){
                    Queue<BinaryTreeNode<Integer>> temp = primary;
                    primary = secondary;
                    secondary = temp;
                    output.add(head);
                    head = null;
                    tail = null;
                }
            }
            return output;
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

    private static void print(LinkedListNode<Integer> temp)
    {
        while(temp != null){
            System.out.print(temp.data + " ") ;
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        ArrayList<LinkedListNode<Integer>> output = Solution.constructLinkedListForEachLevel(root);
        if(output!=null)
        {
            for(LinkedListNode<Integer> head : output){
                print(head);

            }
        }
    }
}
