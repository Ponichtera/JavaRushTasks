package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader1 = new FileReader(reader.readLine());
             FileReader fileReader2 = new FileReader(reader.readLine())) {

            List<String> originalFile = new BufferedReader(fileReader1).lines().collect(Collectors.toList());
            List<String> modifiedFile = new BufferedReader(fileReader2).lines().collect(Collectors.toList());

            while (originalFile.size() != 0 & modifiedFile.size() != 0) {
                if (originalFile.get(0).equals(modifiedFile.get(0))) {
                    lines.add(new LineItem(Type.SAME, originalFile.remove(0)));
                    modifiedFile.remove(0);
                } else if (modifiedFile.size() != 1 && originalFile.get(0).equals(modifiedFile.get(1))) {
                    lines.add(new LineItem(Type.ADDED, modifiedFile.remove(0)));
                } else if (originalFile.size() != 1 && originalFile.get(1).equals(modifiedFile.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, originalFile.remove(0)));
                }
            }
            if (originalFile.size() != 0) {
                lines.add(new LineItem(Type.REMOVED, originalFile.remove(0)));
            } else if (modifiedFile.size() != 0) {
                lines.add(new LineItem(Type.ADDED, modifiedFile.remove(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (LineItem line : lines) System.out.println(line);
    }

    public static enum Type {
        ADDED,
        REMOVED,
        SAME
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
