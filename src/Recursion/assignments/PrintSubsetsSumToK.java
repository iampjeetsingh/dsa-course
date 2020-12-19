package Recursion.assignments;

import java.util.Scanner;

public class PrintSubsetsSumToK {
    public static class Solution {
        private static void printSubsets(int input[], int si, String str, int sum, int k) {
            if(input.length-si==0){
                if(sum==k)
                    System.out.println(str);
                return;
            }
            printSubsets(input, si+1, str, sum, k);
            printSubsets(input, si+1, str+input[si]+" ", sum+input[si], k);
        }

        public static void printSubsetsSumTok(int input[], int k) {
            printSubsets(input, 0, "", 0, k);
        }
    }

    static Scanner s = new Scanner(System.in);
    public static int[] takeInput() {
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int k = s.nextInt();
        Solution.printSubsetsSumTok(input, k);
    }
}
