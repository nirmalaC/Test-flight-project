package com.api.example.fixture.invoke.response.mockpaymenttypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "paymentType"
})
public class PaymentMethods {

    @JsonProperty("paymentType")
    private List<PaymentType> paymentType = new ArrayList<PaymentType>();

    /**
     * @return The paymentType
     */
    @JsonProperty("paymentType")
    public List<PaymentType> getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType The paymentType
     */
    @JsonProperty("paymentType")
    public void setPaymentType(List<PaymentType> paymentType) {
        this.paymentType = paymentType;
    }

}
