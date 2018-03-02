package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.RegisterCustomerAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.registerCustomerResponse.RegisterCustomerResponse;

import javax.ws.rs.client.Client;

/**
 * Created by dwebb on 12/15/2016.
 */
public class RegisterCustomerService extends ExampleService implements IExampleService {

    private RegisterCustomerResponse registerCustomerResponse;

    RegisterCustomerService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCustomers());
    }

    @Override
    public RegisterCustomerAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new RegisterCustomerAssertion(registerCustomerResponse);
    }

    @Override
    public RegisterCustomerResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return registerCustomerResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(registerCustomerResponse.getRegistrationConfirmation());
    }

    @Override
    protected void mapResponse() {
        registerCustomerResponse = response.readEntity(RegisterCustomerResponse.class);
    }

}
