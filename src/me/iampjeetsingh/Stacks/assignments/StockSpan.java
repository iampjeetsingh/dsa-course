package me.iampjeetsingh.Stacks.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {
    public static class Solution {
        public static int[] stockSpan(int[] price) {
            int[] result = new int[price.length];
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<price.length ; i++){
                while (true){
                    if(stack.isEmpty()){
                        result[i] = i+1;
                        stack.push(i);
                        break;
                    }else {
                        int lastSignificantIndex = stack.peek();
                        if(price[lastSignificantIndex]<price[i]){
                            stack.pop();
                        }else {
                            result[i] = i-lastSignificantIndex;
                            stack.push(i);
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(values[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] input = takeInput();

        int[] output = Solution.stockSpan(input);

        printArray(output);

    }
}
