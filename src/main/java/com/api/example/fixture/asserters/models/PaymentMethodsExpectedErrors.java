package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwebb on 12/13/2016.
 */
public class PaymentMethodsExpectedErrors {
    public static List<ExpectedError> PAYMENT_METHODS_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("CustomerId", "SVC_100131_2001", "Missing Customer Id parameter"));
                add(new ExpectedError("BasketId", "SVC_100131_2002", "Missing Basket Id parameter"));
            }};
}
