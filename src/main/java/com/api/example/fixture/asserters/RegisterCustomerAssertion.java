package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.requestbody.registercustomer.RegisterCustomerRequest;
import com.api.example.fixture.invoke.response.registerCustomerResponse.RegisterCustomerResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by dwebb on 12/15/2016.
 * assertion wrapper for register customer response object, provides reusable assertions to all tests
 */
public class RegisterCustomerAssertion implements IAssertion {

    private final RegisterCustomerResponse registerCustomerResponse;

    public RegisterCustomerAssertion(RegisterCustomerResponse registerCustomerResponse) {
        this.registerCustomerResponse = registerCustomerResponse;
    }

    public RegisterCustomerAssertion theProfileResponseIsValid()
    {
        assertThat(registerCustomerResponse.getRegistrationConfirmation()).isNotNull();
        return this;
    }

    public RegisterCustomerAssertion theCustomerProfileWasCreated(RegisterCustomerRequest request) {

        assertThat(registerCustomerResponse.getRegistrationConfirmation()).isNotNull();
        assertThat(registerCustomerResponse.getRegistrationConfirmation().getCustomerId()).isNotEmpty();
        assertThat(registerCustomerResponse.getAdditionalInformation().get(0).getMessage()).isEqualTo("Customer successfully registered");

        return this;
    }

    public RegisterCustomerAssertion theCustomersPasswordStrengthAsExpected (RegisterCustomerRequest request, String expectedStrength){
        assertThat(registerCustomerResponse.getRegistrationConfirmation()).isNotNull();
        assertThat(registerCustomerResponse.getRegistrationConfirmation().getAdditionalProperties()).containsValue(expectedStrength);
        return this;
    }

}
