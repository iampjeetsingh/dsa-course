package Recursion.assignments;

import java.util.Scanner;

public class PrintSubsetsOfArray {
    public static class Solution {
        private static void printSubsets(int input[], int si, String str) {
            if(input.length-si==0){
                System.out.println(str);
                return;
            }
            printSubsets(input, si+1, str);
            printSubsets(input, si+1, str+input[si]+" ");
        }
        public static void printSubsets(int input[]) {
            printSubsets(input, 0, "");
        }
    }


    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        Solution.printSubsets(input);
    }
}
