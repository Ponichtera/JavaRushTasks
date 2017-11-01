package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(3223131d,"ere" );
        labels.put(322313d,"ere2" );
        labels.put(322311d,"ere3" );
        labels.put(322331d,"4" );
        labels.put(322131d,"ere4" );

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
