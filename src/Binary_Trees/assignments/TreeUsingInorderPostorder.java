package Binary_Trees.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUsingInorderPostorder {
    public static class Solution {
        public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder, int siPo, int eiPo, int siIo, int eiIo) {
            if(siIo==eiIo)
                return new BinaryTreeNode<>(inOrder[siIo]);
            if(siIo>eiIo)
                return null;
            int rootData = postOrder[eiPo];
            int rootIndex = -1;
            for(int i=siIo; i<=eiIo; i++){
                if(rootData==inOrder[i]) {
                    rootIndex = i;
                    break;
                }
            }
            if(rootIndex==-1)
                return null;
            int sizeOfLeft = rootIndex - siIo;

            int siIoLeft = siIo;
            int eiIoLeft = siIo + sizeOfLeft - 1;

            int siIoRight = siIo + sizeOfLeft + 1;
            int eiIoRight = eiIo;

            int siPoLeft = siPo;
            int eiPoLeft = siPo + sizeOfLeft - 1;

            int siPoRight = siPo + sizeOfLeft;
            int eiPoRight = eiPo - 1;

            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
            root.left = buildTree(postOrder, inOrder, siPoLeft, eiPoLeft, siIoLeft, eiIoLeft);
            root.right = buildTree(postOrder, inOrder, siPoRight, eiPoRight, siIoRight, eiIoRight);
            return root;
        }
        public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
            return buildTree(postOrder, inOrder, 0,postOrder.length-1,0,inOrder.length-1);
        }
    }

    static class Pair {
        int[] postOrder;
        int[] inOrder;

        public Pair(int[] postOrder, int[] inOrder) {
            this.postOrder = postOrder;
            this.inOrder = inOrder;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int pre[] = new int[n];
        int in[] = new int[n];

        String[] postOrder = br.readLine().trim().split(" ");
        String[] inOrder = br.readLine().trim().split(" ");


        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(postOrder[i].trim());
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

        int[] postOrder = input.postOrder;
        int[] inOrder = input.inOrder;

        BinaryTreeNode<Integer> root = Solution.buildTree(postOrder, inOrder);

        printLevelWise(root);

    }
}
