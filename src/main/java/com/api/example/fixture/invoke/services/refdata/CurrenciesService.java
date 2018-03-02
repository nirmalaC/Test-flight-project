package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.CurrenciesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.currencies.CurrenciesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class CurrenciesService extends ExampleService implements IExampleService {

    private CurrenciesResponse currenciesResponse;

    public CurrenciesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCurrenciesEndpoint());
    }

    @Override
    public CurrenciesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new CurrenciesAssertion(currenciesResponse);
    }

    @Override
    public CurrenciesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return currenciesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(currenciesResponse.getCurrencies());
    }

    @Override
    protected void mapResponse() {
        currenciesResponse = response.readEntity(CurrenciesResponse.class);
    }
}
