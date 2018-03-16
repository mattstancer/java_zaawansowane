package com.company;

import java.math.*;

public class Employees {

    public Employees(){

    }
    private enum EmployeeType{
        Dyrektor, Handlowiec
    }
    private String imie;
    private String nazwisko;
    private BigDecimal payment;
    private Integer pesel;
    private int phonennumber;

    public int getPhonennumber() {
        return phonennumber;
    }

    public void setPhonennumber(int phonennumber) {
        this.phonennumber = phonennumber;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        if(pesel.toString().length()==11){
            char[] peselChars=pesel.toString().toCharArray();
            int[] checkArr={9, 7, 3, 1, 9, 7, 3, 1, 9, 7,0};
            int checkSum=0;
            for(int i=0; i<pesel.toString().length()-1;i++){
                checkSum= + checkSum + Integer.parseInt(Character.toString(peselChars[i]))*checkArr[i];
            }
            if(checkSum%10==Integer.parseInt(Character.toString(peselChars[11])))
            {
                this.pesel = pesel;
            }
            else System.out.print("źle wprowadzony pesel");
        }

    }
}
