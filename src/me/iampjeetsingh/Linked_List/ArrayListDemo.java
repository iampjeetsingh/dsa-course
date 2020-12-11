package me.iampjeetsingh.Linked_List;

import java.util.ArrayList;

public class ArrayListDemo {
    /*
    * Default Size of array = 10
    * Grows by 1.5x
    * */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(1, 80);
        arrayList.remove(2);
        arrayList.set(1, 200);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(1));

        // Enhanced for loop - for each loop
        for(int i : arrayList){
            System.out.println(i);
        }
    }
}
