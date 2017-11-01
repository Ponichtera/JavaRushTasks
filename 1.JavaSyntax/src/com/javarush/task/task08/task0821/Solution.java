package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("name","name");
        map.put("name","name1");
        map.put("name1","name1");
        map.put("name2","name2");
        map.put("name3","name3");
        map.put("name4","name4");
        map.put("name5","name5");
        map.put("name7","name7");
        map.put("name8","name8");
        map.put("name9","name9");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
