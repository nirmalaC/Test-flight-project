package com.api.example.fixture.invoke.pathparams;

/**
 * Created by daniel on 28/11/2016.
 */
public class PathParameters {

    protected boolean isPopulated(String stringToCheck) {
        return stringToCheck != null && !stringToCheck.isEmpty();
    }
}
