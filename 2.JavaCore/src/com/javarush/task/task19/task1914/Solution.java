package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream console         = System.out;
        PrintStream out             = new PrintStream(array);

        System.setOut(out);
        testString.printSomething();
        System.setOut(console);

        String line = array.toString();
        String[] splitedLine = line.split(" ");
        int result = 0;
        switch (splitedLine[1]) {
            case "+":   result = Integer.parseInt(splitedLine[0]) + Integer.parseInt(splitedLine[2]);
                        break;
            case "-": result = Integer.parseInt(splitedLine[0]) - Integer.parseInt(splitedLine[2]);
                        break;
            case "*": result = Integer.parseInt(splitedLine[0]) * Integer.parseInt(splitedLine[2]);
                        break;

        }
        System.out.println(splitedLine[0]+ " " + splitedLine[1]+ " " + splitedLine[2]+ " " + splitedLine[3]+ " " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

