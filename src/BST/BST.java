package BST;

import Binary_Trees.BinaryTreeNode;

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x){
        if(node==null)
            return false;
        if(node.data==x)
            return true;
        if(x< node.data)
            return isPresentHelper(node.left, x);
        return isPresentHelper(node.right, x);

    }

    public boolean isPresent(int x){
        return isPresentHelper(root, x);
    }

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x){
        if(node==null){
            return new BinaryTreeNode<>(x);
        }
        if(x<node.data){
            node.left = insertHelper(node.left, x);
        }else {
            node.right = insertHelper(node.right, x);
        }
        return node;
    }

    public void insert(int x){
        root = insertHelper(root, x);
    }

    private static class DeleteReturn{
        BinaryTreeNode<Integer> root;
        boolean deleted;
        public DeleteReturn(BinaryTreeNode<Integer> root, boolean deleted) {
            this.root = root;
            this.deleted = deleted;
        }
    }

    private static int minimum(BinaryTreeNode<Integer> node){
        if(node==null)
            return Integer.MAX_VALUE;
        return Math.min(node.data, minimum(node.left));
    }

    private static DeleteReturn deleteHelper(BinaryTreeNode<Integer> node, int x){
        if(node==null)
            return new DeleteReturn(null, false);
        boolean deleted;
        if(x<node.data){
            DeleteReturn leftRes = deleteHelper(node.left, x);
            node.left = leftRes.root;
            deleted = leftRes.deleted;
        }else if(x>node.data){
            DeleteReturn rightRes = deleteHelper(node.right, x);
            node.right = rightRes.root;
            deleted = rightRes.deleted;
        }else {
            if(node.left!=null && node.right!=null){
                BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(minimum(node.right));
                newNode.left = node.left;
                newNode.right = deleteHelper(node.right, newNode.data).root;
                node = newNode;
            }else if(node.right!=null){
                node = node.right;
            }else {
                node = node.left;
            }
            deleted = true;
        }
        return new DeleteReturn(node, deleted);
    }

    public boolean delete(int x){
        DeleteReturn deleteReturn = deleteHelper(root, x);
        root = deleteReturn.root;
        return deleteReturn.deleted;
    }

    public int size(){
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        if(node==null)
            return;
        System.out.print(node.data+": ");
        if(node.left!=null)
            System.out.print("L"+node.left.data+", ");
        if(node.right!=null)
            System.out.print("R"+node.right.data);
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }

    public void printTree(){
        printTreeHelper(root);
    }
}
