package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.login.CustomerLoginResponse;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for customer login response object, provides reusable assertions to all tests
 */
public class CustomerLoginAssertion implements IAssertion {

    private final CustomerLoginResponse customerLoginResponse;

    public CustomerLoginAssertion(CustomerLoginResponse customerLoginResponse) {
        this.customerLoginResponse = customerLoginResponse;
    }

    public CustomerLoginAssertion theLoginWasSuccesful()
    {
        assertThat(customerLoginResponse.getAuthenticationConfirmation().getCustomerId()).isNotEmpty();
        assertThat(customerLoginResponse.getAuthenticationConfirmation().getAuthentication()).isNotNull();
        assertThat(customerLoginResponse.getAuthenticationConfirmation().getAuthentication().getTokenType()).isEqualTo("bearer");

        return this;
    }

}
