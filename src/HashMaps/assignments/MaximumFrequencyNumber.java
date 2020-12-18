package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MaximumFrequencyNumber {
    public static class Solution {
        public static int maxFrequencyNumber(int[] arr){
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(int i : arr){
                int f = 0;
                if(map.containsKey(i))
                    f = map.get(i);
                f++;
                if(f>maxFreq){
                    maxFreq = f;
                }
                map.put(i, f);
            }
            for(int i : arr){
                if(map.get(i)==maxFreq)
                    return i;
            }
            return -1;
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
        System.out.println(Solution.maxFrequencyNumber(arr));


    }
}
