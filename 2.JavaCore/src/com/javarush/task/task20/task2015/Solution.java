package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    private transient  Thread runner;
    private int speed;
    public boolean stop = false;
    private int count = 0;
    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
       try {
        while(!stop) {
            System.out.println(++count);
            Thread.sleep(500);
        } } catch (InterruptedException e ) {}
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        new Thread(this).start();
    }

    public static void main(String[] args) throws Exception {
        File file = File.createTempFile("tmt", "txt");
        file.deleteOnExit();
        ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(file));
        ObjectInputStream in = new ObjectInputStream( new FileInputStream(file));

            Solution s1 = new Solution(300);
            System.out.println("Sleep for 3s");
            Thread.sleep(2000);
            out.writeObject(s1);
            out.close();

            s1.stop = true;
        System.out.println("Sleep for 1s");

            s1 = (Solution) in.readObject();
            Thread.sleep(2000);
            s1.stop = true;

            in.close();
            out.close();
    }
}
