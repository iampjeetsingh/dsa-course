package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static class Solution {
        private static int lcsR(String s, String t, int i, int j, int[][] dp) {
            if(i==s.length() || j==t.length()){
                return 0;
            }
            if(dp[i][j]!=-1)
                return dp[i][j];
            if(s.charAt(i)==t.charAt(j)){
                return 1 + lcsR(s, t, i+1, j+1, dp);
            }
            dp[i][j] = Math.max(lcsR(s, t, i+1, j, dp), lcsR(s, t, i, j+1, dp));
            return dp[i][j];
        }
        public static int lcsR(String s, String t) {
            int[][] dp = new int[s.length()+1][t.length()+1];
            for(int i=0; i<s.length(); i++){
                for(int j=0; j<t.length(); j++){
                    dp[i][j] = -1;
                }
            }
            return lcsR(s, t, 0, 0, dp);
        }
        public static int lcs(String s, String t) {
            int[][] dp = new int[s.length()+1][t.length()+1];
            for(int i=s.length()-1; i>=0; i--){
                for(int j=t.length()-1; j>=0; j--){
                    if(s.charAt(i)==t.charAt(j)){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
            return dp[0][0];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String s = br.readLine().trim();
        String t = br.readLine().trim();


        System.out.println(Solution.lcs(s, t));
    }
}
