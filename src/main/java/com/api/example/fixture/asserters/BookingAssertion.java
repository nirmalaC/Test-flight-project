package com.api.example.fixture.asserters;

import com.api.example.fixture.helpers.DateFormat;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.basket.Passenger;
import com.api.example.fixture.invoke.response.basket.Traveller;
import com.api.example.fixture.invoke.response.customer.profile.Customer;
import com.api.example.fixture.invoke.response.getbookingresponse.Flight;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for booking response object, provides reusable assertions to all tests
 */
public class BookingAssertion implements IAssertion {

    private final GetBookingResponse getBookingResponse;

    public BookingAssertion(GetBookingResponse getBookingResponse) {
        this.getBookingResponse = getBookingResponse;
    }

    public BookingAssertion theBasketWasAddedToTheBooking(BasketsResponse basket)
    {
        //extract flights from the basket and then match up with the booking
        assertThat(getBookingResponse.getBookingContext().getBooking().getBookingReason()).isEqualToIgnoringCase(basket.getBasket().getBookingReason());

        List<com.api.example.fixture.invoke.response.basket.Flight> basketOutbound = basket.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .collect(Collectors.toList());

        if (basketOutbound.size() > 0) {
            List<Flight> bookingOutbound = getBookingResponse.getBookingContext().getBooking().getOutbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .collect(Collectors.toList());

            for (com.api.example.fixture.invoke.response.basket.Flight basketFlight : basketOutbound) {
                assertThat(bookingOutbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey())).isNotNull();
                assertThat(bookingOutbound.stream().filter(f -> f.getSector().getCode() == basketFlight.getSector().getCode())).isNotNull();
                assertThat(bookingOutbound.stream().filter(f -> f.getDepartureDateTime() == basketFlight.getDepartureDateTime())).isNotNull();
                assertThat(bookingOutbound.stream().filter(f -> f.getArrivalDateTime() == basketFlight.getArrivalDateTime())).isNotNull();

                //extract passengers from basketFlight
                List<Traveller> basketPassengers = basketFlight.getTravellers();

                for (Traveller passenger : basketPassengers) {
                    //check that the passengers in the basket have been added to the booking
                    assertThat(bookingOutbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getPassengerDetails().getName().getFirstName() == passenger.getPassengerDetails().getName().getFirstName())).isNotNull();
                    assertThat(bookingOutbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getPassengerDetails().getName().getLastName() == passenger.getPassengerDetails().getName().getLastName())).isNotNull();
                    assertThat(bookingOutbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getFareProduct().getName() == passenger.getFareProduct().getName())).isNotNull();
                }

            }
        }

        List<com.api.example.fixture.invoke.response.basket.Flight> basketInbound = basket.getBasket().getInbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .collect(Collectors.toList());

        if (basketInbound.size() > 0) {

            List<Flight> bookingInbound = getBookingResponse.getBookingContext().getBooking().getInbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .collect(Collectors.toList());

            for (com.api.example.fixture.invoke.response.basket.Flight basketFlight : basketInbound) {
                assertThat(bookingInbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey())).isNotNull();
                assertThat(bookingInbound.stream().filter(f -> f.getSector().getCode() == basketFlight.getSector().getCode())).isNotNull();
                assertThat(bookingInbound.stream().filter(f -> f.getDepartureDateTime() == basketFlight.getDepartureDateTime())).isNotNull();
                assertThat(bookingInbound.stream().filter(f -> f.getArrivalDateTime() == basketFlight.getArrivalDateTime())).isNotNull();
                //extract passengers from basketFlight
                List<Traveller> basketPassengers = basketFlight.getTravellers();

                for (Traveller passenger : basketPassengers) {
                    //check that the passengers in the basket have been added to the booking
                    assertThat(bookingInbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getPassengerDetails().getName().getFirstName() == passenger.getPassengerDetails().getName().getFirstName())).isNotNull();
                    assertThat(bookingInbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getPassengerDetails().getName().getLastName() == passenger.getPassengerDetails().getName().getLastName())).isNotNull();
                    assertThat(bookingInbound.stream().filter(f -> f.getFlightKey() == basketFlight.getFlightKey()).flatMap(g -> g.getPassengers().stream()).filter(r -> r.getFareProduct().getName() == passenger.getFareProduct().getName())).isNotNull();
                }

            }

        }

        return this;
    }

    public void theBookingDetailsAreReturnedWithAReferenceNumber(String expectedBookingReference) {
        assertThat(getBookingResponse.getBookingContext().getBooking().getBookingReference())
                .isEqualTo(expectedBookingReference).withFailMessage("The booking was not returned by the service.");
    }

    public void theBookingDetailsAreReturnedWithStatus(String status) {
        assertThat(getBookingResponse.getBookingContext().getBooking().getBookingStatus().toLowerCase()).isEqualTo(status.toLowerCase());
    }

    public void theFollowingListOfAllowedFunctionsIsReturned(List<String> allowedFunctions) {
        assertThat(getBookingResponse.getBookingContext().getAllowedFunctions())
                .containsExactlyInAnyOrder(allowedFunctions.toArray(new String[0]));
    }

    public void theFollowingListInboundTrvaellersIsReturned(List<Passenger> passengers) {
        assertThat(getBookingResponse.getBookingContext().getBooking().getInbounds().get(0).getFlights().get(0).getPassengers())
                .isEqualTo(passengers);
    }

    public BookingAssertion theCustomerDetailsAreAssociatedWithTheBooking(Customer customer)
    {
        assertThat(customer.getBasicProfile().getPersonalDetails().getCustomerId()).isEqualTo(getBookingResponse.getBookingContext().getBooking().getBookingContact().getCustomerId());
        assertThat(customer.getBasicProfile().getPersonalDetails().getFirstName()).isEqualTo(getBookingResponse.getBookingContext().getBooking().getBookingContact().getName().getFirstName());
        assertThat(customer.getBasicProfile().getContactAddress().get(0).getAddressLine1()).isEqualTo(getBookingResponse.getBookingContext().getBooking().getBookingContact().getAddress().getAddressLine1());
        return this;
    }

    public BookingAssertion theBookingTimeIsRecorded(){

        assertThat(getBookingResponse.getBookingContext().getBooking().getBookingDateTime()).startsWith(new DateFormat().Today().AsYearMonthDay());
        return this;
    }

    public BookingAssertion thePassengersDetailsAreStoredInTheBooking(BasketsResponse basket)
    {
        //check that all people in the basket are added to the booking with status of booked

        List<Traveller> paxOut = basket.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());

        List<Traveller> paxIn = basket.getBasket().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .flatMap(p -> p.getTravellers().stream())
                .collect(Collectors.toList());

        for (Traveller passenger: paxOut) {
            com.api.example.fixture.invoke.response.getbookingresponse.Passenger bookingPax = getBookingResponse.getBookingContext().getBooking().getOutbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .flatMap(p -> p.getPassengers().stream())
                    .filter(c -> c.getCode().equals(passenger.getCode()))
                    .findFirst()
                    .orElse(null);

            assertThat(bookingPax).isNotNull();

            assertThat(bookingPax.getPassengerDetails().getName().getFirstName()).isEqualTo(passenger.getPassengerDetails().getName().getFirstName());
            assertThat(bookingPax.getPassengerDetails().getName().getLastName()).isEqualTo(passenger.getPassengerDetails().getName().getLastName());
            assertThat(bookingPax.getPassengerDetails().getName().getTitle()).isEqualToIgnoringCase(passenger.getPassengerDetails().getName().getTitle());
            assertThat(bookingPax.getPassengerDetails().getPassengerType()).isEqualToIgnoringCase(passenger.getPassengerDetails().getPassengerType());
            assertThat(bookingPax.getPassengerStatus()).isEqualToIgnoringCase("BOOKED");
        }

        return this;
    }

}
