package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.preferencesresponse.PreferencesResponse;

/**
 * Created by PTR Scaffolder.
 * assertion wrapper for preferences response object, provides reusable assertions to all tests
 */
public class PreferencesAssertion implements IAssertion {

    private final PreferencesResponse preferencesResponse;

    public PreferencesAssertion(PreferencesResponse preferencesResponse) {
        this.preferencesResponse = preferencesResponse;
    }

    public PreferencesAssertion theExampleAssertion() {
        return this;
    }

}