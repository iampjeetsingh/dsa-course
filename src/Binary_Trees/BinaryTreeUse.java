package Binary_Trees;

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
        BinaryTreeNode<Integer> root = takeInputBetter();
        printTreeDetailed(root);
        System.out.println("Num of nodes : "+numNodes(root));
        System.out.println("Largest : "+largest(root));
    }
}
