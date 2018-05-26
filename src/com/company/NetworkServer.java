package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class NetworkServer implements Runnable {
    private int port;
    private ServerSocket server;

            public NetworkServer() {

                        this.port = 9000;

            }



            @Override

    public void run() {

                try {

                       server = new ServerSocket(port);
                        
                        while (true) {

                                Socket clientSocket = server.accept();

                                //Running new session for connection

                                        Thread t = new Thread(new ConnectionHandler(clientSocket));

                                t.start();

                            }

                    } catch (IOException e) {


                }

            }



}
