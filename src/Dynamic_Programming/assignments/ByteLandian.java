package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ByteLandian {
    public static class Solution {
        public static long bytelandian(long n, HashMap<Long, Long> memo) {
            if(n==0)
                return 0;
            long a = Math.round(n/2);
            long b = Math.round(n/3);
            long c = Math.round(n/4);
            long ansA, ansB, ansC;
            if(memo.containsKey(a))
                ansA = memo.get(a);
            else {
                ansA = bytelandian(a, memo);
                memo.put(a, ansA);
            }
            if(memo.containsKey(b))
                ansB = memo.get(b);
            else {
                ansB = bytelandian(b, memo);
                memo.put(b, ansB);
            }
            if(memo.containsKey(c))
                ansC = memo.get(c);
            else {
                ansC = bytelandian(c, memo);
                memo.put(c, ansA);
            }
            return Math.max(n, ansA+ansB+ansC);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        long n = Long.parseLong(br.readLine().trim());
        HashMap<Long, Long> memo = new HashMap<Long, Long>();
        System.out.println(Solution.bytelandian(n,memo));
    }
}
