package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < 5; i++ ) map.put("name"+i, "lastName"+i);
        for(int i = 0; i < 5; i++ ) map.put("name"+(i+5), "lastName");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for ( Map.Entry<String, String > entry : copy.entrySet() ) {
            int index =0;
            String match = entry.getValue();
            for ( Map.Entry<String, String > entry2 : copy.entrySet() ) if(entry2.getValue().equals(match)) index++;
              if( index > 1)  removeItemFromMapByValue(map, match);
        }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {


    }
}
