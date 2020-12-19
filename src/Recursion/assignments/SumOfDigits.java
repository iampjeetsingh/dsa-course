package Recursion.assignments;

import java.util.Scanner;

public class SumOfDigits {
    public static class Solution {
        public static int sumOfDigits(int input){
            if(input==0)
                return 0;
            return input%10 + sumOfDigits(input/10);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(Solution.sumOfDigits(n));
    }
}
