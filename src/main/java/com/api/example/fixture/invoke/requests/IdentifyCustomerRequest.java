package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.IPathParameters;
import com.api.example.fixture.invoke.queryparams.IQueryParams;

/**
 * Created by dwebb on 12/5/2016.
 */
public class IdentifyCustomerRequest extends Request implements IRequest {

    public IdentifyCustomerRequest(ExampleHeaders headers, String httpMethod, IPathParameters pathParams, IQueryParams queryParams) {
        super(headers, httpMethod, null, queryParams, null);
    }
}
