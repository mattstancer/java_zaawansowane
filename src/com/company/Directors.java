package com.company;

import java.math.*;

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
        super(imie, nazwisko, payment, pesel, phonennumber);
        this.supplement = supplement;
        this.businessCard = businessCard;
        this.costsLimit = costsLimit;

    }

    public void setSupplement(BigDecimal supplement) {
        this.supplement = supplement;
    }
}
