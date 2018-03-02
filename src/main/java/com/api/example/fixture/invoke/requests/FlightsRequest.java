package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.IQueryParams;
import lombok.ToString;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
@ToString
public class FlightsRequest extends Request implements IRequest {

    public FlightsRequest(ExampleHeaders headers, IQueryParams queryParameters) {
        super(headers, HttpMethod.GET, null, queryParameters, null);
    }
}
