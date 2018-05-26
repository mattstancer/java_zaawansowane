package com.company;

import java.net.Socket;
import java.util.List;

public class NetworkPage {
    public static void  downloadData()
    {
        try {
            Socket socket = new Socket("localhost", 9000);

            System.out.println("Sukces, Połączono");

            ObjectSerializer client = new ObjectSerializerToByte(socket);
            List<Employees> obj = client.SerializeObject().getEmployees();
        }catch(Exception e){

        }
}

}
