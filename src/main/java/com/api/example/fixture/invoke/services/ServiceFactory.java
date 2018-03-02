package com.api.example.fixture.invoke.services;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.invoke.requests.*;
import com.api.example.fixture.invoke.requests.booking.CommitBookingRequest;
import com.api.example.fixture.invoke.requests.booking.FindBookingRequest;
import com.api.example.fixture.invoke.requests.booking.GetBookingRequest;
import com.api.example.fixture.invoke.requests.refdata.*;
import com.api.example.fixture.invoke.services.booking.CommitBookingService;
import com.api.example.fixture.invoke.services.booking.FindBookingService;
import com.api.example.fixture.invoke.services.booking.GetBookingService;
import com.api.example.fixture.invoke.services.refdata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;

/**
 * Created by daniel on 02/12/2016.
 * this factory class is under spring control and therefore allows autowiring of configuration and jersey client in the
 * instantiation of new 'service' objects, calling get with a specific type of request as the argument will return the correct
 * service object, ready to be controlled, modified, invoked and queried
 */
@Component
public class ServiceFactory {

    private final Client client;
    private final ExampleTestConfig config;

    /**
     * @param client autowired jersey client
     * @param config autowired configuration
     */
    @Autowired
    public ServiceFactory(Client client, ExampleTestConfig config) {
        this.client = client;
        this.config = config;
    }

    public BasketService get(BasketRequest basketRequest) {
        return new BasketService(config, client, basketRequest);
    }

    public BasketTravellerService get(BasketTravellerRequest basketTravellerRequest) {
        return new BasketTravellerService(config, client, basketTravellerRequest);
    }

    public FlightsService get(FlightsRequest flightsRequest) {
        return new FlightsService(config, client, flightsRequest);
    }

    public CustomerProfileService get(ProfileRequest profileRequest) {
        return new CustomerProfileService(config, client, profileRequest);
    }

    public IdentifyCustomerService get(IdentifyCustomerRequest identifyCustomerRequest) {
        return new IdentifyCustomerService(config, client, identifyCustomerRequest);
    }

    public PaymentMethodsService get(PaymentMethodsRequest paymentMethodsRequest) {
        return new PaymentMethodsService(config, client, paymentMethodsRequest);
    }

    public CommitBookingService get(CommitBookingRequest commitBookingRequest) {
        return new CommitBookingService(config, client, commitBookingRequest);
    }

    public GetBookingService get(GetBookingRequest getBookingRequest) {
        return new GetBookingService(config, client, getBookingRequest);
    }

    public FindBookingService get(FindBookingRequest findBookingRequest) {
        return new FindBookingService(config, client, findBookingRequest);
    }

    public AirportsService get(AirportsRequest airportsRequest) {
        return new AirportsService(config, client, airportsRequest);
    }

    public CountriesService get(CountriesRequest countriesRequest) {
        return new CountriesService(config, client, countriesRequest);
    }

    public CurrenciesService get(CurrenciesRequest currenciesRequest) {
        return new CurrenciesService(config, client, currenciesRequest);
    }

    public LanguagesService get(LanguagesRequest languagesRequest) {
        return new LanguagesService(config, client, languagesRequest);
    }

    public MarketGroupsService get(MarketGroupsRequest marketGroupsRequest) {
        return new MarketGroupsService(config, client, marketGroupsRequest);
    }

    public PassengerTypesService get(PassengerTypesRequest passengerTypesRequest) {
        return new PassengerTypesService(config, client, passengerTypesRequest);
    }

    public PassengerTitlesService get(PassengerTitlesRequest passengerTitlesRequest) {
        return new PassengerTitlesService(config, client, passengerTitlesRequest);
    }

    public RegisterCustomerService get(RegisterNewCustomerRequest registerNewCustomerRequest) {
        return new RegisterCustomerService(config, client, registerNewCustomerRequest);
    }

    public LoginDetailsService get(LoginRequest loginRequest)
    {
        return new LoginDetailsService(config, client, loginRequest);
    }
}
