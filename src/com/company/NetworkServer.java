package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class NetworkServer implements Runnable {
    private int port;
    private ServerSocket server;
    private RMIInterface inter;
    private EmployeesDb eDb= null;
            public NetworkServer(RMIInterface inter, EmployeesDb eDb) {

                        this.port = 9000;
                        this.inter=inter;
                        this.eDb=eDb;
            }



            @Override

    public void run() {
                System.out.println("RMI Server ready");
                try {

                       server = new ServerSocket(port);
                        
                        while (true) {

                                Socket clientSocket = server.accept();

                                //Running new session for connection

                                        Thread t = new Thread(new ConnectionHandler(clientSocket,inter,eDb));

                                t.start();

                            }

                    } catch (IOException e) {


                }

            }



}
