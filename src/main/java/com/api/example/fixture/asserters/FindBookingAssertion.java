package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.findbookingresponse.Booking;
import com.api.example.fixture.invoke.response.findbookingresponse.FindBookingsResponse;
import com.api.example.fixture.invoke.response.getbookingresponse.BookingContact;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for find booking response object, provides reusable assertions to all tests
 */
public class FindBookingAssertion implements IAssertion {

    private final FindBookingsResponse findBookingsResponse;

    public FindBookingAssertion(FindBookingsResponse findBookingsResponse) {
        this.findBookingsResponse = findBookingsResponse;
    }


    public void theBookingHasABookingReference(String expectedBookingReference) {
        assertThat(findBookingsResponse.getBookings()).extracting("referenceNumber").contains(expectedBookingReference);
    }


    public void bookingsAreReturned()
    {
        assertThat(findBookingsResponse.getBookings()).as("No bookings were returned for the search!").isNotEmpty();
    }

    public void HasAnErrorForFieldInAdditionalInformation(String message) {
        assertThat(findBookingsResponse.getAdditionalInformation().get(0).getMessage()).isEqualTo(message);
    }


    private String getErrorMessage(String field) {
        switch (field) {
            case "bookingref":
                //  return findBookingsResponse.getAdditionalInformation().get(0).getMessage().equals("Booking reference can not be found, please change your search criteria");
            case "invalidsearchcriteria":
                //return findBookingsResponse.getAdditionalInformation().get(0).getMessage().equals("The required parameters are not supplied as part of the request");
            case "unmatchedsearchcriteria":
                return "No results have been found";
        }

        throw new IllegalArgumentException("The test code does not handle error messages for these fields.");

    }

    public void theBookingHasCustomerDetails(String bookingRef, BookingContact contact) {
        assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("customerFirstName").contains(contact.getName().getFirstName());
        assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("customerLastName").contains(contact.getName().getLastName());
        assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("customerTitle").contains(contact.getName().getTitle().toLowerCase());
        assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("customerEmail").contains(contact.getEmailAddress());
    }

    public void theBookingHasFlightDetails(BookingContact contact) {

    }

    public void theBookingHasDateAndStatus(String bookingRef, String bookingDate, String bookingStatus) {
        //TODO: Format datetime so they match
        //assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("bookingDate").contains(bookingDate);
        assertThat(findBookingsResponse.getBookings().stream().filter(p -> p.getReferenceNumber().equals(bookingRef)).collect(Collectors.toList())).extracting("bookingStatus").contains(bookingStatus.toUpperCase());
    }

    public void theBookingHasExpectedDetails(GetBookingResponse getBookingResponse) {
        assertThat(findBookingsResponse.getBookings().get(0)).hasFieldOrPropertyWithValue("outboundSectorCode", getBookingResponse.getBookingContext().getBooking().getOutbounds().get(0).getFlights().get(0).getSector().getCode());
        assertThat(findBookingsResponse.getBookings().get(0)).hasFieldOrPropertyWithValue("outboundSectorName", getBookingResponse.getBookingContext().getBooking().getOutbounds().get(0).getFlights().get(0).getSector());
    }

    public void theBookingsAreInDateTimeOrder(List<Booking> bookings) {
        List<Booking> sortedBookingList = bookings.stream().sorted(
                new Comparator<Booking>() {
                    @Override
                    public int compare(Booking o1, Booking o2) {
                        return o1.getBookingDate().compareTo(o2.getBookingDate());
                    }
                }
        ).collect(Collectors.toList());
        assertThat(org.apache.commons.collections.CollectionUtils.subtract(bookings, sortedBookingList).size() == 0);
    }

}
