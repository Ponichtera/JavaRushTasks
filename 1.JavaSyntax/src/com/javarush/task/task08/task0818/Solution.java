package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put("koza"+i, 200+(i*50));
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>(map);
        for( Map.Entry<String, Integer> pair : copy.entrySet()) if (pair.getValue() < 500) map.remove(pair.getKey());
    }

    public static void main(String[] args) {

    }
}