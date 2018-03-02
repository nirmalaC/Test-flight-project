package com.api.example.fixture.invoke.queryparams;

/**
 * Created by daniel on 28/11/2016.
 */
public abstract class QueryParams {

    protected boolean isPopulated(String stringToCheck) {
        return stringToCheck != null && !stringToCheck.isEmpty();
    }
}
