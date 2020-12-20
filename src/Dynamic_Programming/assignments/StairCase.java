package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairCase {
    public static class Solution {
        public static long staircase(int n) {
            if(n==0 || n==1 || n==2)
                return n;
            long[] dp = new long[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
            return dp[n];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(Solution.staircase(n));
    }
}
