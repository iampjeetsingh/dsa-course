package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MaximumSquareZeoMatrix {
    public static class Solution {
        public static int findMaxSquareWithAllZeros(int[][] input){
            if(input.length==0)
                return 0;
            int[][] dp = new int[input.length][input.length];
            for(int i=0; i<input.length; i++){
                dp[i][0] = input[i][0]==1 ? 0 : 1;
            }
            for(int i=0; i<input[0].length; i++){
                dp[0][i] = input[0][i]==1 ? 0 : 1;
            }
            int max = 0;
            for(int i=1; i<input.length; i++){
                for(int j=1; j<input[0].length; j++){
                    if(input[i][j]==0){
                        int a = dp[i-1][j-1];
                        int b = dp[i-1][j];
                        int c = dp[i][j-1];
                        dp[i][j] = 1 + Math.min(a, Math.min(b, c));
                        if(dp[i][j]>max)
                            max = dp[i][j];
                    }else
                        dp[i][j]=0;
                }
            }
            return max;
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

        int[][] arr = takeInput();
        System.out.println(Solution.findMaxSquareWithAllZeros(arr));
    }
}
