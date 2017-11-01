package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String input = reader.readLine();
        SimpleDateFormat sdt = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdt.parse(input);
        System.out.println(new SimpleDateFormat("MMM dd, yyyy").format(date).toUpperCase());

    }
}
