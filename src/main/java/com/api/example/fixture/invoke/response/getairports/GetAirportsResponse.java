package com.api.example.fixture.invoke.response.getairports;

import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import java.util.List;

/**
 * Created by webbd on 10/20/2016.
 */
@ToString
public class GetAirportsResponse implements IResponse {

    private List<Airport> airports;

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
