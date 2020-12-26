package Priority_Queue.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckMaxHeap {
    public static class Solution {
        public static boolean checkMaxHeap(int arr[]) {
            for(int parentIndex=0; parentIndex<arr.length; parentIndex++){
                int leftChildIndex = 2*parentIndex+1;
                int rightChildIndex = 2*parentIndex+2;
                if(leftChildIndex>=arr.length)
                    continue;
                if(arr[parentIndex]<arr[leftChildIndex])
                    return false;
                if(rightChildIndex<arr.length && arr[parentIndex]<arr[rightChildIndex])
                    return false;
            }
            return true;
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
        System.out.println(Solution.checkMaxHeap(input));
    }
}
