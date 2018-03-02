package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwebb on 12/12/2016.
 */
public class UpdateTravellerExpectedErrors {

    public static List<ExpectedError> UPDATE_TRAVELLER_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("passengertype", "SVC_100273_2003", "Missing passenger type"));
                add(new ExpectedError("title", "SVC_100273_2007", "Missing traveller's title"));
                add(new ExpectedError("firstname", "SVC_100273_2005", "Missing traveller's firstname"));
                add(new ExpectedError("lastname", "SVC_100273_2006", "Missing traveller's lastname"));
                add(new ExpectedError("age", "SVC_100273_2008", "Missing traveller's age"));
                add(new ExpectedError("passenger type and title mismatch", "SVC_100273_3009", "passenger type and title mismatch error"));
                add(new ExpectedError("passenger age", "SVC_100273_3011", "passenger age is not valid"));
                add(new ExpectedError("firstname format", "SVC_100273_3005", "First name format is not proper"));
                add(new ExpectedError("lastname format", "SVC_100273_3006", "Last name format is not proper"));
                add(new ExpectedError("email format", "SVC_100273_3003", "Email format is not proper"));
                add(new ExpectedError("email", "SVC_100273_3003", "Email address is invalid"));
                add(new ExpectedError("telephone format", "SVC_100273_3001", "Telephone number format is not proper"));
            }};

}
