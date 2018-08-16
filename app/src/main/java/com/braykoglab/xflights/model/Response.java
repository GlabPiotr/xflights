package com.braykoglab.xflights.model;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response {

    private List<Flight> oneWayFligths;
    private List<Flight> returnFligths;
}
