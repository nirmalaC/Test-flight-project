package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.PassengerTypesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.passengertypes.PassengerTypesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class PassengerTypesService extends ExampleService implements IExampleService {

    private PassengerTypesResponse passengerTypesResponse;

    public PassengerTypesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExamplePassengerTypesEndpoint());
    }

    @Override
    public PassengerTypesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new PassengerTypesAssertion(passengerTypesResponse);
    }

    @Override
    public PassengerTypesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return passengerTypesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(passengerTypesResponse.getPassengerTypes());
    }

    @Override
    protected void mapResponse() {
        passengerTypesResponse = response.readEntity(PassengerTypesResponse.class);
    }
}
