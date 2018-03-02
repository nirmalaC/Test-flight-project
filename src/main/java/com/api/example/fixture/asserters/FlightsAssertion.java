package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.flights.FlightsResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for flights response object, provides reusable assertions to all tests
 */
public class FlightsAssertion implements IAssertion {

    private final FlightsResponse flightsResponse;

    public FlightsAssertion(FlightsResponse flightsResponse) {
        this.flightsResponse = flightsResponse;
    }

    public FlightsAssertion atLeastOneOutboundFlightWasReturned() {
        assertThat(flightsResponse.getOutbound().getResult().getJourneys().get(0).getFlights().get(0)).isNotNull();
        return this;
    }

    public FlightsAssertion additionalPropertiesContains(String expectedString) {
        assertThat(flightsResponse.getAdditionalProperties().toString()).contains(expectedString);
        return this;
    }

    public FlightsAssertion theNumberOfSeatsAvailableOnTheFlightIsLessThan(int availableSeatsBeforeAddtoBasket) {
        assertThat(flightsResponse.getOutbound().getResult().getJourneys().get(0).getFlights().get(0).getInventory().getAvailable()).isLessThan(availableSeatsBeforeAddtoBasket);
        return this;

    }

    public FlightsAssertion hasNumberOfSeatsAvailableEqualTo(int availableSeatsBeforeAddtoBasket) {
        assertThat(flightsResponse.getOutbound().getResult().getJourneys().get(0).getFlights().get(0).getInventory().getAvailable()).isEqualTo(availableSeatsBeforeAddtoBasket);
        return this;
    }

    public FlightsAssertion theFlightHasAFlightKey() {
        assertThat(flightsResponse.getOutbound().getResult().getJourneys().get(0).getFlights().get(0).getFlightKey()).isNotEmpty();
        return this;
    }

}
