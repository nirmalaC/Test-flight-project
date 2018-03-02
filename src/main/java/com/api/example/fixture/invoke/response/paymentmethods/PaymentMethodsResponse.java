package com.api.example.fixture.invoke.response.paymentmethods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.response.IResponse;
import com.api.example.fixture.invoke.response.common.AdditionalInformation;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "additionalInformation",
        "paymentMethods"
})
//@Builder
public class PaymentMethodsResponse implements IResponse {

    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = new ArrayList<AdditionalInformation>();
    @JsonProperty("paymentMethods")
    private List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * @param paymentMethods The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    /**
     * @return The additionalInformation
     */
    @JsonProperty("additionalInformation")
    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation The additionalInformation
     */
    @JsonProperty("additionalInformation")
    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

}
