package Dynamic_Programming.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOne {
    public static class Solution {
        public static int countMinStepsToOne(int n) {
            if(n==1)
                return 0;
            int a = Integer.MAX_VALUE, b=Integer.MAX_VALUE, c;
            if(n%3==0)
                a = countMinStepsToOne(n/3);
            if(n%2==0)
                b = countMinStepsToOne(n/2);
            c = countMinStepsToOne(n-1);
            return 1 + Math.min(a, Math.min(b,c));
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(Solution.countMinStepsToOne(n));
    }
}
