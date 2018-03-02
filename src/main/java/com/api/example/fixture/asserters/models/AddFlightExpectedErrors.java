package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwebb on 12/12/2016.
 */
public class AddFlightExpectedErrors {
    public static List<ExpectedError> ADD_FLIGHT_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("number of infants exceeded", "SVC_100012_3006", "The number of infants on their own seat exceeds the limit for the flight"));
                add(new ExpectedError("cancelled flight", "SVC_100012_3001", "A Cancelled flight cannot be added"));
                add(new ExpectedError("flight leaving", "SVC_100012_3005", "This flight is leaving within 2 hours"));
                add(new ExpectedError("flight fare", "SVC_100012_3008", "Allocation price has changed for one or more of the requested flights at the fare type specified"));
                add(new ExpectedError("requestBody", "SVC_100012_2001", "Missing request body"));
                add(new ExpectedError("flightKey", "SVC_100012_2002", "Missing flight key"));
                add(new ExpectedError("fareType", "SVC_100012_2003", "Missing fare type"));
                add(new ExpectedError("journeyType", "SVC_100012_2004", "Missing journey type"));
                add(new ExpectedError("price", "SVC_100012_2005", "Missing price"));
                add(new ExpectedError("TOEICode", "SVC_100012_2006", "Missing TOEI code"));
                add(new ExpectedError("passengers", "SVC_100012_2007", "Missing passengers"));
                add(new ExpectedError("journeyTypeInvalid", "SVC_100012_1002", "Journey type {value} not recognized"));
                add(new ExpectedError("maximum number of flights exceeded", "SVC_100012_1002", "Journey type {value} not recognized"));
            }};
}
