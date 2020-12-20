package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LootHouses {
    public static class Solution {
        private static int maxMoneyLooted(int[] houses, int si, int[] dp) {
            int length = houses.length-si;
            if(length<=0) {
                return 0;
            }
            if(dp[si]!=-1){
                return dp[si];
            }
            if(length==1)
                return houses[si];
            int currentHouseLooted = houses[si] + maxMoneyLooted(houses, si+2, dp);
            int currentHouseSkipped = maxMoneyLooted(houses, si+1, dp);
            int maxLoot = Math.max(currentHouseLooted, currentHouseSkipped);
            dp[si] = maxLoot;
            return maxLoot;
        }
        public static int maxMoneyLooted(int[] houses) {
            int[] dp = new int[houses.length];
            Arrays.fill(dp, -1);
            return maxMoneyLooted(houses, 0, dp);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return new int[0];
        }

        String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput();
        System.out.println(Solution.maxMoneyLooted(arr));
    }
}
