package com.api.example.fixture.invoke.requests.booking;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.IPathParameters;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.requests.Request;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
public class GetBookingRequest extends Request implements IRequest {

    public GetBookingRequest(ExampleHeaders headers, IPathParameters pathParameters) {
        super(headers, HttpMethod.GET, pathParameters, null, null);
    }
}
