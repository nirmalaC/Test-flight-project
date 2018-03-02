package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.PaymentMethodsAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.paymentmethods.PaymentMethodsResponse;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class PaymentMethodsService extends ExampleService implements IExampleService {

    private PaymentMethodsResponse paymentMethodsResponse;

    PaymentMethodsService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleGetPaymentMethodsEndPoint());
    }

    @Override
    public PaymentMethodsAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new PaymentMethodsAssertion(paymentMethodsResponse);
    }

    @Override
    public PaymentMethodsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return paymentMethodsResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(paymentMethodsResponse.getPaymentMethods());
    }

    @Override
    protected void mapResponse() {
        paymentMethodsResponse = response.readEntity(PaymentMethodsResponse.class);
    }
}
