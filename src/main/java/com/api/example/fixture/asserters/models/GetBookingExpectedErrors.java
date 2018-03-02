package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 28/11/2016.
 */
public class GetBookingExpectedErrors {


    public static List<ExpectedError> GET_BOOKING_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("not found", "SVC_100024_1000", "Booking not found"));
            }};
}


