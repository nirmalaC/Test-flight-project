package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.IQueryParams;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
public class PaymentMethodsRequest extends Request implements IRequest {

    public PaymentMethodsRequest(ExampleHeaders headers, IQueryParams queryParameters) {
        super(headers, HttpMethod.GET, null, queryParameters, null);
    }
}
