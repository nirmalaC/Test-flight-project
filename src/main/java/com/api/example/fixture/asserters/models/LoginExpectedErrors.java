package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwebb on 1/11/2017.
 */
public class LoginExpectedErrors {

    public static List<ExpectedError> CUSTOMER_LOGIN_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("digital only", "SVC_100046_2005", "Only Channel Digital is allowed to access this service"));
                add(new ExpectedError("wrong credentials", "SVC_100046_2001", "wrong credentials"));
                add(new ExpectedError("disabled", "SVC_100046_2002", "This account has been disabled for security reasons"));
            }};

}
