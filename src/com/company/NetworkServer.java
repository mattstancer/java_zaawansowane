package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class NetworkServer implements Runnable {
    private int port;
    private ServerSocket server;
    private RMIInterface inter;
            public NetworkServer(RMIInterface inter) {

                        this.port = 9000;
                        this.inter=inter;
            }



            @Override

    public void run() {
                System.out.println("RMI Server ready");
                try {

                       server = new ServerSocket(port);
                        
                        while (true) {

                                Socket clientSocket = server.accept();

                                //Running new session for connection

                                        Thread t = new Thread(new ConnectionHandler(clientSocket,inter));

                                t.start();

                            }

                    } catch (IOException e) {


                }

            }



}
