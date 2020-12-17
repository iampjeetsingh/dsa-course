package BST.assignments;

import Binary_Trees.BinaryTreeNode;
import Queues.QueueEmptyException;
import Queues.QueueUsingLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestBST {
    public static class Solution {
        private static class LargestBSTReturn{
            boolean isBST;
            int height;
            int maxBSTHeight;
            int max, min;
            public LargestBSTReturn(boolean isBST, int height, int max, int min) {
                this.isBST = isBST;
                this.height = height;
                this.min = min;
                this.max = max;
            }
            public LargestBSTReturn(boolean isBST, int height, int max, int min, int maxBSTHeight) {
                this.isBST = isBST;
                this.height = height;
                this.min = min;
                this.max = max;
                this.maxBSTHeight = maxBSTHeight;
            }
        }
        public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
            LargestBSTReturn output = largestBST(root);
            return output.maxBSTHeight;
        }
        public static LargestBSTReturn largestBST(BinaryTreeNode<Integer> root){
            if(root==null)
                return new LargestBSTReturn(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            LargestBSTReturn leftRes = largestBST(root.left);
            LargestBSTReturn rightRes = largestBST(root.right);
            int min = Math.min(root.data, Math.min(leftRes.min, rightRes.min));
            int max = Math.max(root.data, Math.max(leftRes.max, rightRes.max));
            int height = 1 + Math.max(leftRes.height, rightRes.height);
            int maxBST = Math.max(leftRes.maxBSTHeight, rightRes.maxBSTHeight);
            if(leftRes.max>=root.data){
                return new LargestBSTReturn(false, height, max, min, maxBST);
            }
            if(rightRes.min<root.data)
                return new LargestBSTReturn(false, height, max, min, maxBST);
            boolean isBST = leftRes.isBST && rightRes.isBST;
            LargestBSTReturn output = new LargestBSTReturn(isBST, height, max, min);
            if(isBST){
                output.maxBSTHeight = height;
            }else {
                output.maxBSTHeight = maxBST;
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

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println(Solution.largestBSTSubtree(root));
    }
}
