package com.company;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EmployeesDb employeeDb = new EmployeesDb("","","");
        employeeDb.Connect();
        char wybor = 0;
        new Thread(new NetworkServer()).start();


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
                case '5':
                 try{
                  NetworkPage.downloadData();

                 }catch(Exception e){

                 }
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
