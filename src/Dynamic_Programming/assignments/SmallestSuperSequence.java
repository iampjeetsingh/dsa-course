package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSuperSequence {
    public static class Solution {
        private static int smallestSuperSequence(String str1, String str2, int i, int j, int[][] dp) {
            if(i==str1.length() && j==str2.length())
                return 0;
            if(i==str1.length() || j==str2.length())
                return str1.length()-i+str2.length()-j;
            int ans;
            if(dp[i][j]!=0)
                return dp[i][j];
            if(str1.charAt(i)==str2.charAt(j))
                ans = 1 + smallestSuperSequence(str1, str2, i+1, j+1, dp);
            else {
                int ans1 = smallestSuperSequence(str1, str2, i+1, j, dp);
                int ans2 = smallestSuperSequence(str1, str2, i, j+1, dp);
                ans = 1 + Math.min(ans1, ans2);
            }
            dp[i][j] = ans;
            return ans;
        }
        public static int smallestSuperSequence(String str1, String str2) {
            int[][] dp = new int[str1.length()][str2.length()];
            return smallestSuperSequence(str1, str2, 0, 0, dp);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException  {
        String str1 = br.readLine();
        String str2 = br.readLine();
        int min_len = Solution.smallestSuperSequence(str1, str2);
        System.out.print(min_len);
    }
}
