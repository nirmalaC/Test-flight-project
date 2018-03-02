package com.api.example.fixture.invoke.requests.booking;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.IQueryParams;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.requests.Request;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */

public class FindBookingRequest extends Request implements IRequest {

    public FindBookingRequest(ExampleHeaders headers, IQueryParams queryParameters) {
        super(headers, HttpMethod.GET, null, queryParameters, null);
    }
}
