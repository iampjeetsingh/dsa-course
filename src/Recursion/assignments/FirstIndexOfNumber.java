package Recursion.assignments;

import java.util.Scanner;

public class FirstIndexOfNumber {
    public static class Solution {
        private static int firstIndex(int[] input, int x, int start){
            if(start==input.length-1)
                return x==input[start] ? start : -1;
            if(input[start]==x)
                return start;
            return firstIndex(input,x,start+1);
        }

        public static int firstIndex(int input[], int x) {
            return firstIndex(input, x,0);
        }
    }

    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int x = s.nextInt();
        System.out.println(Solution.firstIndex(input, x));
    }
}
