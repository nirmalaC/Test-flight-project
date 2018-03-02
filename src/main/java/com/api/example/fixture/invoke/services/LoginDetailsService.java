package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.CustomerLoginAssertion;
import com.api.example.fixture.invoke.response.login.CustomerLoginResponse;
import com.api.example.fixture.invoke.requests.LoginRequest;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class LoginDetailsService extends ExampleService implements IExampleService {

    private CustomerLoginResponse customerLoginResponse;

    LoginDetailsService(ExampleTestConfig config, Client client, LoginRequest request) {
        super(request, client, config.getExampleCustomerLoginEndPoint());
    }

    @Override
    public CustomerLoginAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new CustomerLoginAssertion(customerLoginResponse);
    }


    @Override
    public CustomerLoginResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return customerLoginResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(customerLoginResponse.getAuthenticationConfirmation());
    }

    @Override
    protected void mapResponse() {
        customerLoginResponse = response.readEntity(CustomerLoginResponse.class);
    }
}
