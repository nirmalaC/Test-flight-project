package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.IPathParameters;
import com.api.example.fixture.invoke.queryparams.IQueryParams;
import com.api.example.fixture.invoke.requestbody.IRequestBody;

/**
 * Created by daniel on 26/11/2016.
 */
public interface IRequest {

    ExampleHeaders getHeaders();

    IQueryParams getQueryParameters();

    IRequestBody getRequestBody();

    String getHttpMethod();

    IPathParameters getPathParameters();

}
