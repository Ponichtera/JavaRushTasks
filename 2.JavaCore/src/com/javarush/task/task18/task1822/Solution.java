package com.javarush.task.task18.task1822;

/*
Поиск данных внутри файла
*/

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        BufferedReader input = new BufferedReader( new InputStreamReader( new FileInputStream(filePath)));

        while (input.ready()) {
            String line = input.readLine();
            String[] data = line.split(" ");
            if (args[0].equals(data[0])) {
                int id = Integer.parseInt(data[0]);
                String productName = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                System.out.println(id + " " + productName + " " + price + " " + quantity);

            }
        }
        input.close();
    }
}
