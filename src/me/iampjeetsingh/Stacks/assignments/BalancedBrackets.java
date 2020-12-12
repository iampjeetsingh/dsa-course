package me.iampjeetsingh.Stacks.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedBrackets {
    public static class Solution {
        public static boolean isBalanced(String expression) {
            Stack<Character> stack = new Stack<>();
            for(char c : expression.toCharArray()){
                try {
                    switch (c){
                        case '(':
                        case '{':
                        case '[':
                            stack.push(c);
                            break;
                        case ')':
                            if(stack.peek()=='(')
                                stack.pop();
                            else
                                return false;
                            break;
                        case '}':
                            if(stack.peek()=='{')
                                stack.pop();
                            else
                                return false;
                            break;
                        case ']':
                            if(stack.peek()=='[')
                                stack.pop();
                            else
                                return false;
                            break;
                    }
                }catch (Exception e){
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(Solution.isBalanced(expression));
    }
}
