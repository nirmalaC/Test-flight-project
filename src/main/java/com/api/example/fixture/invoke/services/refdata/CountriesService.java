package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.CountriesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.countries.CountriesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class CountriesService extends ExampleService implements IExampleService {

    private CountriesResponse countriesResponse;

    public CountriesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCountriesEndpoint());
    }

    @Override
    public CountriesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new CountriesAssertion(countriesResponse);
    }

    @Override
    public CountriesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return countriesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(countriesResponse.getCountries());
    }

    @Override
    protected void mapResponse() {
        countriesResponse = response.readEntity(CountriesResponse.class);
    }
}
