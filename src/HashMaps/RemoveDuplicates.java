package HashMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(int[] arr){
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int a : arr){
            if(!map.containsKey(a)){
                arrayList.add(a);
                map.put(a, true);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> output = removeDuplicates(arr);
        for(int a: output){
            System.out.println(a);
        }
    }
}
