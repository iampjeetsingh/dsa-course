package Dynamic_Programming;

import java.util.Scanner;

public class Fibonacci {

    public static int fibI(int n){
        if(n==0 || n==1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int fib(int n, int[] dp){
        if(n==1 || n==2)
            return 1;
        if(dp[n-1]==-1)
            dp[n-1] = fib(n-1, dp);
        if(dp[n-2]==-1)
            dp[n-2] = fib(n-2, dp);
        return dp[n-1] + dp[n-2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }
        System.out.println(fib(n, dp));
    }
}
