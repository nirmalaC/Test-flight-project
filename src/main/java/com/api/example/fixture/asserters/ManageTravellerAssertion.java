package com.api.example.fixture.asserters;


import com.api.example.fixture.invoke.response.traveller.TravellerUpdateResponse;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for manage traveller response object, provides reusable assertions to all tests
 */
public class ManageTravellerAssertion implements IAssertion {

    private final TravellerUpdateResponse travellerUpdateResponse;

    public ManageTravellerAssertion(TravellerUpdateResponse travellerUpdateResponse) {
        this.travellerUpdateResponse = travellerUpdateResponse;
    }

}
