package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinTower {
    public static class Solution {
        public static String findWinner(int n, int x, int y) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[x] = 1;
            dp[y] = 1;
            for(int i=2; i<=n; i++){
                if(i==x || i==y)
                    continue;
                int move1 = 1^dp[i-1];
                int moveX = Integer.MIN_VALUE, moveY = Integer.MIN_VALUE;
                if(i-x>=1)
                    moveX = 1^dp[i-x];
                if(i-y>=1)
                    moveY = 1^dp[i-y];
                dp[i] = Math.max(move1, Math.max(moveX, moveY));
            }
            return dp[n]==1 ? "Beerus" : "Whis";
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strNums = br.readLine().trim().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int x = Integer.parseInt(strNums[1]);
        int y = Integer.parseInt(strNums[2]);

        System.out.println(Solution.findWinner(n, x, y));
    }
}
