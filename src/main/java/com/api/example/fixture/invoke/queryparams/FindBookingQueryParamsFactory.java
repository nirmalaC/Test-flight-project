package com.api.example.fixture.invoke.queryparams;

import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.helpers.CaseConverter;
import com.api.example.fixture.helpers.DateFormat;
import com.api.example.fixture.invoke.response.getbookingresponse.Booking;
import com.api.example.fixture.invoke.response.getbookingresponse.Flight;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;

import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA;

/**
 * Created by daniel on 28/11/2016.
 */
public class FindBookingQueryParamsFactory {

    private static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    private static String getValue(GetBookingResponse booking, String param) throws ExampleCompromisedException {

        List<Flight> flights = booking.getBookingContext().getBooking().getOutbounds().stream()
                .flatMap(f -> f.getFlights().stream())
                .collect(Collectors.toList());

        if (booking.getBookingContext().getBooking().getInbounds() != null) {
            flights.addAll(booking.getBookingContext().getBooking().getInbounds().stream()
                    .flatMap(f -> f.getFlights().stream())
                    .collect(Collectors.toList()));
        }

        try {
            switch (param.toLowerCase()) {
                case "lastname":
                    return flights.get(0).getPassengers().get(0).getPassengerDetails().getName().getLastName();
                case "firstname":
                    return  flights.get(0).getPassengers().get(0).getPassengerDetails().getName().getFirstName();
                case "email":
                    return  flights.get(0).getPassengers().get(0).getPassengerDetails().getEmail();
                case "bookingreference":
                    return booking.getBookingContext().getBooking().getBookingReference();
                case "title":
                    return  flights.get(0).getPassengers().get(0).getPassengerDetails().getName().getTitle();
                case "travelfromdate":
                    return flights.get(0).getDepartureDateTime();
            }
        }
        catch(Exception ex)
        {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
        return null;
    }

    private static String getValueBasedOnCustomer(GetBookingResponse booking, String param) throws ExampleCompromisedException {
        try {
            switch (param.toLowerCase()) {
                case "lastname":
                    return booking.getBookingContext().getBooking().getBookingContact().getName().getLastName();
                case "firstname":
                    return booking.getBookingContext().getBooking().getBookingContact().getName().getFirstName();
                case "email":
                    return booking.getBookingContext().getBooking().getBookingContact().getEmailAddress();
                case "bookingreference":
                    return booking.getBookingContext().getBooking().getBookingReference();
                case "title":
                    return booking.getBookingContext().getBooking().getBookingContact().getName().getTitle();
                case "travelfromdate":
                    if (booking.getBookingContext().getBooking().getOutbounds() != null) {
                        return new DateFormat().WithDate(booking.getBookingContext().getBooking().getOutbounds().get(0).getFlights().get(0).getDepartureDateTime()).AsYearMonthDay();
                    }
                case "traveltodate":
                    if (booking.getBookingContext().getBooking().getInbounds() != null) {
                        return new DateFormat().WithDate(booking.getBookingContext().getBooking().getInbounds().get(0).getFlights().get(0).getDepartureDateTime()).AsYearMonthDay();
                    }
                case "postcode":
                    return booking.getBookingContext().getBooking().getBookingContact().getAddress().getPostalCode();
            }
        }
        catch (Exception ex)
        {
            throw new ExampleCompromisedException(INSUFFICIENT_DATA);
        }
        return null;
    }

    public static FindBookingQueryParams Basic_FindBookingParams(GetBookingResponse booking, boolean searchInPassenger) throws ExampleCompromisedException {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        if (searchInPassenger) {
            criteria.setLastName(getValue(booking, "lastname"));
            criteria.setFirstName(getValue(booking, "firstname"));
            criteria.setEmail(getValue(booking, "email"));
            criteria.setReferenceNumber(getValue(booking, "bookingreference"));
            criteria.setTitle(getValue(booking, "title"));
            criteria.setSearchInPax("true");
            //criteria.setTravelFromDate(getValue(booking, "travelfromdate"));
        } else {
            criteria.setLastName(getValueBasedOnCustomer(booking, "lastname"));
            criteria.setFirstName(getValueBasedOnCustomer(booking, "firstname"));
            criteria.setEmail(getValueBasedOnCustomer(booking, "email"));
            criteria.setReferenceNumber(getValueBasedOnCustomer(booking, "bookingreference"));
            criteria.setTitle(getValueBasedOnCustomer(booking, "title"));
            //criteria.setTravelFromDate(getValueBasedOnCustomer(booking, "travelfromdate"));
        }
        return criteria;
    }

    public static FindBookingQueryParams Basic_FindBookingParamsWithDates(GetBookingResponse booking, boolean searchInPassenger) throws ExampleCompromisedException {
        FindBookingQueryParams criteria = Basic_FindBookingParams(booking, searchInPassenger);
        if (searchInPassenger) {
            criteria.setTravelFromDate(getValue(booking, "travelfromdate"));
        } else {
            criteria.setTravelFromDate(getValueBasedOnCustomer(booking, "travelfromdate"));
        }
        return criteria;
    }

    public static FindBookingQueryParams EmptyTheField(String fields, FindBookingQueryParams criteria)
    {
        List<String> parameters = Arrays.asList(fields.split("\\s*,\\s*"));
        for (String param : parameters) {
            set(criteria, param, null);
        }
        return criteria;
    }

    public static FindBookingQueryParams SetBookingParams(GetBookingResponse booking, String params, boolean searchInPassenger) throws ExampleCompromisedException {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        List<String> parameters = Arrays.asList(params.split("\\s*,\\s*"));
        for (String param : parameters) {
                if (searchInPassenger)
                    set(criteria, param, getValue(booking, param));
                else
                    set(criteria, param, getValueBasedOnCustomer(booking, param));
        }

        return criteria;
    }

    public static FindBookingQueryParams SetBookingParams(GetBookingResponse booking, String params) throws ExampleCompromisedException {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        List<String> parameters = Arrays.asList(params.split("\\s*,\\s*"));
        for (String param : parameters) {
                set(criteria, param, getValue(booking, param));
        }

        return criteria;
    }

    public static FindBookingQueryParams SetBookingParams(GetBookingResponse booking, String param, int charcount) {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        try {
            Field field = Booking.class.getField(param);
            set(criteria, param, getValue(booking, param));
            set(criteria, "firstname", getValue(booking, "firstname").substring(0, charcount));
        } catch (Exception ex) {
            //TODO what is this try/catch for?
        }
        return criteria;
    }

    public static FindBookingQueryParams SetBookingParams(GetBookingResponse booking, String params, String caseFormat) {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        List<String> parameters = Arrays.asList(params.split("\\s*,\\s*"));
        CaseConverter c = new CaseConverter();
        for (String param : parameters) {
            try {
                set(criteria, param, c.Convert(getValue(booking, param), caseFormat));
            } catch (Exception ex) {
                //TODO what is this try/catch for?
            }
        }
        return criteria;
    }

    public static FindBookingQueryParams invalidBooking() {
        //get existing bookings
        //create random bookingreference
        //check it is not in the list
        //return created criteria
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        set(criteria, "bookingreference", InvalidBookingRef());
        return criteria;
    }

    private static String InvalidBookingRef() {
        //TODO: look up to check this is in fact, invalid
        return "93287hlkshedf";
    }

    public static FindBookingQueryParams BookingWithUnmatchableSearchCriteria(String params) {
        //get all booking refs
        //create random data for the provided paramaters
        //return the invalid criteria
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        List<String> parameters = Arrays.asList(params.split("\\s*,\\s*"));
        for (String param : parameters) {
            set(criteria, param, UnmatchableSearchCriterion(param));
        }
        return criteria;
    }

    public static FindBookingQueryParams BookingWithInvalidEmailIdAsSearchCriteria() {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        set(criteria, "email", InvalidEmailID());
        return criteria;
    }

    private static String UnmatchableSearchCriterion(String param) {
        //TODO: actually search and make sure it is unique!!
        switch (param)
        {
            case "travelToDate": return getDate(-10);
            case "travelFromDate":return getDate(-50);
            case "email": return "testneverexists@example.com";
            default: return "a";
        }
    }

    public static String getDate(int diff) {
        Format f = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, diff);
        return f.format(cal.getTime()).toString();

    }

    private static String InvalidEmailID() {
        return "tejal.dud";
    }

    public static FindBookingQueryParams searchWithOnlyThisParameter(String parameter, String value) {
        FindBookingQueryParams criteria = FindBookingQueryParams.builder().build();
        criteria.setParameter(parameter, value);
        return criteria;
    }
}
