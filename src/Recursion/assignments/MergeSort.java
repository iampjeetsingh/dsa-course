package Recursion.assignments;

import java.util.Scanner;

public class MergeSort {
    public static class Solution {
        private static void merge(int[] a, int[] b, int[] res){
            for(int i=0,j=0,k=0;i<=a.length && j<=b.length;k++){
                if(i==a.length && j==b.length)
                    break;
                if(i==a.length){
                    res[k] = b[j];
                    j++;
                    continue;
                }
                if(j==b.length){
                    res[k] = a[i];
                    i++;
                    continue;
                }
                if(a[i]>b[j]){
                    res[k] = b[j];
                    j++;
                }else{
                    res[k] = a[i];
                    i++;
                }
            }
        }

        public static void mergeSort(int[] array){
            if(array.length==1)
                return;
            int length = array.length;
            int half = length/2;
            int[] a = new int[half];
            int[] b = new int[length-half];
            for(int i=0;i<half;i++){
                a[i] = array[i];
            }
            for(int i=0;i<length-half;i++){
                b[i] = array[half+i];
            }
            mergeSort(a);
            mergeSort(b);
            merge(a,b,array);
        }
    }

    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void printArray(int input[]) {
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        Solution.mergeSort(input);
        printArray(input);
    }
}
