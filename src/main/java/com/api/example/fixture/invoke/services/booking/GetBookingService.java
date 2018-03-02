package com.api.example.fixture.invoke.services.booking;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.BookingAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class GetBookingService extends ExampleService implements IExampleService {

    private GetBookingResponse getBookingResponse;

    public GetBookingService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleBookingsEndpoint());
    }

    @Override
    public BookingAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new BookingAssertion(getBookingResponse);
    }

    @Override
    public GetBookingResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return getBookingResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(getBookingResponse.getBookingContext());
    }

    @Override
    protected void mapResponse() {
        getBookingResponse = response.readEntity(GetBookingResponse.class);
    }
}
