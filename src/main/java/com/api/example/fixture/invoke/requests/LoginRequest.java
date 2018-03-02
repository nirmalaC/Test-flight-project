package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requestbody.IRequestBody;

import javax.ws.rs.HttpMethod;

/**
 * Created by daniel on 26/11/2016.
 */
public class LoginRequest extends Request implements IRequest {

    public LoginRequest(ExampleHeaders headers, IRequestBody requestBody) {
        super(headers, HttpMethod.POST, null, null, requestBody);
    }
}
