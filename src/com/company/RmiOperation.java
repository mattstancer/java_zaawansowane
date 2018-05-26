package com.company;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;


public class RmiOperation extends UnicastRemoteObject implements RMIInterface {

    private HashMap<String, String> userSecrets = new HashMap<>();
    private HashMap<String, String> userSessions = new HashMap<>();

    private static final long serialVersionUID = 1L;

    public RmiOperation() throws RemoteException {
        super();
        userSecrets.put("user", "pass");

    }

    @Override
    public String login(String username, String password) throws RemoteException {
        System.out.println(username + " " + password);
        if (userSecrets.containsKey(username)) {
            if (userSecrets.get(username).equals(password)) {
                String token = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
                userSessions.put(token, username);
                return token;
            } else {
                throw new SecurityException();
            }
        } else {
            throw new SecurityException();
        }
    }

    @Override
    public Boolean validateToken(String token) throws RemoteException {
        return userSessions.containsKey(token);
    }

    @Override
    public String deleteToken(String token) throws RemoteException {
        return userSessions.remove(token);
    }
}
