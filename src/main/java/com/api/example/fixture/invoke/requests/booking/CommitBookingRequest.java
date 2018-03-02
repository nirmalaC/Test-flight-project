package com.api.example.fixture.invoke.requests.booking;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.requests.Request;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
public class CommitBookingRequest extends Request implements IRequest {

    public CommitBookingRequest(ExampleHeaders headers, IRequestBody requestBody) {
        super(headers, HttpMethod.POST, null, null, requestBody);
    }
}
