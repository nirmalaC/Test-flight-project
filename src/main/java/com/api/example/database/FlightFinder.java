package com.api.example.database;

import com.api.example.database.otherdb.OtherDBFlightsDao;
import com.api.example.database.example.ExampleFlightsDao;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.exceptions.ExampleCompromisedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.NO_FLIGHTS_IN_OTHERDB;
import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.NO_FLIGHTS_IN_OTHERDB_AND_EXAMPLE;

/**
 * Created by daniel on 23/11/2016.
 * find
 */
@Component
public class FlightFinder {

    static Random rand = new Random();
    private OtherDBFlightsDao otherDBFlightsDao;
    private ExampleFlightsDao exampleFlightsDao;

    //TODO we need to provide the ability to identify return flights TO/FROM same source and destination

    /**
     * @param otherDBFlightsDao autowired datasource which allows connectivity to the OtherDB database
     * @param exampleFlightsDao autowired datasource which allows connectivity to the Example database
     */
    @Autowired
    public FlightFinder(OtherDBFlightsDao otherDBFlightsDao, ExampleFlightsDao exampleFlightsDao) {
        this.otherDBFlightsDao = otherDBFlightsDao;
        this.exampleFlightsDao = exampleFlightsDao;
    }

    private static <T> T getRandomItem(List<T> list) throws Throwable {
        try {
            return list.get(rand.nextInt(list.size()));
        } catch (Exception ex) {
            throw new ExampleCompromisedException(ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA);
        }
    }

    private static <T> T getFirstItem(List<T> list) throws Throwable {
        try {
            return list.get(0);
        } catch (Exception ex) {
            throw new ExampleCompromisedException(ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_DATA);
        }
    }

    private Calendar getFromDate() {
        Calendar fromDate = Calendar.getInstance(); // creates calendar
        fromDate.setTime(new Date()); // sets calendar time/date
        fromDate.add(Calendar.HOUR_OF_DAY, 2); // adds two hours
        return fromDate;
    }

    private Calendar getToDate() {
        Calendar toDate = Calendar.getInstance();
        toDate.setTime(new Date()); // Now use today date.
        toDate.add(Calendar.DATE, 60);

        return toDate;
    }

    /**
     *
     * @param totalPassengers desired number of available seats on the flight
     * @return a flight with the desired number of available seats
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight(int totalPassengers) throws Throwable {
        return getRandomItem(findValidFlights(getFromDate(), getToDate(), totalPassengers, null, null, null));
    }

    /**
     *
     * @param totalPassengers desired number of available seats on the flight
     * @return a flight with the desired number of available seats
     * @param bundles  a comma separated list of bundles types eg "Regular Fare,Flexible Fares" to return from OtherDB
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight(int totalPassengers, String bundles) throws Throwable {
        return getRandomItem(findValidFlights(getFromDate(), getToDate(), totalPassengers, null, null, bundles));
    }

    /**
     *
     * @return a flight with at least one available seat
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight() throws Throwable {
        return getRandomItem(findValidFlights(getFromDate(), getToDate(), 1, null, null, null));
    }

    /**
     *
     * @return a flight with at least one available seat
     * @param bundles a comma separated list of bundles types eg "Regular Fare,Flexible Fares" to return from OtherDB
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight(String bundles) throws Throwable {
        return getRandomItem(findValidFlights(getFromDate(), getToDate(), 1, null, null, bundles));
    }

    /**
     *
     * @param fromDate the date that the flight shoudl depart after
     * @param toDate the date that the flight should depart before
     * @param numberOfPassengers the desired number of available seats on the flight
     * @return a flight that departs between the dates with the desired number of available seats
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight(Calendar fromDate, Calendar toDate, int numberOfPassengers) throws Throwable {
        return getRandomItem(findValidFlights(fromDate, toDate, numberOfPassengers, null, null, null));
    }

    /**
     *
     * @param fromDate the date that the flight shoudl depart after
     * @param toDate the date that the flight should depart before
     * @param numberOfPassengers the desired number of available seats on the flight
     * @param depAirport
     * @param arrAirport
     * @return a flight that departs between the dates with the desired number of available seats
     * @throws Throwable
     */
    public ExampleFlightDbModel findAValidFlight(Calendar fromDate, Calendar toDate, int numberOfPassengers, String depAirport, String arrAirport) throws Throwable {
        return getRandomItem(findValidFlights(fromDate, toDate, numberOfPassengers, depAirport, arrAirport, null));
    }


