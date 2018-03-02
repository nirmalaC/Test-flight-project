package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndrewGr on 23/12/2016.
 */

public class CustomerMissingFieldErrors {
    public static List<ExpectedError> CUSTOMER_MISSING_FIELD_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("firstName", "SVC_100047_2035", "Missing first name"));
                add(new ExpectedError("title", "SVC_100047_2034", "Missing title"));
                add(new ExpectedError("lastName", "SVC_100047_2036", "Missing last name"));
                add(new ExpectedError("email", "SVC_100047_2037", "Missing email"));
                add(new ExpectedError("addressLine1", "SVC_100047_2007", "Missing address line 1"));
                add(new ExpectedError("city", "SVC_100047_2009", "Missing city"));
                add(new ExpectedError("postalCode", "SVC_100047_2010", "Missing post code"));
                add(new ExpectedError("optedOutMarketing", "SVC_100047_2011", "Missing marketing option"));
                add(new ExpectedError("phoneNumber", "SVC_100047_2012", "Missing phone number"));
                add(new ExpectedError("password", "SVC_100047_2013", "Missing password"));
            }};
    public static List<ExpectedError> CUSTOMER_NAME_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("firstName", "SVC_100047_2016", "Customer Name cannot contain special characters"));
                add(new ExpectedError("lastName", "SVC_100047_2017", "Customer Last Name cannot contain special characters"));
            }};

    public static class CustomerPasswordExpectedErrors {
        public static List<ExpectedError> CUSTOMER_PASSWORD_VALID_ERRORS =
                new ArrayList<ExpectedError>() {{
                    add(new ExpectedError("minPasswordlength", "SVC_100047_2042", "Password must be at least 6 characters in length."));
                    add(new ExpectedError("maxPasswordlength", "SVC_100047_2043", "Password must be no more than 20 characters in length."));
                    add(new ExpectedError("password contains space", "SVC_100047_2039", "Password cannot contain whitespace characters."));
                    add(new ExpectedError("password guessable", "SVC_100047_2041", "Password cannot be easy guessable."));
                    add(new ExpectedError("£", "SVC_100047_2040", "Password contains illegal characters."));
                    add(new ExpectedError("€", "SVC_100047_2040", "Password contains illegal characters."));
                    add(new ExpectedError("#", "SVC_100047_2040", "Password contains illegal characters."));
                    add(new ExpectedError("&", "SVC_100047_2040", "Password contains illegal characters."));
                    add(new ExpectedError("+", "SVC_100047_2040", "Password contains illegal characters."));
                }};
    }

    public static class CustomerExpectedErrors {
        public static List<ExpectedError> CUSTOMER_VALID_ERRORS =
                new ArrayList<ExpectedError>() {{
                    add(new ExpectedError("email", "SVC_100047_2031", "email address is invalid"));
                    add(new ExpectedError("firstName", "SVC_100047_2018", "First name cannot be more than 30 characters or less than 2 characters"));
                    add(new ExpectedError("lastName", "SVC_100047_2019", "Surname cannot be more than 50 characters or less than 2 characters"));
                    add(new ExpectedError("phoneNumber", "SVC_100047_2024", "telephone number must be between 6 - 18 numbers"));
                    add(new ExpectedError("addressLine1", "SVC_100047_2020", "Address line1 must not be more than 50 characters or less than 4 characters"));
                    add(new ExpectedError("addressLine2", "SVC_100047_2021", "Address line2 must not be more than 50 characters or less than 4 characters"));
                    add(new ExpectedError("city", "SVC_100047_2044", "City must not be more than 50 characters or less than 4 characters"));
                    add(new ExpectedError("country", "SVC_100047_2021", "Country must not be more than 50 characters or less than 4 characters"));
                    add(new ExpectedError("postalCode", "SVC_100047_2023", "Postcode must not be more than 15 characters or less than 2 characters"));
                    add(new ExpectedError("invalidEmailFormat", "SVC_100047_2030", "Invalid Email format"));
                }};
    }
}
