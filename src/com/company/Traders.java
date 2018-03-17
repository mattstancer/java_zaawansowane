package com.company;

import java.math.BigDecimal;

public class Traders extends Employees {
    private BigDecimal percentageValue;

    public Traders(String imie, String nazwisko, BigDecimal payment, Integer pesel, int phonennumber, BigDecimal percentageValue, BigDecimal percentageLimitValue, EmployeeType employeeType) {
        super(imie, nazwisko, payment, pesel, phonennumber);
        this.percentageValue = percentageValue;
        this.percentageLimitValue = percentageLimitValue;
        this.employeeType = employeeType;
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
    private EmployeeType employeeType=EmployeeType.Handlowiec;
}
