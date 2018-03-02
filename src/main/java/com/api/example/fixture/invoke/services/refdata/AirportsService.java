package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.AirportsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.getairports.GetAirportsResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class AirportsService extends ExampleService implements IExampleService {

    private GetAirportsResponse getAirportsResponse;

    public AirportsService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleAirportsEndpoint());
    }

    @Override
    public AirportsAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new AirportsAssertion(getAirportsResponse);
    }

    @Override
    public GetAirportsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return getAirportsResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(getAirportsResponse.getAirports());
    }

    @Override
    protected void mapResponse() {
        getAirportsResponse = response.readEntity(GetAirportsResponse.class);
    }
}
