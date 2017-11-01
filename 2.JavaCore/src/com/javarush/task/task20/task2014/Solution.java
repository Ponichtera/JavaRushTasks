package com.javarush.task.task20.task2014;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try {
            File tmp = File.createTempFile("tmp" ,".txt");
            ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(tmp));
            ObjectInputStream in    = new ObjectInputStream ( new FileInputStream(tmp));

            Solution savedObject = new Solution(4);
            out.writeObject(savedObject);

            Solution loadedObject;
            loadedObject = (Solution) in.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

        } catch (IOException e ) {e.printStackTrace();}
        catch (ClassNotFoundException e ) {e.printStackTrace();}

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;


    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
