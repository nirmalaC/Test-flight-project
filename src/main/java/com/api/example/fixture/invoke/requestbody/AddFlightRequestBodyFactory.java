package com.api.example.fixture.invoke.requestbody;

import com.api.example.database.FlightFinder;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.exceptions.ExampleCompromisedException;
import com.api.example.fixture.helpers.Passengers;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.basket.Passenger;
import com.api.example.fixture.invoke.response.flights.FareType;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.INSUFFICIENT_UNIQUE_CURRENCY_FLIGHTS;

/**
 * Created by daniel on 30/11/2016.
 */
@ToString
@Component
public class AddFlightRequestBodyFactory {

    private final FlightFinder flightFinder;
    private final ServiceFactory serviceFactory;
    private String defaultPassengerMix = "1 Adult";
    private String defaultCurrency = "GBP";
    private String toeiCode = "ABC";
    private String minPassengerMix = "1 Adult";
    private String passengerMix;
    @Getter
    private List<multiFlightData> multiFlightAvailableData;

    @Autowired
    public AddFlightRequestBodyFactory(ServiceFactory serviceFactory, FlightFinder flightFinder) {
        this.flightFinder = flightFinder;
        this.serviceFactory = serviceFactory;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public AddFlight buildFlightRequestWithRequiredFare(Flight flight, String requiredFare) {
        return buildFlightRequest(flight, defaultPassengerMix, defaultCurrency, "OUTBOUND", requiredFare);
    }

    public AddFlight buildFlightRequest(Flight flight) {
        return buildFlightRequest(flight, defaultPassengerMix, defaultCurrency, "OUTBOUND");
    }

    public AddFlight buildFlightRequest(Flight flight, String passengerMix) {
        return buildFlightRequest(flight, passengerMix, defaultCurrency, "OUTBOUND");
    }

    public AddFlight buildFlightRequest(Flight flight, String passengerMix, String currency, String journeyType)
    {
        return buildFlightRequest(flight, passengerMix, currency, journeyType, null);
    }

    public AddFlight buildFlightRequest(Flight flight, int numberOfPassengers, String journeyType)
    {
        if (numberOfPassengers > 0) {
            passengerMix = numberOfPassengers + " Adult";
        }
        else {
            numberOfPassengers = 1;
            passengerMix = minPassengerMix;
        }

        return buildFlightRequest(flight, passengerMix, defaultCurrency, journeyType, null);
    }

    private AddFlight buildFlightRequest(Flight flight, String passengerMix, String currency, String journeyType, String requiredFare) {
        //Passengers passengers = new Passengers(passengerMix);

        List<faresAndPrice> faresAndPrices = getBasePriceForPassengerMix(flight);

        String fareType = "STANDARD";
        Double price = totalBasePrice(faresAndPrices);
        Passengers passengers = null;

        if (requiredFare == null) {
            for (faresAndPrice fp : faresAndPrices) {
                if (fp.getNumberOfSeatsAvailableInClass() >= fp.passengers.getTotalNumberOfPassengers()) {
                    fareType = fp.getFareType();
                    price = fp.getTotalBasePriceForFare();
                    passengers = fp.getPassengers();
                }
            }
        }
        else
        {
            faresAndPrice fp = faresAndPrices.stream().filter(g -> g.getFareType().equals(requiredFare)).findFirst().orElse(null);
            fareType = fp.getFareType();
            price = fp.getTotalBasePriceForFare();
            passengers = fp.getPassengers();
        }

        return AddFlight.build()
                .flightKey(flight.getFlightKey())
                .toeiCode("ABC")
                .currency(currency)
                .fareType(fareType)
                .journeyType(journeyType)
                .price(price)
                .overrideWarning(false)
                .routeCode(flight.getDeparture().getAirportCode() + "" + flight.getArrival().getAirportCode())
                .passengers(passengers.getPassengers()).execute();
    }

    public List<AddFlight> flightsToAdd(int numberOfFlightsToAdd) throws Throwable {
        return flightsToAdd(numberOfFlightsToAdd, 1,false);
    }

    public List<AddFlight> flightsToAdd(int numberOfFlightsToAdd, int numberOfPassengersPerFlight) throws Throwable {
        return flightsToAdd(numberOfFlightsToAdd, numberOfPassengersPerFlight, false);
    }

    public List<AddFlight> flightsToAdd(int numberOfFlightsToAdd, boolean departureAirportCurrencyMustBeUnique) throws Throwable {
        return flightsToAdd(numberOfFlightsToAdd, 1, departureAirportCurrencyMustBeUnique);
    }

//    public List<AddFlight> flightsToAdd(int numberOfFlightsToAdd, boolean departureAirportCurrencyMustBeUnique) throws Throwable {
//    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
//        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
//        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
//    }

    public List<AddFlight> flightsToAdd(int numberOfFlightsToAdd, int numberOfPassengersPerFlight, boolean departureAirportCurrencyMustBeUnique) throws Throwable {

        if (numberOfPassengersPerFlight > 0) {
            passengerMix = numberOfPassengersPerFlight + " Adult";
        }
        else {
            numberOfPassengersPerFlight = 1;
            passengerMix = minPassengerMix;
        }

        List<AddFlight> flights = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDate previousDepartureDate = LocalDate.now();
        List<ExampleFlightDbModel> validFlights = flightFinder.findValidFlights();

        if (departureAirportCurrencyMustBeUnique) {
            validFlights = validFlights.stream().filter(distinctByKey(p -> p.getCurrency())).collect(Collectors.toList());
            if (validFlights.size() < 2)
            {
                throw new ExampleCompromisedException(INSUFFICIENT_UNIQUE_CURRENCY_FLIGHTS);
            }
        }

        multiFlightAvailableData = new ArrayList<>();
        //for (int i = 0; i < numberOfFlightsToAdd; i++) {
        int foundFlights = 0;
        for (ExampleFlightDbModel validFlight : validFlights) {

            LocalDate nextDepartureDate = LocalDate.parse(validFlight.getPlannedDepartureTime(), format);

            if (nextDepartureDate.isAfter(previousDepartureDate)) {

                FlightQueryParams criteria =
                        FlightQueryParamsFactory.generateFlightSearchCriteria(validFlight).adult(String.valueOf(numberOfPassengersPerFlight)).build();

                FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), criteria));
                flightsService.invoke();

                multiFlightData data = new multiFlightData();
                data.flightQueryParams = criteria;
                data.availableSeats = flightsService.getResponse().getOutbound().getResult().getJourneys().get(0).getFlights().get(0).getInventory().getAvailable();

                multiFlightAvailableData.add(data);

                    AddFlight flightToAdd = buildFlightRequest(
                            flightsService.getResponse().getOutbound().getResult().getJourneys().get(0).getFlights().get(0),
                            passengerMix,
                            flightsService.getResponse().getCurrency(), "OUTBOUND");

                flights.add(flightToAdd);
                previousDepartureDate = nextDepartureDate;
                foundFlights++;
            }

