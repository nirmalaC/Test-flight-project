package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.FlightsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.response.flights.FlightsResponse;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class FlightsService extends ExampleService implements IExampleService {

    private FlightsResponse flightsResponse;

    FlightsService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleFlightsEndpoint());
    }

    @Override
    public FlightsAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new FlightsAssertion(flightsResponse);
    }

    @Override
    public FlightsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return flightsResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(flightsResponse.getOutbound());
    }

    @Override
    protected void mapResponse() {
        flightsResponse = response.readEntity(FlightsResponse.class);
    }

    public Flight getOutboundFlight(String bundle) {
        return flightsResponse.getOutbound().getResult().getJourneys().stream()
                .flatMap(f -> f.getFlights().stream())
                .filter(g -> g.getFareTypes().stream().anyMatch(u -> u.getFareTypeCode().equals(bundle)))
                .findFirst()
                .orElse(null);

    }

    public Flight getOutboundFlight() {
        return flightsResponse.getOutbound().getResult().getJourneys().get(0).getFlights().get(0);
    }

    public Flight getInboundFlight() {
        return flightsResponse.getInbound().getResult().getJourneys().get(1).getFlights().get(0);
    }
}
