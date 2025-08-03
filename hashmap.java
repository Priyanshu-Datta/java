package hashing;

import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        //insetion
        map.put("India",120);
        map.put("us",30);
        map.put("china",150);
        System.out.println(map);

        //updation
        map.put("India",130);
        System.out.println(map);

        //search
        if(map.containsKey("Indonesia")){
            System.out.println("Indonesia is a key in the map");
        }else{
            System.out.println("Indonesia is not a key in the map");
        }

        //get the key value
        System.out.println(map.get("china"));
        System.out.println(map.get("Japan"));

        //iteration
        for(Map.Entry<String , Integer> e : map.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.println(e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys ){
            System.out.println(key +" "+ map.get(key));
        }

        //delete
        map.remove("china");
        System.out.println(map);

    }
}
