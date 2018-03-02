package com.api.example.fixture.invoke.pathparams;

/**
 * Created by daniel on 28/11/2016.
 * Add flight to basket path parameters
 */
public class BasketAddFlightPathParams extends PathParameters implements IPathParameters {

    /**
     * @return returns the path parameters for add Flight
     */
    @Override
    public String get() {
        return "/addFlight";
    }
}
