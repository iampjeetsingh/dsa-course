package BST;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTreeUse {
    public static boolean searchBST(BinaryTreeNode<Integer> root, int k) {
        if (root==null)
            return false;
        if(root.data==k)
            return true;
        if(k<root.data)
            return searchBST(root.left, k);
        return searchBST(root.right, k);
    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if(root==null)
            return Integer.MAX_VALUE;
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private static int maximum(BinaryTreeNode<Integer> root) {
        if(root==null)
            return Integer.MIN_VALUE;
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root==null)
            return true;
        int leftMax = maximum(root.left);
        if(leftMax>=root.data){
            return false;
        }
        int rightMin = minimum(root.right);
        if(rightMin<root.data)
            return false;
        return isBST(root.left) && isBST(root.right);
    }

    public static IsBSTReturn isBSTBetter(BinaryTreeNode<Integer> root){
        if(root==null)
            return new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        IsBSTReturn leftRes = isBSTBetter(root.left);
        IsBSTReturn rightRes = isBSTBetter(root.right);
        int min = Math.min(root.data, Math.min(leftRes.min, rightRes.min));
        int max = Math.max(root.data, Math.max(leftRes.max, rightRes.max));
        if(leftRes.max>=root.data){
            return new IsBSTReturn(max, min, false);
        }
        if(rightRes.min<root.data)
            return new IsBSTReturn(max, min, false);
        boolean isBST = leftRes.isBST && rightRes.isBST;
        return new IsBSTReturn(max, min, isBST);
    }

    public static boolean isBSTBest(BinaryTreeNode<Integer> root, int max, int min){
        if(root==null)
            return true;
        if(root.data>max || root.data<=min){
            return false;
        }
        return isBSTBest(root.left, root.data, min) && isBSTBest(root.right, max, root.data);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Binary_Trees.BinaryTreeUse.takeInputBetter();
//        System.out.println(searchBST(root, 3));
//        System.out.println(searchBST(root, 30));
        System.out.println(isBSTBest(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
