package com.api.example.fixture.invoke.services;

import com.api.example.fixture.asserters.ErrorsAssertion;
import com.api.example.fixture.asserters.IAssertion;
import com.api.example.fixture.invoke.response.IResponse;
import com.api.example.fixture.invoke.response.common.Errors;

/**
 * Created by daniel on 04/12/2016.
 */
public interface IExampleService {

    void invoke();

    IResponse getResponse();

    ErrorsAssertion assertThatErrors();

    Errors getErrors();

    IAssertion assertThat();

}
