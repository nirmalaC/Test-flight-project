package com.api.example.fixture.invoke.response.countries;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
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
        "countries"
})
public class CountriesResponse implements IResponse {

    @JsonProperty("countries")
    private List<Country> countries = new ArrayList<Country>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The countries
     */
    @JsonProperty("countries")
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * @param countries The countries
     */
    @JsonProperty("countries")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
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
