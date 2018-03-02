package com.api.example.fixture.asserters.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 28/11/2016.
 */
public class CommitBookingExpectedErrors {

    public static List<ExpectedError> COMMIT_BOOKING_VALID_ERRORS =
            new ArrayList<ExpectedError>() {{
                add(new ExpectedError("MissingPaymentMethods", "SVC_100022_2002", "Missing payment methods"));
                add(new ExpectedError("MissingPaymentMethod", "SVC_100022_2004", "Missing payment method"));
                add(new ExpectedError("MissingPaymentCode", "SVC_100022_2005", "Missing payment code"));
                add(new ExpectedError("MissingPaymentAmount", "SVC_100022_2006", "Missing payment amount"));
                add(new ExpectedError("MissingPaymentCurrency", "SVC_100022_2007", "Missing payment currency"));
                add(new ExpectedError("MissingPaymentToken", "SVC_100022_2003", "Missing payment token"));
                add(new ExpectedError("InvalidBasketReference", "SVC_100022_2018", "Invalid basket reference"));
                add(new ExpectedError("InvalidPaymentAmount", "SVC_100022_2019", "Invalid payment amount"));
                add(new ExpectedError("InvalidPaymentCode", "SVC_100022_2024", "Invalid payment code."));
                add(new ExpectedError("InvalidBookingType", "SVC_100022_2025", "Invalid booking reason/type."));
                add(new ExpectedError("InvalidBookingReason", "SVC_100022_2025", "Invalid booking reason/type."));
                add(new ExpectedError("PaymentMismatched", "SVC_100022_2020", "Mismatch of payment amount with cart total."));
            }};
}