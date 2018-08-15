package com.braykoglab.xflights.model;


import java.util.List;

public class ApiResponse {

    private List<Flight> oneWayFligths;
    private List<Flight> returnFligths;

    public List<Flight> getOneWayFligths() {
        return oneWayFligths;
    }

    public void setOneWayFligths(List<Flight> oneWayFligths) {
        this.oneWayFligths = oneWayFligths;
    }

    public List<Flight> getReturnFligths() {
        return returnFligths;
    }

    public void setReturnFligths(List<Flight> returnFligths) {
        this.returnFligths = returnFligths;
    }
}
