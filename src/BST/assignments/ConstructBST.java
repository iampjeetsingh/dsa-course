package BST.assignments;

import Binary_Trees.BinaryTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstructBST {
    public static class Solution {
        public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n, int si, int ei){
            if(ei<si)
                return null;
            int mid = (si+ei)/2;
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
            root.left = SortedArrayToBST(arr, n, si, mid-1);
            root.right = SortedArrayToBST(arr, n, mid+1, ei);
            return root;
        }
        public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
            return SortedArrayToBST(arr, n, 0, arr.length-1);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int arr[] = new int[len];
        if(len>0)
        {
            st = new StringTokenizer(br.readLine());
        }
        for(int i=0;i<len;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        BinaryTreeNode<Integer> ans = Solution.SortedArrayToBST(arr, len);
        preOrder(ans);
    }
}
