package Recursion.assignments;

import java.util.Scanner;

public class LastIndexOfNumber {
    public static class Solution {
        private static int lastIndex(int[] input, int x, int start){
            if(start==0)
                return x==input[start] ? start : -1;
            if(input[start]==x)
                return start;
            return lastIndex(input,x,start-1);
        }
        public static int lastIndex(int input[], int x) {
            return lastIndex(input,x,input.length-1);
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
        System.out.println(Solution.lastIndex(input, x));
    }
}
