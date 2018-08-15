package com.braykoglab.xflights.model;


import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ApiRequest {
    private String from;
    private String to;
    private Date flyOutFrom;
    private Date flyOutTo;
    private Date flyBackFrom;
    private Date flyBackTo;
    private BigDecimal maxPrice;
    private Currency currency;
}
