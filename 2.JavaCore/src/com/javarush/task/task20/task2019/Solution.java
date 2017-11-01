package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {


    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public static void main(String args[]) throws Exception {
        File file = new File("d:\\1.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));

        Solution solution = new Solution();

        System.out.println(solution.size());
        outputStream.writeObject(solution);

        outputStream.close();

        //loading
        ObjectInputStream objectStream = new ObjectInputStream( new FileInputStream(file));

        Solution loadedObject = (Solution) objectStream.readObject();

        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }


    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
