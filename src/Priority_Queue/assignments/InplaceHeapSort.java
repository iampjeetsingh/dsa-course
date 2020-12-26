package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InplaceHeapSort {
    public static class Solution {
        private static void downHeapify(int[] arr, int startIndex, int maxIndex){
            int index = startIndex;
            int leftIndex = 2*index+1;
            int rightIndex = 2*index+2;
            while (leftIndex<maxIndex){
                int minIndex = index;
                if(arr[leftIndex]<arr[index])
                    minIndex = leftIndex;
                if(rightIndex<maxIndex && arr[rightIndex]<arr[minIndex])
                    minIndex = rightIndex;
                if(minIndex==index)
                    break;
                int temp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = temp;
                index = minIndex;
                leftIndex = 2*index+1;
                rightIndex = 2*index+2;
            }
        }
        public static void inplaceHeapSort(int arr[]) {
            int p = arr.length/2-1;
            for(int i=p; i>=0; i--){
                downHeapify(arr, i, arr.length);
            }
            for (int i=arr.length-1; i>=0; i--){
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                downHeapify(arr, 0, i);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Solution.inplaceHeapSort(input);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

}
