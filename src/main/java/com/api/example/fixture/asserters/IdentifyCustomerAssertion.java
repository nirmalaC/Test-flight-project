package com.api.example.fixture.asserters;

import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.invoke.response.customer.identify.IdentifyCustomerResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by dwebb on 12/5/2016.
 * assertion wrapper for identify customer response object, provides reusable assertions to all tests
 */
public class IdentifyCustomerAssertion implements IAssertion {

    private final IdentifyCustomerResponse identifyCustomerResponse;

    public IdentifyCustomerAssertion(IdentifyCustomerResponse identifyCustomerResponse) {
        this.identifyCustomerResponse = identifyCustomerResponse;
    }

    public IdentifyCustomerAssertion thatCorrectCustomerDetailsWereReturned(CustomerModel customer) {
        assertThat(identifyCustomerResponse.getCustomers())
                .extracting("customerId")
                .contains(customer.getUid())
                .size().isEqualTo(1);
        return this;
    }

    public IdentifyCustomerAssertion theListIsSortedByLastNameByDefault() {
        return thenDataReturnedIsSortedBy("lastName");
    }

    public IdentifyCustomerAssertion thenDataReturnedIsSortedBy(String sortField) {
        assertThat(identifyCustomerResponse.getCustomers()).extracting(sortField).isSorted();
        return this;
    }

    public IdentifyCustomerAssertion thatVerifyTheReponseMessage(String strMessage) {
        assertThat(identifyCustomerResponse.getAdditionalProperties().toString().contains(strMessage));
        return this;
    }
}
