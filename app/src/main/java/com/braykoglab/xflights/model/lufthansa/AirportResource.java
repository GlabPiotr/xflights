package com.braykoglab.xflights.model.lufthansa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AirportResource {

    @JsonProperty("Airports")
    List<Airport> airport;
}
