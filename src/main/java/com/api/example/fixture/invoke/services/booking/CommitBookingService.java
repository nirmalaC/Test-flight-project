package com.api.example.fixture.invoke.services.booking;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.BookingConfirmationAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.bookingconfirmation.BookingConfirmationResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class CommitBookingService extends ExampleService implements IExampleService {

    private BookingConfirmationResponse bookingConfirmationResponse;

    public CommitBookingService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleCommitBookingEndPoint());
    }

    @Override
    public BookingConfirmationAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new BookingConfirmationAssertion(bookingConfirmationResponse);
    }

    @Override
    public BookingConfirmationResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return bookingConfirmationResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(bookingConfirmationResponse.getBookingConfirmation());
    }

    @Override
    protected void mapResponse() {
        bookingConfirmationResponse = response.readEntity(BookingConfirmationResponse.class);
    }
}
