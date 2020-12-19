package Recursion.assignments;

import java.util.Scanner;

public class CountZeroes {
    public static class Solution {
        public static int countZerosRec(int input){
            if(input<10)
                return 0;
            if(input%10==0)
                return 1 + countZerosRec(input/10);
            else
                return countZerosRec(input/10);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(Solution.countZerosRec(n));
    }
}
