package com.api.example.fixture.invoke.queryparams;

import com.api.example.database.FlightFinder;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.fixture.helpers.Passengers;
import com.api.example.fixture.invoke.response.basket.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by grizhenkova on 11/24/2016.
 */
@Component
public class FlightQueryParamsFactory {

    private static Logger LOG = LogManager.getLogger(FlightQueryParamsFactory.class);


    public static FlightQueryParams InvalidFlightParams(FlightFinder flightFinder, String params) throws Throwable {
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter badFormat = DateTimeFormatter.BASIC_ISO_DATE;
        switch (params) {

            case "outbound date is before today":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.minusDays(1).format(format)).adult("1").build();
            case "inbound date is before outbound date":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).inboundDate(today.plusDays(4).format(format)).adult("1").build();
            case "outbound date in a wrong format":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.format(badFormat)).adult("1").build();
            case "inbound date in a wrong format":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).inboundDate(today.format(badFormat)).adult("1").build();
            case "no origin airport":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).origin("").adult("1").build();
            case "no destination airport":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).destination("").adult("1").build();
            case "wrong destination airport":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).destination("XXX").adult("1").build();
            case "wrong origin airport":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).origin("XXX").adult("1").build();
            case "wrong route":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.plusDays(5).format(format)).origin("LTN").destination("LHR").adult("1").build();
            case "multiple incorrect search criteria":
                return generateFlightSearchCriteria(flightFinder.findAValidFlight()).outboundDate(today.minusDays(5).format(format)).origin("LTN").destination("LHR").adult("41").build();
            default:
                throw new IllegalArgumentException("This is not a valid test parameter: " + params);
        }
    }

    public static FlightQueryParams generateFlightSearchCriteria(ExampleFlightDbModel flight, Passengers passengers) {
        FlightQueryParams criteria = generateFlightSearchCriteria(flight).build();
        for (Passenger pax : passengers.getPassengers()) {
            if (pax.getPassengerType().toLowerCase().contains("adult")) {
                if (pax.getAdditionalSeats() != 0) {
                    criteria.setAdult(pax.getQuantity() + "," + pax.getAdditionalSeats());
                } else {
                    criteria.setAdult(Integer.toString(pax.getQuantity()));
                }
            }
            if (pax.getPassengerType().toLowerCase().contains("child")) {
                if (pax.getAdditionalSeats() != 0) {
                    criteria.setChild(pax.getQuantity() + "," + pax.getAdditionalSeats());
                } else {
                    criteria.setChild(Integer.toString(pax.getQuantity()));
                }
            }
            if (pax.getPassengerType().toLowerCase().contains("infant")) {
                if (pax.getInfantOwnSeat()) {
                    criteria.setInfant(pax.getQuantity() + "," + pax.getQuantity());
                } else {
                    criteria.setInfant(Integer.toString(pax.getQuantity()));
                }
            }
        }
        return criteria;
    }

    public static FlightQueryParams.FlightQueryParamsBuilder generateFlightSearchCriteria(ExampleFlightDbModel flight) {
        return FlightQueryParams.builder()
                .origin(flight.getDeparts())
                .destination(flight.getArrives())
                .outboundDate(flight.getLocalDepartureDate());
    }

    public static FlightQueryParams.FlightQueryParamsBuilder generateReturnFlightSearchCriteria(ExampleFlightDbModel flight) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return FlightQueryParams.builder()
                .origin(flight.getDeparts())
                .destination(flight.getArrives())
                .outboundDate(today.plusDays(1).format(format))
                .inboundDate(today.plusDays(14).format(format));
    }
}
