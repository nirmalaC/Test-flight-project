package com.api.example.fixture.invoke.response.currencies;

import com.fasterxml.jackson.annotation.*;
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
        "currencies",
        "additionalInformations"
})
public class CurrenciesResponse implements IResponse {

    @JsonProperty("currencies")
    private List<Currency> currencies = new ArrayList<Currency>();
    @JsonProperty("additionalInformations")
    private List<AdditionalInformation> additionalInformations = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The currencies
     */
    @JsonProperty("currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies The currencies
     */
    @JsonProperty("currencies")
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    /**
     * @return The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public List<AdditionalInformation> getAdditionalInformations() {
        return additionalInformations;
    }

    /**
     * @param additionalInformations The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public void setAdditionalInformations(List<AdditionalInformation> additionalInformations) {
        this.additionalInformations = additionalInformations;
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
