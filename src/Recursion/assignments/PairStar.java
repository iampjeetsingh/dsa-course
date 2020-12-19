package Recursion.assignments;

import java.util.Scanner;

public class PairStar {
    public static class Solution {
        public static String addStars(String s) {
            if(s.length()<=1)
                return s;
            if(s.charAt(0)==s.charAt(1))
                return addStars( s.charAt(0)+"*"+s.charAt(1)+ addStars(s.substring(2)) );
            else
                return s.charAt(0)+ addStars(s.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(Solution.addStars(input));
    }
}
