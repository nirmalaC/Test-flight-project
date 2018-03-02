package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.BasketsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class BasketService extends ExampleService implements IExampleService {

    private BasketsResponse basketsResponse;

    BasketService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleGetBasketEndpoint());
    }

    @Override
    public BasketsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return basketsResponse;
    }

    @Override
    public BasketsAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new BasketsAssertion(basketsResponse);
    }

    @Override
    protected void mapResponse() {
        basketsResponse = response.readEntity(BasketsResponse.class);
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(basketsResponse.getBasket());
    }
}
