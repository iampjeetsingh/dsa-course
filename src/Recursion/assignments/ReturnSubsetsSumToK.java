package Recursion.assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnSubsetsSumToK {
    public static class Solution {
        public static int[][] subsets(int input[], int si) {
            int length = input.length-si;
            if(length==0){
                int[][] output = new int[1][];
                int[] arr = new int[0];
                output[0] = arr;
                return output;
            }
            int[][] smallOutput = subsets(input, si+1);
            int[][] output = new int[smallOutput.length*2][];
            int count = 0;
            for (int[] subset : smallOutput){
                output[count] = smallOutput[count];
                count++;
            }
            for (int[] subset : smallOutput){
                int[] newSubset = new int[subset.length+1];
                newSubset[0] = input[si];
                for(int i=1; i<=subset.length; i++){
                    newSubset[i] = subset[i-1];
                }
                output[count] = newSubset;
                count++;
            }
            return output;
        }

        public static int[][] subsetsSumK(int input[], int k) {
            ArrayList<int[]> arrayList = new ArrayList<>();
            for(int[] subset : subsets(input, 0)){
                int sum = 0;
                for(int e : subset){
                    sum += e;
                }
                if(sum==k)
                    arrayList.add(subset);
            }
            int[][] output = new int[arrayList.size()][];
            int count = 0;
            for(int[] subset : arrayList){
                output[count] = subset;
                count++;
            }
            return output;
        }
    }

    static Scanner s = new Scanner(System.in);
    public static int[] takeInput() {
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int k = s.nextInt();
        int output[][] = Solution.subsetsSumK(input, k);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
