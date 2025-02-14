package Recursion.assignments;

import java.util.Scanner;

public class CalculatePower {
    public static class Solution {
        public static int power(int x, int n) {
            if(n==0)
                return 1;
            return x * power(x,n-1);
        }
    }


    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int x = s.nextInt();
        int n = s.nextInt();

        System.out.println(Solution.power(x, n));
    }
}
