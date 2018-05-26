package com.company;

import java.io.Console;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class NetworkPage {

    public void  downloadData()
    {


        System.out.println("Enter username");
        Scanner s= new Scanner(System.in);
        String login= s.nextLine();
        System.out.println("Enter password");
        String password= s.nextLine();
        s.close();
       // this.password = String.valueOf(System.console().readPassword());
        try {
            Registry registry = LocateRegistry.getRegistry(9009);
            RMIInterface look_up = (RMIInterface) registry.lookup("//localhost/auth");
            String token = look_up.login(login, password);
            System.out.println("Login i hasło poprawne");
            Socket socket = new Socket("localhost", 9000);

            System.out.println("Sukces, Połączono");

            ObjectSerializer client = new ObjectSerializerToByte(socket);
            List<Employees> obj = client.SerializeObject(token).getEmployees();
            System.out.println(obj);
        }catch(Exception e){
System.out.println("dupa");
        }
}

}
