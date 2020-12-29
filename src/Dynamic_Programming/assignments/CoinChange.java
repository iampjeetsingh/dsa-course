package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoinChange {
    public static class Solution {
        public static int countWaysToMakeChange(int denominations[], int value){
            int[][] dp = new int[value+1][value+1];
            return countWaysToMakeChangeR(denominations, value, dp, 0);
        }
        private static int countWaysToMakeChangeR(int denominations[], int value, int[][] dp, int min){
            if(value<0)
                return 0;
            if(value==0){
                return 1;
            }
            if(dp[value][min]!=0)
                return dp[value][min];
            int ways = 0;
            for(int i=0; i<Math.min(denominations.length, value+1); i++){
                if(i<min)
                    continue;
                ways += countWaysToMakeChangeR(denominations, value-denominations[i], dp, i);
            }
            dp[value][min] = ways;
            return ways;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int numDenominations = Integer.parseInt(br.readLine().trim());

        int denominations[] = new int[numDenominations];
        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < numDenominations; ++i) {
            denominations[i] = Integer.parseInt(strNums[i]);
        }
        int value = Integer.parseInt(br.readLine().trim());


        System.out.println(Solution.countWaysToMakeChange(denominations, value));

    }
}
