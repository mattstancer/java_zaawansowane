package com.company;

import java.rmi.*;

public interface RMIInterface extends Remote {

    public String login(String username, String password) throws RemoteException;

    public Boolean validateToken(String token) throws RemoteException;

    public String deleteToken(String token) throws RemoteException;

}