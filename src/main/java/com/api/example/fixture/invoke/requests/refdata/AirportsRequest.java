package com.api.example.fixture.invoke.requests.refdata;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.requests.Request;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
public class AirportsRequest extends Request implements IRequest {

    public AirportsRequest(ExampleHeaders headers) {
        super(headers, HttpMethod.GET, null, null, null);
    }
}
