package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "withCreditCardFee",
        "withDebitCardFee"
})
public class TotalFare {

    @JsonProperty("withCreditCardFee")
    private Double withCreditCardFee;
    @JsonProperty("withDebitCardFee")
    private Double withDebitCardFee;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The withCreditCardFee
     */
    @JsonProperty("withCreditCardFee")
    public Double getWithCreditCardFee() {
        return withCreditCardFee;
    }

    /**
     * @param withCreditCardFee The withCreditCardFee
     */
    @JsonProperty("withCreditCardFee")
    public void setWithCreditCardFee(Double withCreditCardFee) {
        this.withCreditCardFee = withCreditCardFee;
    }

    /**
     * @return The withDebitCardFee
     */
    @JsonProperty("withDebitCardFee")
    public Double getWithDebitCardFee() {
        return withDebitCardFee;
    }

    /**
     * @param withDebitCardFee The withDebitCardFee
     */
    @JsonProperty("withDebitCardFee")
    public void setWithDebitCardFee(Double withDebitCardFee) {
        this.withDebitCardFee = withDebitCardFee;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
