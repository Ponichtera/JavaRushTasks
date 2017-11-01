package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(input));

        while (reader2.ready()) {
            Integer num = Integer.parseInt(reader2.readLine());
           if ( num %2 == 0 ) list.add(num);

        }
        Collections.sort(list);
        for ( Integer element : list) System.out.println(element);


        reader.close();
        input.close();
    }
}
