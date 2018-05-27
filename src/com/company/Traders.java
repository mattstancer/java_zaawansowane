package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Traders extends Employees {
    @XmlElement(name = "prowizja")
    private BigDecimal percentageValue;

    public Traders(String imie, String nazwisko, BigDecimal payment, Integer pesel, int phonennumber, BigDecimal percentageValue, BigDecimal percentageLimitValue) {
        super(imie, nazwisko, payment, pesel, phonennumber,"Handlowiec");
        this.percentageValue = percentageValue;
        this.percentageLimitValue = percentageLimitValue;

    }

    public BigDecimal getPercentageValue() {

        return percentageValue;
    }

    public void setPercentageValue(BigDecimal percentageValue) {
        this.percentageValue = percentageValue;
    }

    public BigDecimal getPercentageLimitValue() {
        return percentageLimitValue;
    }

    public void setPercentageLimitValue(BigDecimal percentageLimitValue) {
        this.percentageLimitValue = percentageLimitValue;
    }

    private BigDecimal percentageLimitValue;
    public boolean DodajPracownika()
    {
        setPesel();
        setImie();
        setNazwisko();
        setPayment();
        setTelefon();

        try{

            System.out.println("Podaj wielkosc prowizji");
            Scanner line = new Scanner(System.in);
            String input = line.nextLine();
            if(!input.isEmpty())
                percentageValue = new BigDecimal(input);
                input = "";

            System.out.println("Podaj limit prowizji");
            Scanner line2 = new Scanner(System.in);
            input = line2.nextLine();
            if(!input.isEmpty())
                percentageLimitValue = new BigDecimal(input);
                input = "";
        }
        catch(Exception e){
            System.out.println("B��d podczas wprowadzania danych " + e.getMessage());
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
            System.out.println("wynagrodzenie  : " + getPayment() + "zł");
        if(getType() != null)
            System.out.println("Stanowisko     : " + getType());
        if(getPhonenumber() != 0)
            System.out.println("Telefon        : " + getPhonenumber());

        if(getPercentageValue() != null)
            System.out.println("Prowizja %  : " + getPercentageValue());

        if(getPercentageLimitValue() != null)
            System.out.println("Limit prowizji/miesiac  : " + getPercentageLimitValue());

        System.out.println("----------------------------------");
    }
}
