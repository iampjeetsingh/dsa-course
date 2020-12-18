package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PairsWithDifferenceK {
    public static class Solution {
        public static int getPairsWithDifferenceK(int arr[], int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int i : arr){
                int freq = 0;
                if(map.containsKey(i))
                    freq = map.get(i);
                map.put(i, ++freq);
            }
            for(int i : map.keySet()){
                int j = i+k;
                if(k==0){
                    if(i==j){
                        int freqI = map.get(i);
                        count += freqI*(freqI-1);
                    }
                }else {
                    if(map.containsKey(j) && Math.abs(i-j)==k){
                        int freqI = map.get(i);
                        int freqJ = map.get(j);
                        count += freqI*freqJ;
                    }
                    j = i-k;
                    if(map.containsKey(j) && Math.abs(i-j)==k){
                        int freqI = map.get(i);
                        int freqJ = map.get(j);
                        count += freqI*freqJ;
                    }
                }
            }
            return count/2;
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
        int k = Integer.parseInt(br.readLine());
        System.out.println(Solution.getPairsWithDifferenceK(arr, k));
    }

}
