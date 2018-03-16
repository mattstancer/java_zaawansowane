package com.company;

import java.math.*;

public class Directors extends Employees {
private BigDecimal supplement;
private int businessCard;
private BigDecimal costsLimit;

    public BigDecimal getCostsLimit() {
        return costsLimit;
    }

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

    public void setSupplement(BigDecimal supplement) {
        this.supplement = supplement;
    }
}
