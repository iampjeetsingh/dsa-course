package Recursion.assignments;

import java.util.Scanner;

public class CheckNumberInArray {
    public static class Solution {
        private static boolean checkNumber(int[] input, int x, int start, int end){
            if(start==end)
                return x==input[start];
            if(input[start]==x)
                return true;
            return checkNumber(input,x,start+1,end);
        }

        public static boolean checkNumber(int input[], int x) {
            return checkNumber(input, x,0,input.length-1);
        }
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(Solution.checkNumber(input, x));
    }
}
