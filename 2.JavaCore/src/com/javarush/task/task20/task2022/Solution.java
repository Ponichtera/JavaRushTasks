package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.filename, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        File file = File.createTempFile("tmp", ".bin");
        file.deleteOnExit();
        ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream(file));
        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream(file));

        Solution solution = new Solution("d:/1.txt");
        solution.writeObject("something");
        solution.close();

        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();

        Solution loaded = (Solution) inputStream.readObject();
        inputStream.close();
        loaded.writeObject("sth");
        loaded.close();

    }
}
