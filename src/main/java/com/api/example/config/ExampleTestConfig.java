package com.api.example.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by daniel on 23/11/2016.
 */
@Component
@Getter
public class ExampleTestConfig {

    private final String exampleLanguagesEndpoint;
    private final String exampleCountriesEndpoint;
    private final String examplePassengerTypesEndpoint;
    private final String exampleCurrenciesEndpoint;
    private final String exampleAirportsEndpoint;
    private final String exampleMarketGroupsEndpoint;
    private final String exampleFlightsEndpoint;
    private final String examplePassengerTitlesEndpoint;
    private final String exampleBookingsEndpoint;
    private final String exampleGetBasketEndpoint;
    private final String exampleCommitBookingEndPoint;
    private final String exampleGetPaymentMethodsEndPoint;
    private final String exampleCustomerLoginEndPoint;
    private final String exampleGetPaymentTypesEndPoint;
    private final String otherDbConnectionUrl;
    private final String otherDbUserName;
    private final String otherDbPassword;
    private final String exampleDbDriver;
    private final String exampleDbConnectionUrl;
    private final String exampleDbUserName;
    private final String exampleDbPassword;
    private final String exampleDbServer;
    private final String exampleDbName;
    private final String exampleCustomers;
    private final String examplePreferences;
    private final int exampleTimeout;

    @Autowired
    public ExampleTestConfig(Environment environment) {
        this.exampleLanguagesEndpoint = environment.getProperty("example.languages");
        this.exampleCountriesEndpoint = environment.getProperty("example.countries");
        this.examplePassengerTypesEndpoint = environment.getProperty("example.passengerTypes");
        this.exampleCurrenciesEndpoint = environment.getProperty("example.currencies");
        this.exampleAirportsEndpoint = environment.getProperty("example.airports");
        this.exampleMarketGroupsEndpoint = environment.getProperty("example.market.groups");
        this.exampleFlightsEndpoint = environment.getProperty("example.flights");
        this.examplePassengerTitlesEndpoint = environment.getProperty("example.passengerTitles");
        this.exampleBookingsEndpoint = environment.getProperty("example.bookings");
        this.exampleGetBasketEndpoint = environment.getProperty("example.getBasket");
        this.exampleCommitBookingEndPoint = environment.getProperty("example.commitBooking");
        this.exampleGetPaymentMethodsEndPoint = environment.getProperty("example.getPaymentMethods");
        this.exampleCustomerLoginEndPoint = environment.getProperty("example.customerLogin");
        this.exampleGetPaymentTypesEndPoint = environment.getProperty("example.getPaymentTypes");
        this.otherDbConnectionUrl = environment.getProperty("otherdb.db.connectionUrl");
        this.otherDbUserName = environment.getProperty("otherdb.user.name");
        this.otherDbPassword = environment.getProperty("otherdb.user.password");
        this.exampleDbDriver = environment.getProperty("example.db.driverName");
        this.exampleDbConnectionUrl = environment.getProperty("example.db.connectionUrl");
        this.exampleDbUserName = environment.getProperty("example.user.name");
        this.exampleDbPassword = environment.getProperty("example.user.password");
        this.exampleDbServer = environment.getProperty("api.db.server");
        this.exampleDbName = environment.getProperty("api.db.name");
        this.exampleCustomers = environment.getProperty("example.customers");
        this.examplePreferences = environment.getProperty("example.preferences");
        this.exampleTimeout = Integer.valueOf(environment.getProperty("example.timeout"));
    }
}