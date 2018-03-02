package com.api.example.fixture.invoke.queryparams;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by webbd on 10/31/2016.
 */
@Data
@Builder
public class FlightQueryParams extends QueryParams implements IQueryParams {

    private String origin = "";
    private String destination = "";
    private String outboundDate = "";
    private String inboundDate = "";
    private String flexibleDays = "";
    private String adult = "";
    private String infant = "";
    private String child = "";
    private String minPrice = "";
    private String maxPrice = "";
    private String fareTypes = "";
    private String isAlternativeFlightsRequired = "";

    @Override
    public Map<String, String> getParameters() {
        Map<String, String> queryParams = new HashMap<>();
        if (isPopulated(origin)) {
            queryParams.put("origin", origin);
        }
        if (isPopulated(destination)) {
            queryParams.put("destination", destination);
        }
        if (isPopulated(outboundDate)) {
            queryParams.put("outbound-date", outboundDate);
        }
        if (isPopulated(inboundDate)) {
            queryParams.put("inbound-date", inboundDate);
        }
        if (isPopulated(flexibleDays)) {
            queryParams.put("flexible-days", flexibleDays);
        }
        if (isPopulated(adult)) {
            queryParams.put("adult", adult);
        }
        if (isPopulated(infant)) {
            queryParams.put("infant", infant);
        }
        if (isPopulated(child)) {
            queryParams.put("child", child);
        }
        if (isPopulated(minPrice)) {
            queryParams.put("min-price", minPrice);
        }
        if (isPopulated(maxPrice)) {
            queryParams.put("max-price", maxPrice);
        }
        if (isPopulated(fareTypes)) {
            queryParams.put("fare-types", fareTypes);
        }
        if (isPopulated(isAlternativeFlightsRequired)) {
            queryParams.put("is-alternative-flights-required", isAlternativeFlightsRequired);
        }

        return queryParams;
    }


}


