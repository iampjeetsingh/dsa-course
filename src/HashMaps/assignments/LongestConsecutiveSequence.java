package HashMaps.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static class Solution {
        private static class Sequence{
            int start;
            int end;
            public Sequence(int start, int end) {
                this.start = start;
                this.end = end;
            }
            public int size(){
                return end-start+1;
            }
        }
        public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
            HashMap<Integer, Sequence> map = new HashMap<>();
            for(int i : arr){
                if(map.containsKey(i-1) && map.containsKey(i+1)){
                    Sequence startingSequence = map.get(i-1);
                    Sequence endingSequence = map.get(i+1);
                    map.remove(startingSequence.start);
                    map.remove(startingSequence.end);
                    map.remove(endingSequence.start);
                    map.remove(endingSequence.end);
                    Sequence sequence = new Sequence(startingSequence.start, endingSequence.end);
                    map.put(startingSequence.start, sequence);
                    map.put(endingSequence.end, sequence);
                }else if(map.containsKey(i-1)){
                    Sequence sequence = map.get(i-1);
                    map.remove(sequence.start);
                    map.remove(sequence.end);
                    sequence = new Sequence(sequence.start, i);
                    map.put(sequence.start, sequence);
                    map.put(sequence.end, sequence);
                }else if(map.containsKey(i+1)){
                    Sequence sequence = map.get(i-1);
                    map.remove(sequence.start);
                    map.remove(sequence.end);
                    sequence = new Sequence(i, sequence.end);
                    map.put(sequence.start, sequence);
                    map.put(sequence.end, sequence);
                }else {
                    Sequence sequence = new Sequence(i, i);
                    map.put(i, sequence);
                }
            }
            Sequence outSequence = null;
            for(int i: arr){
                if(map.containsKey(i)){
                    Sequence sequence = map.get(i);
                    if(sequence.start==i){
                        if(outSequence==null)
                            outSequence = sequence;
                        else {
                            if(sequence.size()>outSequence.size()){
                                outSequence = sequence;
                            }
                        }
                    }
                }
            }
            ArrayList<Integer> output = new ArrayList<>();
            output.add(outSequence.start);
            output.add(outSequence.end);
            return output;
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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        ArrayList<Integer> ans = Solution.longestConsecutiveIncreasingSequence(arr);
        printArray(ans);

    }
}
