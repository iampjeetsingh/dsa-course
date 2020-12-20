package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LongestSubsetZeroSum {
    public static class Solution {
        public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
            int sum = 0, longest = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for(int i=0; i<arr.length; i++){
                sum += arr[i];
                if(map.containsKey(sum)){
                    int l = i-map.get(sum);
                    if(l>longest)
                        longest = l;
                }else {
                    map.put(sum, i);
                }
            }
            return longest;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Solution.lengthOfLongestSubsetWithZeroSum(arr));
    }
}
