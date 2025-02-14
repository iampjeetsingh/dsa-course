package Recursion.assignments;

import java.util.Scanner;

public class NumberOfDigits {
    public static class Solution {
        public static int count(int n){
            if(n == 0){
                return 0;
            }
            int smallAns = count(n / 10);
            return smallAns + 1;
        }
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(Solution.count(n));
    }
}
