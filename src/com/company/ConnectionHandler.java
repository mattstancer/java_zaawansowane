package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionHandler implements Runnable {
    private Socket clientSocket = null;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private RMIInterface interf;
    public ConnectionHandler(Socket clientSocket, RMIInterface interf) {
        this.clientSocket = clientSocket;
        this.interf = interf;
    }

    @Override
    public void run() {
        System.out.println("Unhandled Request");
        ObjectSerializer client = new ObjectSerializerToByte(clientSocket);
        try {
            ClientRequest clientRequest = (ClientRequest) new ObjectInputStream(clientSocket.getInputStream()).readObject();
            //System.out.println(interf.);
            if (interf.validateToken(clientRequest.getToken())) {
                System.out.println("Token valid");
                switch (clientRequest.getRequest()) {
                    case "GetWorkers":
                        Object result = new EmployeesDb("","","").employersList();
                        try {
                            ((ObjectSerializerToByte) client).sendWorkersAndClose((ArrayList<Employees>) result);
                            interf.deleteToken(clientRequest.getToken());
                        } catch (Exception e) {

                        }
                        break;
                    default:
                        System.out.println("Unhandled Request");

                }
            } else {
                System.out.println("Not valid token");
               // ((ObjectSerializerToByte) client).sendErrorAndClose(new SecurityException(""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
