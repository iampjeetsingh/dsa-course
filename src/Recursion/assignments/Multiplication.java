package Recursion.assignments;

import java.util.Scanner;

public class Multiplication {
    public static class Solution {
        public static int multiplyTwoIntegers(int m, int n){
            if(n==1)
                return m;
            return m + multiplyTwoIntegers(m,n-1);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println(Solution.multiplyTwoIntegers(m, n));
    }
}
