package com.api.example.fixture.helpers;

import com.api.example.database.FlightFinder;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.BasketAddFlightPathParams;
import com.api.example.fixture.invoke.pathparams.BasketPathParams;
import com.api.example.fixture.invoke.pathparams.BasketTravellerPathParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import com.api.example.fixture.invoke.requestbody.AddFlightRequestBodyFactory;
import com.api.example.fixture.invoke.requestbody.EmptyRequestBody;
import com.api.example.fixture.invoke.requests.BasketRequest;
import com.api.example.fixture.invoke.requests.BasketTravellerRequest;
import com.api.example.fixture.invoke.requests.FlightsRequest;
import com.api.example.fixture.invoke.response.basket.AddFlight;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.flights.Flight;
import com.api.example.fixture.invoke.response.traveller.Travellers;
import com.api.example.fixture.invoke.services.BasketService;
import com.api.example.fixture.invoke.services.BasketTravellerService;
import com.api.example.fixture.invoke.services.FlightsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.HttpMethod;
import java.util.List;


/**
 * Created by dwebb on 11/25/2016.
 * assertion wrapper for baskets response object, provides reusable assertions to all tests
 */
@Component
public class BasketHelper {

    private static Logger LOG = LogManager.getLogger(BasketHelper.class);
    private final AddFlightRequestBodyFactory addFlightRequestBodyFactory;
    private final FlightFinder flightFinder;
    private final ServiceFactory serviceFactory;
    private FlightsService flightsService;
    private BasketService basketService;
    private BasketTravellerService basketTravellerService;
    private String fareType;
    private Flight outboundFlight;
    private AddFlight addedFlight;

    /**
     * @param addFlightRequestBodyFactory autowired factory class for generating flight request body
     * @param flightFinder                autowired class to find flights that can be used for testing
     * @param serviceFactory              autowired class that returns service objects, bridges the gap from spring to non spring managed classes
     */
    @Autowired
    public BasketHelper(AddFlightRequestBodyFactory addFlightRequestBodyFactory, FlightFinder flightFinder, ServiceFactory serviceFactory) {
        this.addFlightRequestBodyFactory = addFlightRequestBodyFactory;
        this.flightFinder = flightFinder;
        this.serviceFactory = serviceFactory;
    }

    /**
     * @return request body representing the flight you wish to add to the basket
     */
    public AddFlight getAddedFlight() {
        return addedFlight;
    }

    /**
     * @return flight object returned fom findFlights
     */
    public Flight getOutboundFlight() {
        return outboundFlight;
    }

    /**
     * @return fare type
     */
    public String getFareTypeUsed() {
        if (fareType != null) {
            return fareType;
        }

        return "";
    }

