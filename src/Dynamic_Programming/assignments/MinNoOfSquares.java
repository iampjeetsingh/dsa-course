package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinNoOfSquares {
    public static class Solution {
        public static int minCountR(int n, int[] dp) {
            if(n==0)
                return 0;
            int min = Integer.MAX_VALUE;
            for(int i=1; i*i<=n ; i++){
                int count = dp[n-(i*i)];
                if(count==-1){
                    count = minCountR(n-(i*i), dp);
                    dp[n-(i*i)] = count;
                }
                min = Math.min(min, count);
            }
            return 1+min;
        }
        public static int minCountR(int n){
            int[] dp = new int[n+1];
            for(int i=0; i<n+1; i++)
                dp[i] = -1;
            return minCountR(n, dp);
        }
        public static int minCount(int n){
            if(n==0)
                return 0;
            int[] dp = new int[n+1];
            dp[0] = 0;
            for(int i=1; i<=n; i++){
                int min = Integer.MAX_VALUE;
                for(int j=1; j*j<=i; j++){
                    int count = 1 + dp[i-(j*j)];
                    min = Math.min(count, min);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(Solution.minCount(n));
    }
}
