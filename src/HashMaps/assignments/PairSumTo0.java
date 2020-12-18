package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PairSumTo0 {
    public static class Solution {
        public static int PairSum(int[] input, int size) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int i : input){
                int freq = 0;
                if(map.containsKey(i))
                    freq = map.get(i);
                map.put(i, ++freq);
            }
            for(int i : map.keySet()){
                if(i<0){
                    continue;
                }
                if(i==0){
                    int zeroFreq = 0;
                    if(map.containsKey(0))
                        zeroFreq = map.get(0);
                    if(zeroFreq>1){
                        count += zeroFreq*(zeroFreq-1)/2;
                    }
                    continue;
                }
                int plusFreq = 0, minusFreq = 0;
                if(map.containsKey(Math.abs(i)))
                    plusFreq = map.get(Math.abs(i));
                if(map.containsKey(-1*Math.abs(i)))
                    minusFreq = map.get(-1*Math.abs(i));
                count += minusFreq*plusFreq;
            }
            return count;
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

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(Solution.PairSum(arr,arr.length));


    }
}
