package com.javarush.task.task18.task1823;

import java.awt.image.ImagingOpException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String line = reader.readLine();
        ReadThread readThread;
        while(!line.equals("exit")) {
            readThread = new ReadThread(line);
            readThread.start();
            line = reader.readLine();

        }
        reader.close();
        System.out.println(Solution.resultMap);
    }

    public static class ReadThread extends Thread {
        String filePath;
        public ReadThread(String fileName) {
            //implement constructor body
            this.filePath= fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(filePath);
                int[] bytes = new int[256];
                while (inputStream.available() > 0)
                   bytes[inputStream.read()]++;
                int max = bytes[0];
                int index= 0;
                  for(int i = 1; i < bytes.length ; i++) if(bytes[i] > max) { max = bytes[i] ; index = i;}
                resultMap.put(filePath, index);
                  inputStream.close();
            } catch (FileNotFoundException e ) {}
            catch (IOException e ) {}
        }
    }
}
