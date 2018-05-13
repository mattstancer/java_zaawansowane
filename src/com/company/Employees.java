package com.company;

import java.io.ObjectOutputStream;
import java.math.*;
import java.util.*;

public class Employees {

    public Employees(String imie, String nazwisko, BigDecimal payment, Integer pesel, int phonenumber, String type) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.payment = payment;
        this.pesel=(pesel);
        this.type=type;
        this.phonenumber = phonenumber;
    }

    public enum EmployeeType{
        Dyrektor, Handlowiec
    }
    private String imie;
    private String nazwisko;
    private BigDecimal payment;
    private Integer pesel;
    private int phonenumber;

    public int getPhonenumber() {
        return phonenumber;
    }

//    public void setPhonennumber(int phonennumber) {
//        this.phonennumber = phonennumber;
//    }

    public String getImie() {
        return imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public boolean DodajPracownika(){

        try
        {
            setImie();
            setNazwisko();
            setPayment();
//            setStanowisko();
            setTelefon();
        }
        catch(Exception e){
            System.out.println("Błąd podczas wprowadzania danych " + e.getMessage());
            return false;
        }

        Wyswietl();
        System.out.println("[Enter]\tZapisz");
        System.out.println("[Q]\tPorzuć");

        try{
            while(true){
                Scanner line = new Scanner(System.in);
                char op = line.nextLine().charAt(0);
                switch(op){
                    case 'Q':
                    case 'q':
                        return false;
                    default:
                        break;
                }
            }
        }
        catch(Exception e){
            return true;
        }

    }

    Boolean setImie()
    {
        try{
            System.out.println("Podaj Imie");
            Scanner line = new Scanner(System.in);
            String input = new String();
            input = line.nextLine();
            if(!input.isEmpty())
                imie = input;
            input = "";
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public String getType() {
        return type;
    }

    Boolean setNazwisko()
    {
        try
        {
            System.out.println("Podaj Nazwisko");
            Scanner line = new Scanner(System.in);
            String input = new String();
            input = line.nextLine();
            if(!input.isEmpty())
                nazwisko = input;
            input = "";
        }catch(Exception e){
            return false;
        }
        return true;

    }
private String type;
    Boolean setPayment()
    {
        try
        {
            System.out.println("Podaj wynagrodzenie");
            Scanner line = new Scanner(System.in);
            String input = new String();
            input = line.nextLine();
            if(!input.isEmpty())
                payment = new BigDecimal(input);
            input = "";
        }catch(Exception e){
            return false;
        }
        return true;
    }
    Boolean setPesel()
    {
        try
        {
            System.out.println("Podaj Pesel");
            Scanner line = new Scanner(System.in);
            String input = new String();
            input = line.nextLine();
            if(!input.isEmpty())

                    pesel=Integer.parseInt(input);
            input = "";
        }catch(Exception e){
            return false;
        }
        return true;
    }

    Boolean setTelefon()
    {
        try
        {
            System.out.println("Podaj Telefon");
            Scanner line = new Scanner(System.in);
            String input = new String();
            input = line.nextLine();
            if(!input.isEmpty())
                phonenumber =Integer.parseInt(input);
            input = "";
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public void Wyswietl() {

        System.out.println("----------------------------------");
        System.out.println("Identyfikator  : " + pesel.toString());
        if(imie != null)
            System.out.println("imie           : " + imie);
        if(nazwisko != null)
            System.out.println("Nazwisko       : " + nazwisko);
        if(payment != null)
            System.out.println("wynagrodzenie  : " + payment + "zł");
        if(phonenumber != 0)
            System.out.println("Telefon        : " + phonenumber);

        System.out.println("----------------------------------");
    }

    public BigDecimal getPayment() {
        return payment;
    }



    public Integer getPesel() {
        return pesel;
    }

    public boolean checkPesel(Integer pesel) {
        if(pesel.toString().length()==11){
            char[] peselChars=pesel.toString().toCharArray();
            int[] checkArr={9, 7, 3, 1, 9, 7, 3, 1, 9, 7,0};
            int checkSum=0;
            for(int i=0; i<pesel.toString().length()-1;i++){
                checkSum= + checkSum + Integer.parseInt(Character.toString(peselChars[i]))*checkArr[i];
            }
            if(checkSum%10==Integer.parseInt(Character.toString(peselChars[11])))
            {

            return true;
            }
            else {
                System.out.print("źle wprowadzony pesel");
            return false;
            }
        }
return false;
    }
}
interface ObjectSerializer{
void SerializeObject();

}
public class ObjectSerializerToByte implements ObjectSerializer{
    public  void  Se
}
