package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console         = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream outputStream    = new PrintStream(array);

        System.setOut(outputStream);
        testString.printSomething();
        System.setOut(console);
        String data = array.toString().replaceAll("te", "??");
        System.out.print(data);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
