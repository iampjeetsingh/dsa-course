package Binary_Trees.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUsingInorderPreorder {
    public static class Solution {
        public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
            if(preOrder.length==0)
                return null;
            if(preOrder.length==1)
                return new BinaryTreeNode<>(preOrder[0]);
            int rootData = preOrder[0];
            int rootIndexInInorder=0;
            for(;rootIndexInInorder<inOrder.length;rootIndexInInorder++){
                if(inOrder[rootIndexInInorder]==rootData)
                    break;
            }
            int treeSize = inOrder.length;
            int leftTreeSize = rootIndexInInorder;
            // Generating Inorders of subtrees
            int[] leftInorder = new int[leftTreeSize];
            int[] rightInorder = new int[treeSize-leftTreeSize-1];
            for(int i=0; i<inOrder.length; i++){
                if(i<leftTreeSize){
                    leftInorder[i] = inOrder[i];
                }
                if(i>leftTreeSize){
                    rightInorder[i-leftTreeSize-1] = inOrder[i];
                }
            }
            // Generating preorders of subtrees
            int[] leftPreorder = new int[leftTreeSize];
            int[] rightPreorder = new int[treeSize-leftTreeSize-1];
            for(int i=1; i<preOrder.length; i++){
                if(i<=leftTreeSize){
                    leftPreorder[i-1] = preOrder[i];
                }
                if(i>leftTreeSize){
                    rightPreorder[i-leftTreeSize-1] = preOrder[i];
                }
            }
            // Generate and link nodes
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
            return root;
        }
    }

    static class Pair {
        int[] preOrder;
        int[] inOrder;

        public Pair(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;
        }

    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int pre[] = new int[n];
        int in[] = new int[n];

        String[] preOrder = br.readLine().trim().split(" ");
        String[] inOrder = br.readLine().trim().split(" ");


        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(preOrder[i].trim());
            in[i] = Integer.parseInt(inOrder[i].trim());
        }

        return new Pair(pre, in);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();


            if (frontNode == null) {
                System.out.println();

                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }

            } else {
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }

                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }

        }

    }
    public static void main(String[] args) throws NumberFormatException, IOException {

        Pair input = takeInput();

        int[] preOrder = input.preOrder;
        int[] inOrder = input.inOrder;

        BinaryTreeNode<Integer> root = Solution.buildTree(preOrder, inOrder);

        printLevelWise(root);

    }
}
