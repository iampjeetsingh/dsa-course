package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MinChocolates {
    public static class Solution {
        public static int getMin(int arr[], int N){
            int[] dp = new int[N];
            int sum = 0;
            dp[0]=1;
            for(int i=1; i<N; i++){
                if(arr[i]>arr[i-1]){
                    dp[i] = 1+dp[i-1];
                }else
                    dp[i] = 1;
            }
            sum += dp[N-1];
            for(int i=N-2; i>=0; i--){
                if(arr[i]>arr[i+1] && dp[i]<dp[i+1]){
                    dp[i] = 1+dp[i+1];
                }
                sum += dp[i];
            }
            return sum;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(Solution.getMin(arr,arr.length));


    }
}
