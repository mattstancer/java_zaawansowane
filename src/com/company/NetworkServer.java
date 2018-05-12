package com.company;
import java.net.ServerSocket;
import java.net.Socket;
public class NetworkServer implements Runnable {
    private int port;





            public NetworkServer(ActorSystem system) {

                this.system = system;

                this.port = system.settings().config().getInt("network.server.port");

            }



            @Override

    public void run() {

                try {

                        ServerSocket serverSocket = new ServerSocket(port);

                        system.log().info("TCP server started");

                        while (true) {

                                Socket clientSocket = serverSocket.accept();

                                //Running new session for connection

                                        Thread t = new Thread(new ConnectionHandler(clientSocket,system));

                                t.start();

                            }

                    } catch (IOException e) {

                        system.log().error(e, "Error");

                    }

            }



}
