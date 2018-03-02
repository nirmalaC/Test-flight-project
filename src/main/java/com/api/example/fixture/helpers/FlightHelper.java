package com.api.example.fixture.helpers;

import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.flights.Flight;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * Created by dwebb on 12/12/2016.
 */
public class FlightHelper {

    public Flight updateInfantQuantity(int quantity, Flight flight, boolean infantOnSeat) {
        flight.getFareTypes().forEach(
                f -> f.getPassengers().forEach(
                        p -> {
                            if (p.getType().toLowerCase().equals("infant")) {
                                p.setQuantity(quantity);
                                p.setAdditionalSeats(0);
                                p.setInfantOnSeat(infantOnSeat);
                            }
                        }
                )
        );

        return flight;

    }

    public AddFlight SetFieldAsMissing(String key, AddFlight flight) {
        switch (key) {
            case "flightKey":
                flight.setFlightKey(null);
                break;
            case "fareType":
                flight.setFareType(null);
                break;
            case "journeyType":
                flight.setJourneyType(null);
                break;
            case "price":
                flight.setPrice(null);
                break;
            case "TOEICode":
                flight.setToeiCode(null);
                break;
            case "passengers":
                flight.setPassengers(null);
                break;
        }

        return flight;

    }

    public AddFlight SetFieldAsInvalid(String key, AddFlight flight) {
        DataFactory df = new DataFactory();
        switch (key) {
            case "flightKeyInvalid":
                flight.setFlightKey(df.getRandomChars(18));
                break;
            case "fareTypeInvalid":
                flight.setFareType(df.getRandomChars(8));
                break;
            case "journeyTypeInvalid":
                flight.setJourneyType(df.getRandomChars(8));
                break;
            case "priceInvalid":
                flight.setPrice(-100.00);
                break;
            case "TOEICodeInvalid":
                flight.setToeiCode(df.getRandomChars(8));
                break;
        }

        return flight;

    }

    public String GetFieldValue(AddFlight flight, String key) {
        switch (key) {
            case "journeyTypeInvalid":
                return flight.getJourneyType();
        }

        return null;

    }

}
