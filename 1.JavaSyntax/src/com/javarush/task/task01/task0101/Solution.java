package com.javarush.task.task07.task0708;

import java.io.*;
import java.util.ArrayList;

/*
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> str = new ArrayList<String>();
        int max = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            str.add(reader.readLine());
            if(str.get(i).length() > str.get(i).length())
                max = i;
        }
        for (int i = 0; i < 5; i++) {
            if(str.get(i).length() == max)
                System.out.println(str.get(i));
        }
    }
}
