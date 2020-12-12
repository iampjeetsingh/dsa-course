package me.iampjeetsingh.Stacks.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RedundantBrackets {
    public static class Solution {
        // Wrong Way : TLE in One Case
        public static boolean myCheckRedundantBrackets(String expression) {
            Stack<Integer> stack = new Stack<>();
            String temp = expression;
            for(int i=0; i<temp.length();){
                if(temp.charAt(i)=='('){
                    stack.push(i);
                }
                if(temp.charAt(i)==')'){
                    if(i-stack.peek()==1 || i-stack.peek()==2)
                        return true;
                    int start = stack.pop();
                    int end = i+1;
                    temp = temp.substring(0, start)+temp.substring(Math.min(end, temp.length()));
                    if(temp.isEmpty())
                        break;
                    i = stack.isEmpty() ? 0 : stack.peek();
                }
                i++;
            }
            return false;
        }
        // Correct Way
        public static boolean checkRedundantBrackets(String expression) {
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<expression.length(); i++){
                char c = expression.charAt(i);
                if(c==')'){
                    int count = 0;
                    while (true){
                        char b = stack.pop();
                        if(b=='+' || b=='*' || b=='/' || b=='-')
                            count++;
                        if(b=='(')
                            break;
                    }
                    if(count==0){
                        return true;
                    }
                }else {
                    stack.push(c);
                }
            }
            return false;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();
        System.out.println(Solution.checkRedundantBrackets(expression));
    }
}
