package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "isDirect",
        "totalDuration",
        "stops",
        "journeyTotalWithCreditCard",
        "journeyTotalWithDebitCard",
        "flights"
})
public class Inbound {

    @JsonProperty("isDirect")
    private Boolean isDirect;
    @JsonProperty("totalDuration")
    private String totalDuration;
    @JsonProperty("stops")
    private Integer stops;
    @JsonProperty("journeyTotalWithCreditCard")
    private String journeyTotalWithCreditCard;
    @JsonProperty("journeyTotalWithDebitCard")
    private String journeyTotalWithDebitCard;
    @JsonProperty("flights")
    private List<Flight> flights = new ArrayList<Flight>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The isDirect
     */
    @JsonProperty("isDirect")
    public Boolean getIsDirect() {
        return isDirect;
    }

    /**
     * @param isDirect The isDirect
     */
    @JsonProperty("isDirect")
    public void setIsDirect(Boolean isDirect) {
        this.isDirect = isDirect;
    }

    /**
     * @return The totalDuration
     */
    @JsonProperty("totalDuration")
    public String getTotalDuration() {
        return totalDuration;
    }

    /**
     * @param totalDuration The totalDuration
     */
    @JsonProperty("totalDuration")
    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    /**
     * @return The stops
     */
    @JsonProperty("stops")
    public Integer getStops() {
        return stops;
    }

    /**
     * @param stops The stops
     */
    @JsonProperty("stops")
    public void setStops(Integer stops) {
        this.stops = stops;
    }

    /**
     * @return The journeyTotalWithCreditCard
     */
    @JsonProperty("journeyTotalWithCreditCard")
    public String getJourneyTotalWithCreditCard() {
        return journeyTotalWithCreditCard;
    }

    /**
     * @param journeyTotalWithCreditCard The journeyTotalWithCreditCard
     */
    @JsonProperty("journeyTotalWithCreditCard")
    public void setJourneyTotalWithCreditCard(String journeyTotalWithCreditCard) {
        this.journeyTotalWithCreditCard = journeyTotalWithCreditCard;
    }

    /**
     * @return The journeyTotalWithDebitCard
     */
    @JsonProperty("journeyTotalWithDebitCard")
    public String getJourneyTotalWithDebitCard() {
        return journeyTotalWithDebitCard;
    }

    /**
     * @param journeyTotalWithDebitCard The journeyTotalWithDebitCard
     */
    @JsonProperty("journeyTotalWithDebitCard")
    public void setJourneyTotalWithDebitCard(String journeyTotalWithDebitCard) {
        this.journeyTotalWithDebitCard = journeyTotalWithDebitCard;
    }

    /**
     * @return The flights
     */
    @JsonProperty("flights")
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * @param flights The flights
     */
    @JsonProperty("flights")
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
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
