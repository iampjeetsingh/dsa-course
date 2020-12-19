package Recursion.assignments;

import java.util.Scanner;

public class RemoveDuplicates {
    public static class Solution {
        public static String removeConsecutiveDuplicates(String s) {
            if(s.length()<=1)
                return s;
            if(s.charAt(0)==s.charAt(1)){
                return removeConsecutiveDuplicates(s.charAt(0) + removeConsecutiveDuplicates(s.substring(2)));
            }else{
                return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
            }
        }
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String input = s.next();
        System.out.println(Solution.removeConsecutiveDuplicates(input));
    }
}
