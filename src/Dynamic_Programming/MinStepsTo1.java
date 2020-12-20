package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsTo1 {
    public static int countMinStepsToOne(int n, int[] dp) {
        if(n==1)
            return 0;
        int a = Integer.MAX_VALUE, b=Integer.MAX_VALUE, c;
        if(n%3==0){
            if(dp[n/3]==-1){
                a = countMinStepsToOne(n/3, dp);
                dp[n/3] = a;
            }else
                a = dp[n/3];
        }
        if(n%2==0){
            if(dp[n/2]==-1){
                b = countMinStepsToOne(n/2, dp);
                dp[n/2] = b;
            }else
                b = dp[n/2];
        }
        if(dp[n-1]==-1){
            c = countMinStepsToOne(n-1, dp);
            dp[n-1] = c;
        }else
            c = dp[n-1];
        return 1 + Math.min(a, Math.min(b,c));
    }

    public static void main(String[] args) {
        int n =10;
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++)
            dp[i] = -1;
        System.out.println(countMinStepsToOne(n, dp));
    }
}
