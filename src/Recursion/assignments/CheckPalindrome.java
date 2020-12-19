package Recursion.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CheckPalindrome {
    public static class Solution {
        public static boolean isStringPalindrome(String input) {
            if(input.length()==0)
                return true;
            if(input.charAt(0) != input.charAt(input.length()-1))
                return false;
            return isStringPalindrome(input.substring(Math.min(input.length()-1,1),Math.max(0,input.length()-1)));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(Solution.isStringPalindrome(input));
    }
}
