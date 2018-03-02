package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.PreferencesAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.preferencesresponse.PreferencesResponse;

import javax.ws.rs.client.Client;

/**
 * Created by PTR Scaffolder.
 */
public class PreferencesService extends ExampleService implements IExampleService {

    private PreferencesResponse preferencesResponse;

    PreferencesService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExamplePreferences());
    }

    @Override
    public PreferencesAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new PreferencesAssertion(preferencesResponse);
    }

    @Override
    public PreferencesResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return preferencesResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(preferencesResponse.getPreferencesReferenceData());
    }

    @Override
    protected void mapResponse() {
        preferencesResponse = response.readEntity(PreferencesResponse.class);
    }
}