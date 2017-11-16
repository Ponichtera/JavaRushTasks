package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client extends Thread{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress () {
        ConsoleHelper.writeMessage("Enter Server Address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort () {
        ConsoleHelper.writeMessage("Enter Server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName () {
        ConsoleHelper.writeMessage("Enter User name: ");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole () {return  true;}

    protected SocketThread getSocketThread () {
        return new SocketThread();
    }

    protected void sendTextMessage (String text) {
        try {
        connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e ) {
        clientConnected = false; 
        }
    }
    @Override
    public void run() {
        SocketThread socketThreadDaemon = getSocketThread();
        socketThreadDaemon.setDaemon(true);
        socketThreadDaemon.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e ) {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            System.exit(1);
        }

        if(clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
        while (clientConnected){
            String message = ConsoleHelper.readString();
            if (message.equalsIgnoreCase("exit")) break;
            else if (shouldSendTextFromConsole())
                sendTextMessage(message);
        }
    }


    public class SocketThread extends Thread {

        protected void processIncomingMessage (String message ){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser (String userName ) {
            ConsoleHelper.writeMessage(userName + " has entered the chat.");
        }

        protected void informAboutDeletingNewUser (String userName ) {
            ConsoleHelper.writeMessage(userName + " has letft the chat.");
        }

        protected void notifyConnectionStatusChanged (boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

    }

    public static void main (String[] args) {
        Client client = new Client();
        client.run();
    }
}
