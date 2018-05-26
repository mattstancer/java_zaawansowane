package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket clientSocket = null;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection received from " + clientSocket.getInetAddress().getHostName());
            //3. get Input and Output streams
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(clientSocket.getInputStream());

        } catch (IOException e) {

        }
    }
}