    /**
     * @param flight  flight to add to the basket
     * @param channel channel to use to call the service
     * @param requiredFare the fare code to be used
     * @throws Exception
     */
    public void addFlightToBasketAsChannelUsingFareCode(Flight flight, String channel, String requiredFare) throws Exception {
        fareType = requiredFare;
        AddFlight aFlight = addFlightRequestBodyFactory.buildFlightRequestWithRequiredFare(flight, requiredFare);
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), aFlight);
    }

    /**
     * @param flight  flight to add to the basket
     * @param channel channel to use to call the service
     * @throws Exception
     */
    public void addFlightToBasketAsChannel(Flight flight, String channel) throws Exception {
        AddFlight aFlight = addFlightRequestBodyFactory.buildFlightRequest(flight);
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), aFlight);
    }

    /**
     * @param numberOfFlights    number of flights to add to the basket
     * @param numberOfPassengers number of passengers to be booked on each flight
     * @param channel            channel to use to call the service
     * @throws Throwable
     */
    public void addFlightToBasketAsChannel(int numberOfFlights, int numberOfPassengers, String channel) throws Throwable {
        for (AddFlight flightToAdd : addFlightRequestBodyFactory.flightsToAdd(numberOfFlights, numberOfPassengers)) {
            addFlightToBasket(ExampleHeaders.getValid(channel).build(), flightToAdd);
        }
    }

    public void addFlightToBasketAsChannel(int numberOfPassengers, String channel) throws Throwable {
        addFlightToBasketAsChannel(1, numberOfPassengers, channel);
    }

    /**
     * @param flight  the fight to add to the basket
     * @param channel the channel to use to call the service
     * @throws Exception
     */
    public void addFlightToBasketAsChannel(AddFlight flight, String channel) throws Exception {
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), flight);
    }

    /**
     * @param flight the flight to add to the basket
     * @return the request body for the flight
     */
    public AddFlight CreateAddFlightRequest(Flight flight) {
        return addFlightRequestBodyFactory.buildFlightRequest(flight);
    }

    /**
     * @return the basket service object
     */
    public BasketService getBasketService() {
        return basketService;
    }

    /**
     * @return the bastket traveller service object
     */
    public BasketTravellerService getBasketTravellerService() {
        return basketTravellerService;
    }

    /**
     * calls the update traveller service with channel Digital
     *
     * @param traveller the traveller to update
     * @param channel   the channel to call the service with
     * @param basketId  the basket Id for the basket you wish to update
     */
    public void updateTravellersForChannel(Travellers traveller, String channel, String basketId) {
        BasketTravellerPathParams pathParams = BasketTravellerPathParams.builder().basketId(basketId).build();
        basketTravellerService = serviceFactory.get(new BasketTravellerRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.PUT, pathParams, traveller));
        basketTravellerService.invoke();
    }

    /**
     * @param traveller the traveller to update
     * @param channel   the channel to call the service with
     * @param basketId  the basket ID for the basket you wish to
     * @return the basket traveller service object
     */
    public BasketTravellerService createUpdateTravellersRequestWithMissingParameterInBody(Travellers traveller, String channel, String basketId) {
        BasketTravellerPathParams pathParams = BasketTravellerPathParams.builder().basketId(basketId).build();
        return serviceFactory.get(new BasketTravellerRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.PUT, pathParams, traveller));
    }

    /**
     * calls the get basket service for the basket id provided for the DIGITAL channel
     *
     * @param basketId the basket Id for the basket you want to get
     */
    public void getBasket(String basketId) {
        getBasket(basketId, "Digital");
    }

    /**
     * calls the get basket service for the basket id provided for the channel provided
     *
     * @param basketId the basket Id for the basket you want to get
     * @param channel  the channel to be used in the header
     */
    public void getBasket(String basketId, String channel) {
        BasketPathParams pathParams = BasketPathParams.builder().basketId(basketId).get(true).build();
        //TODO this is a known
        basketService = serviceFactory.get(new BasketRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.GET, pathParams));
        basketService.invoke();
    }

    /**
     * @param numberOfFlights the number of flights you want to add to the basket
     * @throws Throwable
     */
    public void addNumberOfFlightsToBasket(int numberOfFlights) throws Throwable {
        for (AddFlight flightToAdd : addFlightRequestBodyFactory.flightsToAdd(numberOfFlights)) {
            addFlightToBasket(flightToAdd);
        }
    }

    /**
     * @param numberOfFlights the number of flights to add to the basket
     * @param channel         the channel to call the service with
     * @return a list of flights that have been added to the basket
     * @throws Throwable
     */
    public List<AddFlightRequestBodyFactory.multiFlightData> addNumberOfFlightsToBasket(int numberOfFlights, String channel) throws Throwable {
        for (AddFlight flightToAdd : addFlightRequestBodyFactory.flightsToAdd(numberOfFlights)) {
            addFlightToBasketAsChannel(flightToAdd, channel);
        }
        return addFlightRequestBodyFactory.getMultiFlightAvailableData();
    }

    /**
     * @return list of flights
     * @throws Throwable
     */
    public List<AddFlight> findMultipleFlightsWithDifferentBaseCurrencies() throws Throwable {
        return addFlightRequestBodyFactory.flightsToAdd(2, true);
    }

    /**
     * @param basketId the basket id for the basket you want
     * @param channel  the channel to use to call the service
     * @return the basket response
     */
    public BasketsResponse emptyBasket(String basketId, String channel) {
        BasketPathParams pathParams = BasketPathParams.builder().basketId(basketId).empty(true).build();
        basketService = serviceFactory.get(new BasketRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.PUT, pathParams, new EmptyRequestBody()));
        basketService.invoke();
        return basketService.getResponse();
    }

    /**
     * @param passengerMix the passenger mix
     * @throws Throwable
     */
    public void myBasketContainsAFlightWithPassengerMix(String passengerMix) throws Throwable {
        myBasketContainsAFlightWithPassengerMix(passengerMix, "Digital");
    }

    /**
     * @param passengerMix the passenger mix
     * @param channel      the channel to use to call the service
     * @throws Throwable
     */
    public void myBasketContainsAFlightWithPassengerMix(String passengerMix, String channel) throws Throwable {
        Passengers passengers = new Passengers(passengerMix);
        try {
            FlightQueryParams flightQueryParams =
                    FlightQueryParamsFactory.generateFlightSearchCriteria(flightFinder.findAValidFlight(passengers.getTotalNumberOfPassengers()), passengers);
            FlightsService flightService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), flightQueryParams));
            flightService.invoke();
            outboundFlight = flightService.getOutboundFlight();
            AddFlight aFlight = addFlightRequestBodyFactory.buildFlightRequest(outboundFlight);
            fareType = aFlight.getFareType();
            addedFlight = aFlight;
            addFlightToBasketAsChannel(aFlight, channel);
        } catch (Exception e) {
            LOG.error("Error getting a valid flight", e);
            throw e;
        }

    }

    /**
     * @param flight the flight to add to the basket
     */
    public void addAFlightToMyBasket(Flight flight) {
        addFlightToBasket(addFlightRequestBodyFactory.buildFlightRequest(flight));
    }

    /**
     * @param channel the channel to use
     * @throws Throwable
     */
    public void addFlightToBasketAsChannel(String channel) throws Throwable {
        addFlightToBasketAsChannel(1, 1, channel);
    }

    private void addFlightToBasket(AddFlight addFlight, String channel) {
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), addFlight);
    }

    private void addFlightToBasket(AddFlight addFlight) {
        addFlightToBasket(addFlight, "Digital");
    }

    private void addFlightToBasket(ExampleHeaders headers, AddFlight addFlight) {
        BasketAddFlightPathParams pathParams = new BasketAddFlightPathParams();
        basketService = serviceFactory.get(new BasketRequest(headers, HttpMethod.POST, pathParams, addFlight));
        basketService.invoke();
    }

    public void addTripTypeWithPasengersViaChannelToBasket(int numberOfFlights, int numberOfPassengers, String channel) throws Throwable {
        addFlightToBasketAsChannel(numberOfFlights, numberOfPassengers, channel);
    }

    public void addReturnFlightToBasketAsChannel(int numberOfPassengers, String channel) throws Throwable {

        ExampleFlightDbModel availableFlight = flightFinder.findAValidReturnFlight(numberOfPassengers);

        FlightQueryParams params = FlightQueryParamsFactory.generateReturnFlightSearchCriteria(availableFlight).adult(String.valueOf(numberOfPassengers)).flexibleDays("7").build();
        flightsService = serviceFactory.get(new FlightsRequest(ExampleHeaders.getValid(channel).build(), params));
        flightsService.invoke();
        //add Outbound flight to basket
        AddFlight outboundFlight = addFlightRequestBodyFactory.buildFlightRequest(flightsService.getResponse().getOutbound().getResult().getJourneys().get(0).getFlights().get(0), numberOfPassengers, "OUTBOUND");
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), outboundFlight);
        //Add Inbound flight to basket
        AddFlight inboundFlight = addFlightRequestBodyFactory.buildFlightRequest(flightsService.getResponse().getInbound().getResult().getJourneys().get(0).getFlights().get(0), numberOfPassengers, "INBOUND");
        addFlightToBasket(ExampleHeaders.getValid(channel).build(), inboundFlight);
    }
}
