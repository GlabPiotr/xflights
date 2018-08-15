package com.braykoglab.xflights.model;


import java.math.BigDecimal;
import java.util.Date;

public class ApiRequest {

    private String from;
    private String to;
    private Date flyOutFrom;
    private Date flyOutTo;
    private Date flyBackFrom;
    private Date flyBackTo;
    private BigDecimal maxPrice;
    private Currency currency;

    private ApiRequest(String from, String to, Date flyOutFrom, Date flyOutTo, Date flyBackFrom, Date flyBackTo, BigDecimal maxPrice, Currency currency) {
        this.from = from;
        this.to = to;
        this.flyOutFrom = flyOutFrom;
        this.flyOutTo = flyOutTo;
        this.flyBackFrom = flyBackFrom;
        this.flyBackTo = flyBackTo;
        this.maxPrice = maxPrice;
        this.currency = currency;
    }

    public static class ApiRequestBuilder {
        private String from;
        private String to;
        private Date flyOutFrom;
        private Date flyOutTo;
        private Date flyBackFrom;
        private Date flyBackTo;
        private BigDecimal maxPrice;
        private Currency currency;

        public ApiRequestBuilder from(String from) {
            this.from = from;
            return this;
        }

        public ApiRequestBuilder to(String to) {
            this.to = to;
            return this;
        }

        public ApiRequestBuilder flyOutFrom(Date flyOutFrom) {
            this.flyOutFrom = flyOutFrom;
            return this;
        }

        public ApiRequestBuilder flyOutTo(Date flyOutTo) {
            this.flyOutTo = flyOutTo;
            return this;
        }

        public ApiRequestBuilder flyBackFrom(Date flyBackFrom) {
            this.flyBackFrom = flyBackFrom;
            return this;
        }

        public ApiRequestBuilder flyBackTo(Date flyBackTo) {
            this.flyBackTo = flyBackTo;
            return this;
        }

        public ApiRequestBuilder maxPrice(BigDecimal maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public ApiRequestBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ApiRequest build() {
            return new ApiRequest(from, to, flyOutFrom, flyOutTo, flyBackFrom, flyBackTo, maxPrice, currency);
        }
    }
}
