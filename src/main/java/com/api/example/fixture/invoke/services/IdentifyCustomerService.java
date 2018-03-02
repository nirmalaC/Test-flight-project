package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.IdentifyCustomerAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.customer.identify.IdentifyCustomerResponse;

import javax.ws.rs.client.Client;

/**
 * Created by dwebb on 12/5/2016.
 */
public class IdentifyCustomerService extends ExampleService implements IExampleService {

    private IdentifyCustomerResponse identifyCustomerResponse;

    IdentifyCustomerService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCustomers());
    }

    @Override
    public IdentifyCustomerAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new IdentifyCustomerAssertion(identifyCustomerResponse);
    }

    @Override
    public IdentifyCustomerResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return identifyCustomerResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(identifyCustomerResponse.getCustomers());
    }

    @Override
    protected void mapResponse() {
        identifyCustomerResponse = response.readEntity(IdentifyCustomerResponse.class);
    }

}
