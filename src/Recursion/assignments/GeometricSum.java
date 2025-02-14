package Recursion.assignments;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GeometricSum {
    public static class Solution {
        public static double findGeometricSum(int k){
            if(k==0)
                return 1;
            return (1 / Math.pow(2, k)) + findGeometricSum(k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        double ans = Solution.findGeometricSum(k);
        DecimalFormat dec = new DecimalFormat("#0.00000");
        System.out.println(dec.format(ans));
    }
}
