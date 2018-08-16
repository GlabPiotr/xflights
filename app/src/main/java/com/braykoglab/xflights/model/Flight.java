package com.braykoglab.xflights.model;


import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Flight {
    private BigDecimal flightPrice;
    private Date flightDate;
    private Currency priceCurrency;
}
