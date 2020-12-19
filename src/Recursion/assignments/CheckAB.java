package Recursion.assignments;

import java.util.Scanner;

public class CheckAB {
    public static class Solution {
        public static boolean checkAB(String input) {
            if(input.length()==0)
                return true;
            if(input.length()==1 && input.charAt(0)=='a')
                return true;
            if(input.charAt(0)!='a')
                return false;
            if(input.length()<3)
                return checkAB(input.substring(1));
            if(input.charAt(1)=='b' && input.charAt(2)=='b')
                return checkAB(input.substring(3));
            return checkAB(input.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(Solution.checkAB(input));
    }
}
