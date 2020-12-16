package BST.assignments;

import Binary_Trees.BinaryTreeNode;
import Queues.QueueEmptyException;
import Queues.QueueUsingLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReplaceWithSum {
    public static class Solution {
        private static int replace(BinaryTreeNode<Integer> root, int sum){
            if(root==null)
                return sum;
            sum = replace(root.right, sum);
            sum += root.data;
            root.data = sum;
            return replace(root.left, sum);
        }
        public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
            replace(root, 0);
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

    public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) throws QueueEmptyException {
        if (root == null)
            return;
        QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
        q.enqueue(root);
        q.enqueue(null);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> first = q.front();
            q.dequeue();
            if (first == null) {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println();
                q.enqueue(null);
                continue;
            }
            System.out.print(first.data + " ");
            if (first.left != null) {
                q.enqueue(first.left);
            }
            if (first.right != null) {
                q.enqueue(first.right);
            }
        }
    }

    public static void main(String[] args) throws IOException, QueueEmptyException {
        BinaryTreeNode<Integer> root = takeInput();
        Solution.replaceWithLargerNodesSum(root);
        printLevelWiseAtDiffLevel(root);
    }
}
