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
        "currency"
})
public class AllowedCurrencies {

    @JsonProperty("currency")
    private List<Currency> currency = new ArrayList<Currency>();

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public List<Currency> getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

}
