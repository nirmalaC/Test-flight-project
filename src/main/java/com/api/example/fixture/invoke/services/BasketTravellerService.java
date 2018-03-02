package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.ManageTravellerAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.traveller.TravellerUpdateResponse;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class BasketTravellerService extends ExampleService implements IExampleService {

    private TravellerUpdateResponse travellerUpdateResponse;

    BasketTravellerService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleGetBasketEndpoint() + "s");
    }

    @Override
    public ManageTravellerAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new ManageTravellerAssertion(travellerUpdateResponse);
    }

    @Override
    public TravellerUpdateResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return travellerUpdateResponse;
    }

    @Override
    protected void mapResponse() {
        travellerUpdateResponse = response.readEntity(TravellerUpdateResponse.class);
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(travellerUpdateResponse.getAdditionalInformations());
    }
}
