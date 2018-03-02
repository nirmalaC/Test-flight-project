package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "origin",
        "destination",
        "fareType",
        "priceDifference"
})
public class AlternativeSector {

    @JsonProperty("origin")
    private String origin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("priceDifference")
    private Integer priceDifference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The origin
     */
    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin The origin
     */
    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return The destination
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination The destination
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return The fareType
     */
    @JsonProperty("fareType")
    public String getFareType() {
        return fareType;
    }

    /**
     * @param fareType The fareType
     */
    @JsonProperty("fareType")
    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    /**
     * @return The priceDifference
     */
    @JsonProperty("priceDifference")
    public Integer getPriceDifference() {
        return priceDifference;
    }

    /**
     * @param priceDifference The priceDifference
     */
    @JsonProperty("priceDifference")
    public void setPriceDifference(Integer priceDifference) {
        this.priceDifference = priceDifference;
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
