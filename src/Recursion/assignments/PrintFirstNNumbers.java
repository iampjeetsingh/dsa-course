package Recursion.assignments;

import java.util.Scanner;

public class PrintFirstNNumbers {
    public static class Solution {
        public static void print(int n){
            if(n == 1){
                System.out.print(n + " ");
                return;
            }
            print(n - 1);
            System.out.print(n+" ");
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Solution.print(n);
    }
}
