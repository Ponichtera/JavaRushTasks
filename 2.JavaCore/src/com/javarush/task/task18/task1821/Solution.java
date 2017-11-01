package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        FileInputStream input = new FileInputStream(args[0]);
        byte[] iterations = new byte[256];
        while (input.available() > 0) iterations[input.read()]++;
        for (int i = 0; i < iterations.length; i++) if (iterations[i] > 0 ) System.out.println( (char)(i) + " " + iterations[i]);
        input.close();
    }
}
/*public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> frequencyMap = new TreeMap<Byte, Integer>();
        FileInputStream f = new FileInputStream(args[0]);

        while (f.available() > 0) {
            byte[] buf = new byte[f.available()];
            f.read(buf);

            for (int i = 0; i < buf.length; i++) {
                if (frequencyMap.containsKey(buf[i]))
                    frequencyMap.put(buf[i], frequencyMap.get(buf[i]) + 1);
                else
                    frequencyMap.put(buf[i], 1);
            }
        }
        f.close();

        for (Map.Entry pair : frequencyMap.entrySet()) {
            System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());
        }
    }
}*/