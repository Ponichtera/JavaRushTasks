package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader sn = new BufferedReader(new InputStreamReader(System.in));
        int num1 = 0, num2 = 0, max = 0;
        try {
            num1 = Integer.parseInt(sn.readLine());
            if(num1 <= 0) throw new Exception();
        } catch (Exception e) {
            throw e;
        }
        try {
            num2 = Integer.parseInt(sn.readLine());
            if(num2 <= 0) throw new Exception();
        } catch (Exception e) {
            throw e;
        }
        for (int i = 1; i < (num1 < num2 ? num1 : num2) + 1; i++) {
            if((num1%i == 0) && (num2%i == 0)) max = i;
        }
        System.out.println(max);
    }

}

