package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.mockpaymenttypes.PaymentTypesResponse;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for payment types response object, provides reusable assertions to all tests
 */
public class PaymentTypesAssertion implements IAssertion {

    private final PaymentTypesResponse paymentTypesResponse;

    public PaymentTypesAssertion(PaymentTypesResponse paymentTypesResponse) {
        this.paymentTypesResponse = paymentTypesResponse;
    }

}
