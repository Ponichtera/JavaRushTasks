package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("January",1);
        monthMap.put("February",2);
        monthMap.put("March",3);
        monthMap.put("April",4);
        monthMap.put("May",5);
        monthMap.put("June",6);
        monthMap.put("July",7);
        monthMap.put("August",8);
        monthMap.put("September",9);
        monthMap.put("October",10);
        monthMap.put("November",11);
        monthMap.put("December",12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int month =0;
        for ( Map.Entry<String, Integer> pair : monthMap.entrySet()) if (input.equals(pair.getKey())) month = pair.getValue();
        System.out.println(input + " is " + month +" month");
    }
}
