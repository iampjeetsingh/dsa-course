package BST.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BSTClass {
    public static class BinarySearchTree {
        private BinaryTreeNode<Integer> root;
        private int size;

        private static boolean searchHelper(BinaryTreeNode<Integer> node, int x){
            if(node==null)
                return false;
            if(node.data==x)
                return true;
            if(x< node.data)
                return searchHelper(node.left, x);
            return searchHelper(node.right, x);

        }

        public boolean search(int x){
            return searchHelper(root, x);
        }

        private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x){
            if(node==null){
                return new BinaryTreeNode<>(x);
            }
            if(x>node.data){
                node.right = insertHelper(node.right, x);
            }else {
                node.left = insertHelper(node.left, x);
            }
            return node;
        }

        public void insert(int x){
            root = insertHelper(root, x);
            size++;
        }

        private static class RemoveReturn {
            BinaryTreeNode<Integer> root;
            boolean deleted;
            public RemoveReturn(BinaryTreeNode<Integer> root, boolean deleted) {
                this.root = root;
                this.deleted = deleted;
            }
        }

        private static int minimum(BinaryTreeNode<Integer> node){
            if(node==null)
                return Integer.MAX_VALUE;
            return Math.min(node.data, minimum(node.left));
        }

        private static RemoveReturn removeHelper(BinaryTreeNode<Integer> node, int x){
            if(node==null)
                return new RemoveReturn(null, false);
            boolean deleted;
            if(x<node.data){
                RemoveReturn leftRes = removeHelper(node.left, x);
                node.left = leftRes.root;
                deleted = leftRes.deleted;
            }else if(x>node.data){
                RemoveReturn rightRes = removeHelper(node.right, x);
                node.right = rightRes.root;
                deleted = rightRes.deleted;
            }else {
                if(node.left!=null && node.right!=null){
                    BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(minimum(node.right));
                    newNode.left = node.left;
                    newNode.right = removeHelper(node.right, newNode.data).root;
                    node = newNode;
                }else if(node.right!=null){
                    node = node.right;
                }else {
                    node = node.left;
                }
                deleted = true;
            }
            return new RemoveReturn(node, deleted);
        }

        public boolean remove(int x){
            RemoveReturn removeReturn = removeHelper(root, x);
            root = removeReturn.root;
            if(removeReturn.deleted)
                size--;
            return removeReturn.deleted;
        }

        public int size(){
            return size;
        }

        private static void printTreeHelper(BinaryTreeNode<Integer> node){
            if(node==null)
                return;
            System.out.print(node.data+":");
            if(node.left!=null)
                System.out.print("L:"+node.left.data+",");
            if(node.right!=null)
                System.out.print("R:"+node.right.data);
            System.out.println();
            printTreeHelper(node.left);
            printTreeHelper(node.right);
        }

        public void printTree(){
            printTreeHelper(root);
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree();
        int choice, input;
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            choice = Integer.parseInt(st.nextToken());
            switch (choice) {
                case 1:
                    input = Integer.parseInt(st.nextToken());
                    bst.insert(input);
                    break;
                case 2:
                    input = Integer.parseInt(st.nextToken());
                    bst.remove(input);
                    break;
                case 3:
                    input = Integer.parseInt(st.nextToken());
                    System.out.println(bst.search(input));
                    break;
                default:
                    bst.printTree();
                    break;
            }

        }
    }
}
