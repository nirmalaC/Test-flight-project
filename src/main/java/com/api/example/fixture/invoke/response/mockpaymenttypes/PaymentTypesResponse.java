package com.api.example.fixture.invoke.response.mockpaymenttypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import javax.annotation.Generated;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "paymentMethods"
})
public class PaymentTypesResponse implements IResponse {

    @JsonProperty("paymentMethods")
    private PaymentMethods paymentMethods;

    /**
     * @return The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * @param paymentMethods The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

}
