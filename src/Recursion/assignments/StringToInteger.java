package Recursion.assignments;

import java.util.Scanner;

public class StringToInteger {
    public static class Solution {
        private static int getDigit(char c){
            switch (c){
                case '0' : return 0;
                case '1' : return 1;
                case '2' : return 2;
                case '3' : return 3;
                case '4' : return 4;
                case '5' : return 5;
                case '6' : return 6;
                case '7' : return 7;
                case '8' : return 8;
                case '9' : return 9;
            }
            return -1;
        }

        public static int convertStringToInt(String input){
            if(input.length()==1)
                return getDigit(input.charAt(0));
            return (int) (getDigit(input.charAt(0))*Math.pow(10,input.length()-1)
                    + convertStringToInt(input.substring(1)));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(Solution.convertStringToInt(input));
    }
}
