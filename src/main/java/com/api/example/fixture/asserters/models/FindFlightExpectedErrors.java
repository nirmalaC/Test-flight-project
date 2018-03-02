package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndrewGr on 03/01/2017.
 */
public class FindFlightExpectedErrors {
    public static List<ExpectedError> FIND_FLIGHT_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("Outbound Date is before today", "SVC_100148_3001", "The flight has already departed."));
                add(new ExpectedError("Inbound Date is before Outbound Date", "SVC_100148_3002", "Date entered is before departure date."));
                add(new ExpectedError("Outbound Date in a wrong format", "SVC_100148_2006", "Date format DD-MM-YYYY"));
                add(new ExpectedError("Inbound Date in a wrong format", "SVC_100148_2006", "Date format DD-MM-YYYY"));
                add(new ExpectedError("No origin airport", "SVC_100148_2010", "No origin airport specified"));
                add(new ExpectedError("No destination airport", "SVC_100148_2011", "No destination airport specified"));
                add(new ExpectedError("incorrect destination airport", "SVC_100148_2005", "Route not flown from departure airport."));
                add(new ExpectedError("incorrect origin airport", "SVC_100148_2001", "Please select a departure airport."));
                add(new ExpectedError("route not flown", "SVC_100148_2004", "No Matches found."));
                add(new ExpectedError("maximum passengers", "SVC_100148_3005", "Maximum number of passengers is 40."));

            }};
}
