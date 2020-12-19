package Recursion.assignments;

import java.util.Scanner;

public class Staircase {
    public static class Solution {
        public static int staircase(int n){
            if(n==1)
                return 1;
            if(n==2)
                return 2;
            if(n==3)
                return 4;
            return staircase(n-1) + staircase(n-2) + staircase(n-3);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(Solution.staircase(n));
    }
}
