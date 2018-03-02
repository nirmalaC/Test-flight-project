package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.IPathParameters;

/**
 * Created by dwebb on 12/2/2016.
 */
public class ProfileRequest extends Request implements IRequest {

    public ProfileRequest(ExampleHeaders headers, String httpMethod, IPathParameters pathParams) {
        super(headers, httpMethod, pathParams, null, null);
    }

}
