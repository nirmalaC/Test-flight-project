package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.PassengerTitlesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.passengertitles.PassengerTitlesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class PassengerTitlesService extends ExampleService implements IExampleService {

    private PassengerTitlesResponse passengerTitlesResponse;

    public PassengerTitlesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExamplePassengerTitlesEndpoint());
    }

    @Override
    public PassengerTitlesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new PassengerTitlesAssertion(passengerTitlesResponse);
    }

    @Override
    public PassengerTitlesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return passengerTitlesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(passengerTitlesResponse.getPassengerTitles());
    }

    @Override
    protected void mapResponse() {
        passengerTitlesResponse = response.readEntity(PassengerTitlesResponse.class);
    }
}
