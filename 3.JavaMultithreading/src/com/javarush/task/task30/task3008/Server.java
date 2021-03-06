package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new
            ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values())
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error while sending the message.");
            }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws
                IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if (answer.getType() == MessageType.USER_NAME)
                    if (!answer.getData().isEmpty())
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType
                                    .NAME_ACCEPTED));

                            return answer.getData();
                        }
            }
        }

        private void sendListOfUsers(Connection connection, String userName)
                throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
                if (!pair.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {
            while (true) {
                Message clientsMessage = connection.receive();
                if (clientsMessage.getType() != MessageType.TEXT)
                    ConsoleHelper.writeMessage("Wrong type of message");

                else sendBroadcastMessage(new Message(MessageType.TEXT, userName
                        + ": " + clientsMessage.getData()));
            }
        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null)
                ConsoleHelper.writeMessage("Connected with: " +
                        socket.getRemoteSocketAddress());
            String userName = null;
            try {
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,
                        userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error ocurred.");
            } finally {
                if (userName != null)
                    connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,
                        userName));
            }

            ConsoleHelper.writeMessage("Connection closed.");
        }
    }

        ///////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter server port: ");
        try (
                ServerSocket serverSocket = new ServerSocket(ConsoleHelper
                        .readInt())) {
            ConsoleHelper.writeMessage("Stating up");
            while (true)
                new Handler(serverSocket.accept()).start();
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ups, something went wrong.");
        }

    }
}
