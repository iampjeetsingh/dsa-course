package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumK {
    public static class Solution {
        static boolean isSubsetPresent(int[] arr, int n, int sum, int i, int[][] dp) {
            if(i==n || sum<0)
                return sum==0;
            if(dp[i][sum]!=0)
                return dp[i][sum]==1;
            dp[i][sum] = isSubsetPresent(arr, n, sum-arr[i], i+1, dp) || isSubsetPresent(arr, n, sum, i+1, dp) ? 1 : -1;
            return dp[i][sum]==1;
        }
        static boolean isSubsetPresent(int[] arr, int n, int sum) {
            int[][] dp = new int[n+1][sum+1];
            return isSubsetPresent(arr, n, sum, 0, dp);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            System.out.print("No");
            return;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        int sum = Integer.parseInt(br.readLine().trim());
        if (Solution.isSubsetPresent(input,size,sum)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }


    }
}
