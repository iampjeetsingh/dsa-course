package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicGrid {
    public static class Solution {
        private static int abs(int n){
            if(n<1)
                return 1;
            return n;
        }
        public static int getMinimumStrength(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[m-1][n-1] = -1*grid[m-1][n-1];
            if(dp[m-1][n-1]>0)
                dp[m-1][n-1]++;
            else
                dp[m-1][n-1] = 1;
            for(int i=m-2; i>=0; i--){
                dp[i][n-1] = abs(dp[i+1][n-1]-grid[i][n-1]);
            }
            for(int j=n-2; j>=0; j--){
                dp[m-1][j] = abs(dp[m-1][j+1]-grid[m-1][j]);
            }
            for(int i=m-2; i>=0; i--){
                for(int j=n-2; j>=0; j--){
                    int right = dp[i+1][j];
                    int bottom = dp[i][j+1];
                    dp[i][j] = abs(Math.min(right, bottom) - grid[i][j]);
                }
            }
            return dp[0][0];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] takeInput() throws IOException {

        String[] nm;
        nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int arr[][]=new int[n][m];

        if (n == 0) {
            return arr;
        }


        String[] strNums;
        for (int i = 0; i < n; ++i) {
            strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j){
                arr[i][j] = Integer.parseInt(strNums[j]);
            }

        }

        return arr;
    }

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());
        while (t!=0){
            int[][] grid = takeInput();
            System.out.println(Solution.getMinimumStrength(grid));
            t--;
        }

    }
}
