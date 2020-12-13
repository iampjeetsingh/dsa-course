package Stacks.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumBracketsReversal {
    public static class Solution {
        public static int countBracketReversals(String input) {
            Stack<Character> stack = new Stack<>();
            int rev = 0;
            for(int i=0; i<input.length(); i++){
                char c = input.charAt(i);
                if(c=='{'){
                    stack.push('{');
                }
                if(c=='}'){
                    if(stack.isEmpty()){
                        rev++;
                        stack.push('{');
                    }else
                        stack.pop();
                }
            }
            return stack.size()%2==0 ? (stack.size()/2)+rev : -1;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(Solution.countBracketReversals(br.readLine().trim()));
    }
}
