package com.braykoglab.xflights.model;


import java.math.BigDecimal;
import java.util.Date;

public class Flight {
    private BigDecimal flightPrice;
    private Date flightDate;
    private Currency priceCurrency;

    public Flight(BigDecimal flightPrice, Date flightDate, Currency priceCurrency) {
        this.flightPrice = flightPrice;
        this.flightDate = flightDate;
        this.priceCurrency = priceCurrency;
    }

    public BigDecimal getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(BigDecimal flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Currency getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(Currency priceCurrency) {
        this.priceCurrency = priceCurrency;
    }
}
