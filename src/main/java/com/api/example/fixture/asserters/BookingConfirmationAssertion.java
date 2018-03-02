package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.bookingconfirmation.BookingConfirmationResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 28/11/2016.
 *  assertion wrapper for booking confirmation response object, provides reusable assertions to all tests
 */
public class BookingConfirmationAssertion implements IAssertion {

    private final BookingConfirmationResponse bookingConfirmationResponse;

    public BookingConfirmationAssertion(BookingConfirmationResponse bookingConfirmationResponse) {
        this.bookingConfirmationResponse = bookingConfirmationResponse;
    }

    public BookingConfirmationAssertion generatedBookingReference() {
        assertThat(bookingConfirmationResponse.getBookingConfirmation().getBookingReference()).isNotNull();
        return this;
    }

    public BookingConfirmationAssertion gotAValidResponse()
    {
        assertThat(bookingConfirmationResponse.getBookingConfirmation()).isNotNull();
        return this;
    }

}


