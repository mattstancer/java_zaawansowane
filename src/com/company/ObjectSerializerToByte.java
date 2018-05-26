package com.company;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ObjectSerializerToByte implements ObjectSerializer {
//private ArrayList<Employees> employees;

    public ObjectSerializerToByte(Socket socket) {
        this.socket = socket;
    }

    private Socket socket;
    @Override
    @SuppressWarnings("unchecked")
    public Employeess SerializeObject(){
        Employeess employeess = new Employeess();

try {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(baos);
    //out.writeObject(new ClientRequest());
    byte[] bytes = baos.toByteArray();
    socket.getOutputStream().write(bytes);
    socket.getOutputStream().flush();

    ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());

    employeess.setEmployees((ArrayList<Employees>) reader.readObject());
}catch(Exception e){

}
    return employeess;
    }
    @SuppressWarnings("unchecked")
    public void sendWorkersAndClose(ArrayList<Employees> workers) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(workers);
        byte[] bytes = baos.toByteArray();
        socket.getOutputStream().write(bytes);
        socket.close();
    }
}