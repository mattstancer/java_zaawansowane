package com.company;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.company.RMIInterface;
import com.company.RmiOperation;
public class Main {

    public static void main(String[] args) throws RemoteException {
	// write your code here
        EmployeesDb employeeDb = new EmployeesDb("","","");
        employeeDb.Connect();
        char wybor = 0;
        Registry registry;
        RMIInterface inter = new RmiOperation();
        try {
            registry = LocateRegistry.createRegistry(9009);
            registry.rebind("//localhost/auth", inter);
        } catch (Exception e) {
            registry = LocateRegistry.getRegistry("//localhost/auth", 9009);
        }
        new Thread(new NetworkServer(inter,employeeDb)).start();


        ExecutorService threading = Executors.newFixedThreadPool(10);

        Scanner input = new Scanner(System.in);

        while(wybor != 'q') {
            System.out.println("MENU");
            System.out.println("1. Lista Pracowników");
            System.out.println("2. Dodaj Pracownika");
            System.out.println("3. Usuń Pracownika");
            System.out.println("4. Pobierz dane z sieci");
            wybor = input.next().charAt(0);
            switch(wybor) {
                case '1':
                    employeeDb.showList();
                    break;
                case '2':
                    employeeDb.Add();
                    break;
                case '3':
                    employeeDb.Delete();
                    break;
                case '4':

                  new NetworkPage().downloadData();


                    break;
                case 'q':
                    System.out.println("Wyjście");
                    break;
                default:
                    System.out.println("Niepoprawna opcja");
            }
        }




}
}
