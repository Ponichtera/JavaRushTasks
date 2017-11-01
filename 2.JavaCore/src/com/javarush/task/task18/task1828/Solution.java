package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.String.valueOf;

        public class Solution {
            public static void main(String[] args) throws Exception {
                if (args.length == 0 || args.length == 1 || args.length == 3 || args.length == 4 ) return;
                if (!args[0].equals("-u") &&  !args[0].equals("-d")) return;

                BufferedReader filePathReader = new BufferedReader( new InputStreamReader(System.in));
                String filePath = filePathReader.readLine();
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                filePathReader.close();

                ArrayList<String> backup = new ArrayList<>();

                if (args[0].equals("-d")) {
                while(reader.ready()) {
                    String line = reader.readLine();
                    int id = 0;
                    if (line.length() > 8 ) id  = Integer.parseInt(line.substring(0,7).replaceAll(" ", ""));
                    if (id == Integer.parseInt(args[1])) continue;
                    backup.add(line);
                    }
                }

                if (args[0].equals("-u")) {

                    while(reader.ready()) {
                        String line = reader.readLine();
                        int id = 0;
                        if (line.length() > 8 ) id  = Integer.parseInt(line.substring(0,7).replaceAll(" ", ""));
                        if (id == Integer.parseInt(args[1])) {
                            String productId = valueOf(id);
                            while (productId.length() < 8) productId = productId + " ";

                            String productName = "";
                            for (int i = 2; i < args.length - 2; i++) productName += args[i] + " ";
                            if (productName.length() > 30) productName = productName.substring(0, 29);
                            while (productName.length() < 30) productName = productName + " ";

                            String price = args[args.length - 2];
                            while (price.length() < 8) price = price + " ";

                            String quantitiy = args[args.length - 1];
                            while (quantitiy.length() < 4) quantitiy = quantitiy + " ";
                            StringBuilder sb = new StringBuilder();
                            line = sb.append(productId).append(productName).append(price).append(quantitiy).toString();
                        }
                        backup.add(line);
                    }

                }


                FileWriter writer = new FileWriter(filePath);
               for (String line : backup) writer.write(line + "\n");

                writer.close();
                reader.close();
            }
        }


