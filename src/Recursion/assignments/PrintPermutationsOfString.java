package Recursion.assignments;

import java.util.Scanner;

public class PrintPermutationsOfString {
    public static class Solution {
        private static void permutations(String input, String toPrint){
            if(input.length()==0){
                System.out.println(toPrint);
                return;
            }
            char c = input.charAt(0);
            for (int i=0; i<=toPrint.length(); i++){
                permutations(input.substring(1), toPrint.substring(0,i)+c+toPrint.substring(i));
            }
        }
        public static void permutations(String input){
            permutations(input, "");
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Solution.permutations(input);
    }
}
