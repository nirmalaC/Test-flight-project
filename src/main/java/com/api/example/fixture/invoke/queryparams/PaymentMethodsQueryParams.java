package com.api.example.fixture.invoke.queryparams;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dwebb on 11/9/2016.
 */
@Data
@Builder
public class PaymentMethodsQueryParams extends QueryParams implements IQueryParams {

    private String customerId;
    private String basketId;
    private String bookingTypeCode;

    public Map<String, String> getParameters() {
        Map<String, String> queryParams = new HashMap<>();
        if (isPopulated(customerId)) {
            queryParams.put("customer-id", customerId);
        }
        if (isPopulated(basketId)) {
            queryParams.put("basket-id", basketId);
        }
        if (isPopulated(bookingTypeCode)) {
            queryParams.put("booking-type-code", bookingTypeCode);
        }

        return queryParams;
    }


}


