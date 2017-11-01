package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.LinkedList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result           = null;
        final int NUMBERS       = 10; //0-9
        final int POWERS        = 19;  // max long value has 19 digits
        long[][] powersTemplate = new long[NUMBERS][POWERS];

        //filing array with values
        for (int i=1; i < powersTemplate.length; i++) {
            long temp = 1;
            for (int j=1; j < powersTemplate[i].length; j++) {
                temp *= i;
                powersTemplate[i][j] = temp;
            }
        }
        //searching for Armstrong numbers
        LinkedList<Long> list = new LinkedList<>();
        int digitCounter = 2;
        int changeDigitCounterAt = 100;

        for (long i = 0; i <= N; i++) {
            if (i < 10) { list.add(i); continue;} //1 digit numbers are Armstrong numbers
            long tmp = i;
            long value = 0;
            do { value += powersTemplate[(int)(tmp%10)][digitCounter-1];
            tmp /= 10; }
            while (tmp != 0);

            if(value == i) list.add(i);
            if(i == changeDigitCounterAt) {
                changeDigitCounterAt *= 10;
                digitCounter++;
            }
        }
        result = new long[list.size()];
        int i = 0;
        for (Long value : list) result[i++] = value;

        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long[] numbers = getNumbers(Integer.MAX_VALUE);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }}

