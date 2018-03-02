package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.CustomerProfileAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.customer.profile.CustomerProfileResponse;

import javax.ws.rs.client.Client;

/**
 * Created by dwebb on 12/2/2016.
 */

public class CustomerProfileService extends ExampleService implements IExampleService {

    private CustomerProfileResponse customerProfileResponse;

    CustomerProfileService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCustomers());
    }

    @Override
    public CustomerProfileAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new CustomerProfileAssertion(customerProfileResponse);
    }

    @Override
    public CustomerProfileResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return customerProfileResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(customerProfileResponse.getCustomer());
    }

    @Override
    protected void mapResponse() {
        customerProfileResponse = response.readEntity(CustomerProfileResponse.class);
    }

}
