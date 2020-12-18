package HashMaps;

import java.util.HashMap;
import java.util.Set;

public class InbuiltMapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //insert
        map.put("abc",1);
        map.put("def",3);
        //size
        map.put("abc",4);
        System.out.println(map.size());
        //presence
        if(map.containsKey("abc")){
            System.out.println("Map has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("Map has abc1");
        }
        //get value
        int a = map.get("abc");
        System.out.println(a);
        int b = 0;
        if(map.containsKey("abc1"))
            b = map.get("abc1");
        System.out.println(b);
        //remove
//        map.remove("abc1");
//        if(map.containsKey("abc")){
//            System.out.println("Map has abc");
//        }
        //iterate
        Set<String> set = map.keySet();
        for(String key : set){
            System.out.println(key);
        }
    }
}