            if (foundFlights >= numberOfFlightsToAdd) {
                break;
            }

        }

        if (departureAirportCurrencyMustBeUnique && flights.size() < numberOfFlightsToAdd)
            {
                throw new ExampleCompromisedException(INSUFFICIENT_UNIQUE_CURRENCY_FLIGHTS);
            }

        return flights;
    }

    public AddFlight getAddFlightWithMissingParameter(String parameter) throws Throwable {
        //set currency and passenger mix to minimum default
        String currency = "GBP";
        String passengerMix = "1 Adult";
        String journeyType = "OUTBOUND";
        FlightQueryParams criteria =
                FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight()).adult("1").build();
        FlightsService flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid("Digital").build(), criteria));
        flightsService.invoke();


        Flight flight = flightsService.getResponse().getOutbound().getResult().getJourneys().get(0).getFlights().get(0);
        List<faresAndPrice> faresAndPrices = getBasePriceForPassengerMix(flight);

        AddFlight.AddFlightBuilder builder = AddFlight.build();

        builder.flightKey(flight.getFlightKey())
                .currency(currency)
                .toeiCode(toeiCode) ///TODO find out what this is supposed to be
                .fareType(allFareTypes(faresAndPrices))
                .journeyType(journeyType)
                .price(totalBasePrice(faresAndPrices))
                .overrideWarning(true)
                .routeCode(flight.getDeparture().getAirportCode() + "" + flight.getArrival().getAirportCode())
                .passengers(SetPassengersFromMix(passengerMix));

        switch (parameter) {
            case "flightKey":
                builder.flightKey(null);
                break;
            case "price":
                builder.price(null);
            case "currency":
                builder.currency(null);
            case "fareType":
                builder.fareType(null);
            case "journeyType":
                builder.journeyType(null);
            case "passengers":
                builder.passengers(null);
        }

        return builder.execute();
    }

    private String allFareTypes(List<faresAndPrice> fps) {
        String fares = "";
        for (faresAndPrice fp : fps) {
            fares += fp.getFareType();
        }
        return fares;
    }

    private List<Passenger> SetPassengersFromMix(String passengerMix) {
        Passengers passengers = new Passengers(passengerMix);
        return passengers.getPassengers();
    }

    private Double totalBasePrice(List<faresAndPrice> fps) {
        Double total = 0.0;
        for (faresAndPrice fp : fps) {
            total += fp.getTotalBasePriceForFare();
        }
        return total;
    }

    private List<faresAndPrice> getBasePriceForPassengerMix(Flight flight) {
        List<faresAndPrice> fpList = new ArrayList<>();

        DecimalFormat decim = new DecimalFormat("0.00");
        for (FareType fType : flight.getFareTypes()) {
            faresAndPrice fp = new faresAndPrice();
            fp.setTotalBasePriceForFare(0.0);
            fp.setNumberOfSeatsAvailableInClass(0);
            fp.setFareType(fType.getFareTypeCode());
            String paxMix = "";
            for (com.api.example.fixture.invoke.response.flights.Passenger pax : fType.getPassengers()) {
                fp.setTotalBasePriceForFare(fp.getTotalBasePriceForFare() + Double.parseDouble(decim.format(pax.getBasePrice() * pax.getQuantity())));
                fp.setNumberOfSeatsAvailableInClass(fp.getNumberOfSeatsAvailableInClass() + pax.getQuantity());
                if (paxMix != "") {
                    paxMix += ", ";
                }
                paxMix += pax.getQuantity() + " " + pax.getType();
                if (pax.getType().toLowerCase().equals("infant")) {
                    if (pax.getInfantOnSeat()) {
                        paxMix += " OOS";
                    } else {
                        paxMix += " OL";
                    }
                }
            }
            fp.passengers = new Passengers(paxMix);
            fpList.add(fp);
        }

        return fpList;
    }

    @Getter
    public class multiFlightData {
        @Getter
        @Setter
        private FlightQueryParams flightQueryParams;
        @Getter
        @Setter
        private int availableSeats;
    }

    private class PassengerMix {
        @Getter
        @Setter
        private int num;
        @Getter
        @Setter
        private String type;

        PassengerMix(int number, String paxType) {
            setNum(number);
            setType(paxType);
        }
    }

    private class faresAndPrice {
        @Getter
        @Setter
        private String fareType;
        @Getter
        @Setter
        private Double totalBasePriceForFare;
        @Getter
        @Setter
        private int numberOfSeatsAvailableInClass;
        @Getter
        @Setter
        private Passengers passengers;
    }

}
