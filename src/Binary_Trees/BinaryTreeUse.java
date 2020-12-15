package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root==null)
            return;
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        if(root==null)
            return;
        System.out.print(root.data+": ");
        if(root.left!=null)
            System.out.print("L"+root.left.data+", ");
        if(root.right!=null)
            System.out.print("R"+root.right.data);
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    private static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> takeInput(){
        System.out.print("Enter root data : ");
        int data = sc.nextInt();
        if(data==-1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeInput();
        root.right = takeInput();
        return root;
    }

    private static BinaryTreeNode<Integer> takeInputBetter(int parentData, boolean left){
        if(parentData==-1)
            System.out.print("Enter root data : ");
        else
            System.out.print("Enter "+(left?"left":"right")+" child of "+parentData+" : ");
        int data = sc.nextInt();
        if(data==-1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeInputBetter(root.data, true);
        root.right = takeInputBetter(root.data, false);
        return root;
    }
    public static BinaryTreeNode<Integer> takeInputBetter(){
        return takeInputBetter(-1, false);
    }

    public static int numNodes(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if(root==null)
            return -1;
        return Math.max(root.data , Math.max(largest(root.left), largest(root.right)));
    }

    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        return numLeaves(root.left) + numLeaves(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int depth){
        if(root==null)
            return;
        if(depth==0){
            System.out.print(root.data+" ");
            return;
        }
        printAtDepthK(root.left, depth-1);
        printAtDepthK(root.right, depth-1);
    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null || (root.left==null && root.right==null))
            return null;
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    public static int height(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if(root==null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(rightHeight-leftHeight)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root==null)
            return new BalancedTreeReturn(0, true);
        BalancedTreeReturn leftRes = isBalancedBetter(root.left);
        BalancedTreeReturn rightRes = isBalancedBetter(root.right);
        boolean isBalanced = leftRes.isBalanced && rightRes.isBalanced && Math.abs(leftRes.height- rightRes.height)<=1;
        int height = 1 + Math.max(leftRes.height,rightRes.height);
        return new BalancedTreeReturn(height, isBalanced);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        int rootData = sc.nextInt();
        if(rootData==-1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> node = pendingChildren.poll();
            System.out.print("Enter left child of "+node.data+" : ");
            int leftData = sc.nextInt();
            if(leftData!=-1){
                BinaryTreeNode<Integer> left = new BinaryTreeNode<>(leftData);
                node.left = left;
                pendingChildren.add(left);
            }
            System.out.print("Enter right child of "+node.data+" : ");
            int rightData = sc.nextInt();
            if(rightData!=-1){
                BinaryTreeNode<Integer> right = new BinaryTreeNode<>(rightData);
                node.right = right;
                pendingChildren.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//        root.left = rootLeft;
//        root.right = rootRight;
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//        rootLeft.right = twoRight;
//        rootRight.left = threeLeft;
//        BinaryTreeNode<Integer> root = takeInputBetter();
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTreeDetailed(root);
        System.out.println("Num of nodes : "+numNodes(root));
        System.out.println("Largest : "+largest(root));
        System.out.println("Leaves : "+numLeaves(root));
//        printAtDepthK(root, 1);
        System.out.println("Balanced : "+isBalancedBetter(root).isBalanced);
    }
}
