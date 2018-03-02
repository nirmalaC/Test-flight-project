package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tejal on 12/12/2016.
 */
public class FindBookingExpectedErrors {


    public static List<ExpectedError> FIND_BOOKING_EXPECTED_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("lastName", "SVC_100144_2001", "Please enter either a title or First Name of the passenger"));
                add(new ExpectedError("firstName", "SVC_100144_2002", "Please enter either a title or Last Name of the passenger"));
                add(new ExpectedError("title", "ERR-BOOKING-000", "Please enter additional search criteria"));
                add(new ExpectedError("email", "SVC_100273_3003", "Email address is invalid"));
            }};
    public static String FIND_BOOKING_NO_RESULT_FOUND = "No results have been found";
}


