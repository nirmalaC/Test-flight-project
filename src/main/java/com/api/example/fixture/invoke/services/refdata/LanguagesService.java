package com.api.example.fixture.invoke.services.refdata;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.LanguagesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.languages.LanguagesResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class LanguagesService extends ExampleService implements IExampleService {

    private LanguagesResponse languagesResponse;

    public LanguagesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleLanguagesEndpoint());
    }

    @Override
    public LanguagesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new LanguagesAssertion(languagesResponse);
    }

    @Override
    public LanguagesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return languagesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(languagesResponse.getLanguages());
    }

    @Override
    protected void mapResponse() {
        languagesResponse = response.readEntity(LanguagesResponse.class);
    }
}
