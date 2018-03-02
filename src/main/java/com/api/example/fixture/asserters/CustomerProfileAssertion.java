package com.api.example.fixture.asserters;

import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.invoke.response.customer.profile.CustomerProfileResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by dwebb on 12/2/2016.
 * assertion wrapper for customer profile response object, provides reusable assertions to all tests
 */
public class CustomerProfileAssertion implements IAssertion {

    private final CustomerProfileResponse profileResponse;

    public CustomerProfileAssertion(CustomerProfileResponse profileResponse) {
        this.profileResponse = profileResponse;
    }

    public CustomerProfileAssertion theProfileContainsBasicData(CustomerModel dbCustomer) {
        assertThat(profileResponse.getCustomer().getBasicProfile().getPersonalDetails().getCustomerId()).matches(dbCustomer.getUid());
        assertThat(profileResponse.getCustomer().getBasicProfile().getPersonalDetails().getEmail().toLowerCase()).matches(dbCustomer.getCustomerid().toLowerCase());
        assertThat(profileResponse.getCustomer().getBasicProfile().getPersonalDetails().getFirstName()).matches(dbCustomer.getFirstname());
        return this;
    }

}
