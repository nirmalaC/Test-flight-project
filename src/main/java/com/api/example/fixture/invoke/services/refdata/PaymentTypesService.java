package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.PaymentTypesAssertion;
import com.api.example.fixture.invoke.requests.refdata.PaymentTypesRequest;
import com.api.example.fixture.invoke.response.mockpaymenttypes.PaymentTypesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class PaymentTypesService extends ExampleService implements IExampleService {

    private PaymentTypesResponse paymentTypesResponse;

    public PaymentTypesService(ExampleTestConfig config, Client client, PaymentTypesRequest request) {
        super(request, client, config.getExampleGetPaymentTypesEndPoint());
    }

    @Override
    public PaymentTypesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new PaymentTypesAssertion(paymentTypesResponse);
    }


    @Override
    public PaymentTypesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return paymentTypesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(paymentTypesResponse.getPaymentMethods());
    }

    @Override
    protected void mapResponse() {
        paymentTypesResponse = response.readEntity(PaymentTypesResponse.class);
    }
}
