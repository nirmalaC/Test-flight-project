package com.api.example.fixture.helpers;

import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.invoke.queryparams.IdentifyCustomerQueryParams;
import org.springframework.stereotype.Component;

/**
 * Created by dwebb on 12/5/2016.
 */
@Component
public class IdentifyCustomerHelper {

    public IdentifyCustomerHelper() {
    }

    public IdentifyCustomerQueryParams getParamsFor(String field, CustomerModel customer) {
        switch (field.toLowerCase()) {
            case "firstname":
                return IdentifyCustomerQueryParams.builder().firstname(customer.getFirstname()).build();
            case "lastname":
                return IdentifyCustomerQueryParams.builder().lastname(customer.getLastname()).build();
            case "title":
                return IdentifyCustomerQueryParams.builder().title(customer.getTitle()).build();

        }

        return null;

    }

    public IdentifyCustomerQueryParams queryParamsFromCustomer(CustomerModel customer, String casing) {
        CaseConverter converter = new CaseConverter();

        return IdentifyCustomerQueryParams.builder()
                //TODO: Fix when customer returns valid data via DAO - currently email. title and postcode not working
//                .title(converter.Convert(customer.getTitle(), casing))
                .firstname(converter.Convert(customer.getFirstname(), casing))
                .lastname(converter.Convert(customer.getLastname(), casing))
//                .email(converter.Convert(customer.getEmail(), casing))
//                .postcode(converter.Convert(customer.getPostalcode(), casing))
                .build();
    }

}
