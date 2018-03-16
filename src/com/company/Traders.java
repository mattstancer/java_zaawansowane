package com.company;

import java.math.BigDecimal;

public class Traders extends Employees {
    private BigDecimal percentageValue;

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

}
