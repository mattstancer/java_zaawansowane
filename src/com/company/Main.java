package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        EmployeesDb employeeDb = new EmployeesDb("","","");
        employeeDb.Connect();
        char wybor = 0;
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
                    //DownloadData(conn);
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