    /**
     *
     * @return a list of flights with at least one available seat
     * @throws Throwable
     */
    public List<ExampleFlightDbModel> findValidFlights() throws Throwable {
        return findValidFlights(getFromDate(), getToDate(), 1, null, null, null);
    }

    public ExampleFlightDbModel findAValidReturnFlight (int numberOfPassengers) throws Throwable {
        return getFirstItem(findValidFlightsWithReturnFlights(getFromDate(), getToDate(), numberOfPassengers, null, null, null));
    }

    /**
     *
     * @param fromDate the date that the flight shoudl depart after
     * @param toDate the date that the flight should depart before
     * @param numberOfPassengers the desired number of available seats on the flight
     * @param bundles nullable string of the bundles to return from OtherDB, eg "Flexible Fares, Regular Fare"
     * @param depAirport nullable string
     * @param arrAirport nullable string
     * @return a flight that departs between the dates with the desired number of available seats
     * @throws ExampleCompromisedException an exception which provides the ability to filter the serenity report
     */
    public List<ExampleFlightDbModel> findValidFlights(Calendar fromDate, Calendar toDate, int numberOfPassengers, String depAirport, String arrAirport, String bundles) throws ExampleCompromisedException {
        List<String> flightsAvailableInOtherDB;
        if (depAirport == null) {
            flightsAvailableInOtherDB = otherDBFlightsDao.getFlightsAvailableBetweenWithNumberOfPassengers(numberOfPassengers, fromDate, toDate, bundles);
            if (flightsAvailableInOtherDB.size() < 1) {
                throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB);
            }
        } else {
            flightsAvailableInOtherDB = otherDBFlightsDao.getFlightsAvailableBetweenFromAndToWithNumberOfPassengers(numberOfPassengers, fromDate, toDate, depAirport, arrAirport);
            if (flightsAvailableInOtherDB.size() < 1) {
                throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB);
            }
        }
        List<ExampleFlightDbModel> flightsAvailableInExampleAndOtherDB= exampleFlightsDao.returnFlightsThatExistFromList(flightsAvailableInOtherDB);
        if (flightsAvailableInExampleAndOtherDB.size() < 1) {
            throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB_AND_EXAMPLE);
        }
        return flightsAvailableInExampleAndOtherDB;
    }

    public List<ExampleFlightDbModel> findValidFlightsWithReturnFlights (Calendar fromDate, Calendar toDate, int numberOfPassengers, String depAirport, String arrAirport, String bundles) throws ExampleCompromisedException {
        List<String> retutnFlightsAvailableinOtherDB = new ArrayList<>();
        List<String> flightsAvailableInOtherDB;
        if (depAirport == null) {
            flightsAvailableInOtherDB = otherDBFlightsDao.getFlightsAvailableBetweenWithNumberOfPassengers(numberOfPassengers, fromDate, toDate, bundles);
            if (flightsAvailableInOtherDB.size() < 1) {
                throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB);
            }
        } else {
            flightsAvailableInOtherDB = otherDBFlightsDao.getFlightsAvailableBetweenFromAndToWithNumberOfPassengers(numberOfPassengers, fromDate, toDate, depAirport, arrAirport);
            if (flightsAvailableInOtherDB.size() < 1) {
                throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB);
            }
        }

        for (String flight : flightsAvailableInOtherDB) {
            String departureAirport = flight.substring(8, 11);
            String arrivalAirport = flight.substring(11, 14);
            String returnFlightkey = arrivalAirport + departureAirport;

            for (String comapareflight : flightsAvailableInOtherDB) {
                if (comapareflight.contains(returnFlightkey)){
                    if(!retutnFlightsAvailableinOtherDB.contains(flight))
                        retutnFlightsAvailableinOtherDB.add(flight);
                }

            }
        }

        List<ExampleFlightDbModel> flightsAvailableInExampleAndOtherDB= exampleFlightsDao.returnFlightsThatExistFromList(retutnFlightsAvailableinOtherDB);
        if (flightsAvailableInExampleAndOtherDB.size() < 1) {
            throw new ExampleCompromisedException(NO_FLIGHTS_IN_OTHERDB_AND_EXAMPLE);
        }
        return flightsAvailableInExampleAndOtherDB;
    }

}
