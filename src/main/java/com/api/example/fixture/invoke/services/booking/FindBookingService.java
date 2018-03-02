package com.api.example.fixture.invoke.services.booking;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.asserters.FindBookingAssertion;
import com.api.example.fixture.invoke.requests.IRequest;
import com.api.example.fixture.invoke.response.findbookingresponse.FindBookingsResponse;
import com.api.example.fixture.invoke.services.ExampleService;
import com.api.example.fixture.invoke.services.IExampleService;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 26/11/2016.
 */
public class FindBookingService extends ExampleService implements IExampleService {

    private FindBookingsResponse findBookingResponse;

    public FindBookingService(ExampleTestConfig config, Client client, IRequest request) {
        super(request, client, config.getExampleBookingsEndpoint());
    }

    @Override
    public FindBookingAssertion assertThat() {
        assertThatServiceCallWasSuccessful();
        return new FindBookingAssertion(findBookingResponse);
    }


    @Override
    public FindBookingsResponse getResponse() {
        assertThatServiceCallWasSuccessful();
        return findBookingResponse;
    }

    @Override
    protected void checkThatResponseBodyIsPopulated() {
        checkThatResponseBodyIsPopulated(findBookingResponse.getBookings());
    }

    @Override
    protected void mapResponse() {
        findBookingResponse = response.readEntity(FindBookingsResponse.class);
    }

}
