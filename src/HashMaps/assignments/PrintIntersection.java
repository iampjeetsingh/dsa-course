package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class PrintIntersection {
    public static class Solution {
        public static void intersection(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i : arr2){
                int f = 0;
                if(map.containsKey(i))
                    f = map.get(i);
                f++;
                map.put(i,f);
            }
            Arrays.sort(arr1);
            for(int i : arr1){
                if(map.containsKey(i)){
                    int f= map.get(i);
                    if(f>0){
                        System.out.print(i+" ");
                        f--;
                        map.put(i, f);
                    }else {
                        map.remove(i);
                    }

                }
            }
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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            Solution.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}
