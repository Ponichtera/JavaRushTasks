package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{
        public void setModel(List rows) {
            System.out.println(rows.size());
        oryginal.setModel(rows);
        }

        public String getHeaderText() {
            return oryginal.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
            oryginal.setHeaderText(newHeaderText);
        }

        private ATableInterface oryginal;

        public TableInterfaceWrapper(ATableInterface aTableInterface) {
            this.oryginal = aTableInterface;
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}