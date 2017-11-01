package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string)  throws TooShortStringException{
        if (string == null || string.isEmpty())
            throw new TooShortStringException();

        String[] s = string.split(" ");
        if (s.length < 5) throw new TooShortStringException();
        StringBuilder sb = new StringBuilder();
        return sb.append(s[1]).append(" ").append(s[2]).append(" ").append(s[3]).append(" ").append(s[4]).toString();
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
