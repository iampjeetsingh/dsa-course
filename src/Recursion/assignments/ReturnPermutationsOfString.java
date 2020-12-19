package Recursion.assignments;

import java.util.Scanner;

public class ReturnPermutationsOfString {
    public static class Solution {
        public static String[] permutationOfString(String input){
            if(input.length()==1){
                String[] permutations = new String[1];
                permutations[0] = input;
                return permutations;
            }
            String[] permutationsOfSubstring = permutationOfString(input.substring(1));
            String[] permutations = new String[permutationsOfSubstring.length*input.length()];
            int count = 0;
            for(String str : permutationsOfSubstring){
                for(int i=0; i<=str.length(); i++){
                    permutations[count] = str.substring(0, i)+input.charAt(0)+str.substring(i);
                    count++;
                }
            }
            return permutations;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String output[] = Solution.permutationOfString(input);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
