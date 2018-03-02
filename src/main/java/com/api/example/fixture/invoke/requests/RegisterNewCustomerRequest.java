package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requestbody.IRequestBody;

/**
 * Created by dwebb on 12/15/2016.
 */
public class RegisterNewCustomerRequest extends Request implements IRequest {

    public RegisterNewCustomerRequest(ExampleHeaders headers, String httpMethod, IRequestBody requestBody) {
        super(headers, httpMethod, null, null, requestBody);
    }

}
