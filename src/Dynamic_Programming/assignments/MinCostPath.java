package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinCostPath {
    public static class Solution {
        private static int minCostPathR(int[][] input, int j, int i, int[][] dp) {
            if(j<0 || i<0 || j>=input.length || i>=input[0].length){
                return Integer.MAX_VALUE;
            }
            if(dp[j][i]!=-1) {
                return dp[j][i];
            }
            if(j==input.length-1 && i==input[0].length-1){
                return input[j][i];
            }
            int ans;
            ans = minCostPathR(input, j+1, i+1, dp);
            int downward = minCostPathR(input, j+1, i, dp);
            ans = Math.min(ans, downward);
            int right = minCostPathR(input, j, i+1, dp);
            ans = Math.min(ans, right);
            dp[j][i] = input[j][i] + ans;
            return dp[j][i];
        }

        public static int minCostPathR(int[][] input) {
            int[][] dp = new int[input.length][input[0].length];
            for(int i=0; i<input[0].length; i++){
                for(int j=0; j<input.length; j++){
                    dp[j][i] = -1;
                }
            }
            int ans = minCostPathR(input, 0, 0, dp);
            return ans;
        }
        private static boolean isValidCell(int[][] arr, int x, int y){
            if(y<0 || x<0 || y>=arr.length || x>=arr[0].length){
                return false;
            }
            return true;
        }
        public static int minCostPath(int[][] input) {
            int[][] dp = new int[input.length][input[0].length];
            dp[input.length-1][input[0].length-1] = input[input.length-1][input[0].length-1];
            boolean firstSkipped = false;
            for(int j=input.length-1; j>=0; j--){
                for(int i=input[0].length-1; i>=0; i--){
                    if(!firstSkipped){
                        firstSkipped = true;
                        continue;
                    }
                    int ans = Integer.MAX_VALUE;
                    if(isValidCell(dp, i+1, j)){
                        ans = Math.min(ans, dp[j][i+1]);
                    }
                    if(isValidCell(dp, i, j+1)){
                        ans = Math.min(ans, dp[j+1][i]);
                    }
                    if(isValidCell(dp, i+1, j+1)){
                        ans = Math.min(ans, dp[j+1][i+1]);
                    }
                    dp[j][i] = input[j][i] + ans;
                }
            }
            return dp[0][0];
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums;
            strNums = br.readLine().trim().split("\\s");

            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minCostPath(mat));
    }
}
