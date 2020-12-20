package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsTo1UsingDP {
    public static class Solution {
        public static int countMinStepsToOne(int n) {
            int[] dp = new int[n+1];
            dp[1] = 0;
            for(int i=2; i<=n; i++){
                int a = dp[i-1];
                int b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
                if(i%2==0)
                    b = dp[i/2];
                if(i%3==0)
                    c = dp[i/3];
                dp[i] = 1 + Math.min(a, Math.min(b, c));
            }
            return dp[n];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(Solution.countMinStepsToOne(n));
    }
}
