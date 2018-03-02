package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.IPathParameters;
import com.api.example.fixture.invoke.requestbody.IRequestBody;

/**
 * Created by daniel on 26/11/2016.
 */
public class BasketTravellerRequest extends Request implements IRequest {

    public BasketTravellerRequest(ExampleHeaders headers, String httpMethod, IPathParameters pathParams, IRequestBody requestBody) {
        super(headers, httpMethod, pathParams, null, requestBody);
    }
}
