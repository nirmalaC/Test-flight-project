package com.api.example.fixture.helpers;


import com.api.example.fixture.invoke.response.basket.Passenger;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel on 01/12/2016.
 */
@Data
public class Passengers {

    private List<Passenger> passengers = new ArrayList<>();

    public Passengers(String passengersString) {
        List<String> types = Arrays.asList(passengersString.split("\\s*,\\s*"));
        for (String t : types) {
            String[] a = t.split("\\s+");
            if (t.toLowerCase().contains("adult")) {
                passengers.add(SetPassenger("adult", Integer.parseInt(a[0])));
            }
            if (t.toLowerCase().contains("child")) {
                passengers.add(SetPassenger("child", Integer.parseInt(a[0])));
            }
            if (t.toLowerCase().contains("infant")) {
                if (a.length > 2) {
                    if (a[2].equals("OOS")) {
                        passengers.add(SetPassenger("infant", Integer.parseInt(a[0]), 0, true));
                    } else {
                        passengers.add(SetPassenger("infant", Integer.parseInt(a[0])));
                    }
                } else {
                    passengers.add(SetPassenger("infant", Integer.parseInt(a[0])));
                }
            }
        }
    }

    private Passenger SetPassenger(String type, int number) {
        return Passenger.builder().passengerType(type).additionalSeats(0).quantity(number).build();
    }

    private Passenger SetPassenger(String typeOfPassenger, int numberOfPassengers, int additionalSeats, boolean infantOnSeat) {
        return Passenger.builder().passengerType(typeOfPassenger).quantity(numberOfPassengers).additionalSeats(additionalSeats).infantOwnSeat(infantOnSeat).build();
    }

    public int getTotalNumberOfPassengers() {
        int totalNumberOfPassengers = 0;
        for (Passenger passenger : passengers) {
            totalNumberOfPassengers += passenger.getQuantity();
        }
        return totalNumberOfPassengers;
    }
}
