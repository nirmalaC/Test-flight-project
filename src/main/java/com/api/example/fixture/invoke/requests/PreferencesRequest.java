package com.api.example.fixture.invoke.requests;

import com.api.example.fixture.invoke.ExampleHeaders;

/**
 * Created by PTR Scaffolder.
 */
public class PreferencesRequest extends Request implements IRequest {

    public PreferencesRequest(ExampleHeaders headers, String httpMethod) {
        super(headers, httpMethod, null, null, null);
    }
}