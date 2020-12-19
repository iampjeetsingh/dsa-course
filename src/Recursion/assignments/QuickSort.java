package Recursion.assignments;

import java.util.Scanner;

public class QuickSort {
    public static class Solution {
        private static void swap(int[] arr, int a, int b){
            int temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;
        }
        private static int partition(int[] arr, int start, int end){
            int p = end;
            int i=start-1;
            for(int j=start;j<p;j++){
                if(arr[j]<arr[p]){
                    i++;
                    swap(arr,i,j);
                }
            }
            swap(arr,i+1,p);
            p = i+1;
            return p;
        }
        private static void quickSort(int[] arr, int start, int end){
            if(start>=end)
                return;
            int p = partition(arr,start,end);
            quickSort(arr,start,p-1);
            quickSort(arr,p+1,end);
        }
        public static void quickSort(int[] input) {
            quickSort(input,0,input.length-1);
        }
    }


    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        Solution.quickSort(input);
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
