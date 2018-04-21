package com.company;

import java.math.*;
import java.util.*;
public class Directors extends Employees {
private BigDecimal supplement;
private int businessCard;
private BigDecimal costsLimit;

    public BigDecimal getCostsLimit() {
        return costsLimit;
    }
private EmployeeType employeeType=EmployeeType.Dyrektor;
    public void setCostsLimit(BigDecimal costsLimit) {
        this.costsLimit = costsLimit;
    }

    public int getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(int businessCard) {
        this.businessCard = businessCard;
    }

    public BigDecimal getSupplement() {
        return supplement;
    }

    public Directors(String imie, String nazwisko, BigDecimal payment, Integer pesel, int phonennumber, BigDecimal supplement, int businessCard, BigDecimal costsLimit) {
        super(imie, nazwisko, payment, pesel, phonennumber,"Dyrektor");
        this.supplement = supplement;
        this.businessCard = businessCard;
        this.costsLimit = costsLimit;

    }
    public boolean DodajPracownika()
    {
        try{
            setPesel();
            setImie();
            setNazwisko();
            setPayment();
            setTelefon();

            Scanner line = new Scanner(System.in);
            String input = new String();

            System.out.println("Podaj wielkosc dodatku sluzbowego");
            input = line.nextLine();
            if(!input.isEmpty())
                supplement = new BigDecimal(input);
            input = "";

            System.out.println("Podaj numer karty sluzbowej");
            input = line.nextLine();
            if(!input.isEmpty())
                businessCard = new Integer(input);
            input = "";

            System.out.println("Podaj limit kosztow/miesiac");
            input = line.nextLine();
            if(!input.isEmpty())
                costsLimit = new BigDecimal(input);
            input = "";
        }
        catch(Exception e){
            System.out.println("Błąd podczas wprowadzania danych " + e.getMessage());
            return false;
        }
        return true;
    }

    public void Wyswietl() {

        System.out.println("----------------------------------");
        System.out.println("Identyfikator  : " + getPesel());
        if(getImie() != null)
            System.out.println("imie           : " + getImie());
        if(getNazwisko() != null)
            System.out.println("Nazwisko       : " + getNazwisko());
        if(getPayment() != null)
            System.out.println("wynagrodzenie  : " + getPayment() + " zł");
        if(getType() != null)
            System.out.println("Stanowisko     : " + getType());
        if(getPhonenumber() != 0)
            System.out.println("Telefon        : " + getPhonenumber());

        if(supplement != null)
            System.out.println("Dodatek sluzbowy  : " + supplement);

        if(businessCard != 0)
            System.out.println("Karta sluzbowa : " + businessCard);

        if(costsLimit != null)
            System.out.println("Limit kosztow  : " + costsLimit);

        System.out.println("----------------------------------");
    }
    public void setSupplement(BigDecimal supplement) {
        this.supplement = supplement;
    }
}
