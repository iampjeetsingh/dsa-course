package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static class Solution {
        private static int editDistance(String s, String t, int i, int j, int[][] dp) {
            if(i==s.length() && j==s.length()){
                return 0;
            }else if(i==s.length()){
                return t.length()-j;
            } else if(j==t.length()){
                return s.length()-i;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int myAns;
            if(s.charAt(i)==t.charAt(j)){
                myAns = editDistance(s, t, i+1, j+1, dp);
            }else {
                // if we delete
                int ans1 = editDistance(s, t, i+1, j, dp);
                int ans2 = editDistance(s, t, i, j+1, dp);
                // if we replace
                int ans3 = editDistance(s, t, i+1, j+1, dp);
                myAns = 1 + Math.min(ans3, Math.min(ans1, ans2));
            }
            dp[i][j] = myAns;
            return myAns;
        }
        public static int editDistance(String s, String t) {
            int[][] dp = new int[s.length()][t.length()];
            for(int i=0; i<s.length(); i++){
                for(int j=0; j<t.length(); j++){
                    dp[i][j] = -1;
                }
            }
            return editDistance(s, t, 0, 0, dp);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String s = br.readLine().trim();
        String t = br.readLine().trim();


        System.out.println(Solution.editDistance(s, t));
    }
}
