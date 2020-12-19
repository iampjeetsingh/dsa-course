package Recursion.assignments;

import java.util.Scanner;

public class SumOfArray {
    public static class Solution {
        private static int sum(int[] input, int start, int end){
            if(start==end)
                return input[start];
            return input[start] + sum(input,start+1,end);
        }

        public static int sum(int input[]) {
            return sum(input,0,input.length-1);
        }
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(Solution.sum(input));
    }
}
