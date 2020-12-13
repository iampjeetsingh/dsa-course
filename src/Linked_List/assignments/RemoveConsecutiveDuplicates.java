package Linked_List.assignments;

import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {

    public static ArrayList<Integer> removeConsecutiveDuplicates(int[] array){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(array[0]);
        int prev = array[0];
        for(int i : array){
            if(prev!=i){
                result.add(i);
            }
            prev = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 20, 20, 30, 40, 50};
        for (int i : removeConsecutiveDuplicates(arr)){
            System.out.println(i);
        }
    }
}
