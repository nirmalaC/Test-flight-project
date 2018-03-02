package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.MarketGroupsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.marketgroups.MarketGroupsResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class MarketGroupsService extends ExampleService implements IExampleService {

    private MarketGroupsResponse marketGroupsResponse;

    public MarketGroupsService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleMarketGroupsEndpoint());
    }

    @Override
    public MarketGroupsAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new MarketGroupsAssertion(marketGroupsResponse);
    }

    @Override
    public MarketGroupsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return marketGroupsResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(marketGroupsResponse.getMarketGroups());
    }

    @Override
    protected void mapResponse() {
        marketGroupsResponse = response.readEntity(MarketGroupsResponse.class);
    }
}
