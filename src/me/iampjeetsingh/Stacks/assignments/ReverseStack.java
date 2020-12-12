package me.iampjeetsingh.Stacks.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseStack {
    public static class Solution {
        public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
            for(int i=0; i<input.size(); i++){
                int j=i;
                while (j--!=0){
                    extra.push(input.pop());
                }
                int temp = input.pop();
                j=i;
                while (!extra.isEmpty()){
                    input.push(extra.pop());
                }
                input.push(temp);
            }
        }
        public static void reverseStackR(Stack<Integer> input, Stack<Integer> extra) {
            if(input.size()==0 || input.size()==1)
                return;
            int temp = input.pop();
            reverseStackR(input, extra);
            while (!input.isEmpty())
                extra.push(input.pop());
            input.push(temp);
            while (!extra.isEmpty())
                input.push(extra.pop());
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        Stack<Integer> input = new Stack<>();

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input.push(Integer.parseInt(values[i]));
        }

        return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> input = takeInput();
        Stack<Integer> empty = new Stack<>();

        Solution.reverseStack(input, empty);

        while(!input.isEmpty()) {
            System.out.print(input.pop() + " ");
        }

    }
}
