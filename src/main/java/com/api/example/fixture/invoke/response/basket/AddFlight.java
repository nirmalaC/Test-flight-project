package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "flightKey",
        "TOEICode",
        "overrideWarning",
        "price",
        "currency",
        "routeCode",
        "fareType",
        "journeyType",
        "passengers"
})
@Builder(builderClassName = "AddFlightBuilder", buildMethodName = "execute", builderMethodName = "build", toBuilder = true)
public class AddFlight implements IRequestBody {

    @JsonProperty("flightKey")
    private String flightKey;
    @JsonProperty("TOEICode")
    private String toeiCode;
    @JsonProperty("overrideWarning")
    private Boolean overrideWarning;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("routeCode")
    private String routeCode;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("journeyType")
    private String journeyType;
    @JsonProperty("passengers")
    private List<Passenger> passengers = new ArrayList<Passenger>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The flightKey
     */
    @JsonProperty("flightKey")
    public String getFlightKey() {
        return flightKey;
    }

    /**
     * @param flightKey The flightKey
     */
    @JsonProperty("flightKey")
    public void setFlightKey(String flightKey) {
        this.flightKey = flightKey;
    }

    /**
     * @return The toeiCode
     */
    @JsonProperty("TOEICode")
    public String getToeiCode() {
        return toeiCode;
    }

    /**
     * @param flightKey The TOEICode
     */
    @JsonProperty("TOEICode")
    public void setToeiCode(String toeiCode) {
        this.toeiCode = toeiCode;
    }

    /**
     * @return The overrideWarning
     */
    @JsonProperty("overrideWarning")
    public Boolean getOverrideWarning() {
        return overrideWarning;
    }

    /**
     * @param overrideWarning The overrideWarning
     */
    @JsonProperty("overrideWarning")
    public void setOverrideWarning(Boolean overrideWarning) {
        this.overrideWarning = overrideWarning;
    }

    /**
     * @return The price
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The routeCode
     */
    @JsonProperty("routeCode")
    public String getRouteCode() {
        return routeCode;
    }

    /**
     * @param routeCode The routeCode
     */
    @JsonProperty("routeCode")
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
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
     * @return The journeyType
     */
    @JsonProperty("journeyType")
    public String getJourneyType() {
        return journeyType;
    }

    /**
     * @param journeyType The journeyType
     */
    @JsonProperty("journeyType")
    public void setJourneyType(String journeyType) {
        this.journeyType = journeyType;
    }

    /**
     * @return The passengers
     */
    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * @param passengers The passengers
     */
    @JsonProperty("passengers")
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
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
