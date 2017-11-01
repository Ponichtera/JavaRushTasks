package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<String, Integer >();

        for (int i = 0; i < 10; i++) {
            String input = reader.readLine();
            if (input.isEmpty()) break;
            int id = Integer.parseInt(input);
            String name = reader.readLine();
            if (name.isEmpty())break;
            map.put(name, id);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
           int index = pair.getValue();
           String name = pair.getKey();
            System.out.println(index + " " + name);
        }

    }
}
