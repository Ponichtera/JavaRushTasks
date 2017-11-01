package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable  {
    public static class SubSolution extends Solution {


        private void readObject(ObjectInputStream input) throws NotSerializableException {
            throw new NotSerializableException ("SubSolution class not Serializable");
        }
        private void writeObject(ObjectOutputStream output) throws NotSerializableException{
            throw new NotSerializableException("SubSolution class not Serializable");
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
