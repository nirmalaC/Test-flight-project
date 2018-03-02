package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "preferredAirports",
        "travellingTo",
        "tripTypes",
        "travellingWhen",
        "travellingWith",
        "travellingSeason",
        "travellingPeriod"
})
public class TravelPreferences {

    @JsonProperty("preferredAirports")
    private List<String> preferredAirports = new ArrayList<String>();
    @JsonProperty("travellingTo")
    private List<String> travellingTo = new ArrayList<String>();
    @JsonProperty("tripTypes")
    private List<String> tripTypes = new ArrayList<String>();
    @JsonProperty("travellingWhen")
    private List<String> travellingWhen = new ArrayList<String>();
    @JsonProperty("travellingWith")
    private List<String> travellingWith = new ArrayList<String>();
    @JsonProperty("travellingSeason")
    private String travellingSeason;
    @JsonProperty("travellingPeriod")
    private TravellingPeriod travellingPeriod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The preferredAirports
     */
    @JsonProperty("preferredAirports")
    public List<String> getPreferredAirports() {
        return preferredAirports;
    }

    /**
     * @param preferredAirports The preferredAirports
     */
    @JsonProperty("preferredAirports")
    public void setPreferredAirports(List<String> preferredAirports) {
        this.preferredAirports = preferredAirports;
    }

    /**
     * @return The travellingTo
     */
    @JsonProperty("travellingTo")
    public List<String> getTravellingTo() {
        return travellingTo;
    }

    /**
     * @param travellingTo The travellingTo
     */
    @JsonProperty("travellingTo")
    public void setTravellingTo(List<String> travellingTo) {
        this.travellingTo = travellingTo;
    }

    /**
     * @return The tripTypes
     */
    @JsonProperty("tripTypes")
    public List<String> getTripTypes() {
        return tripTypes;
    }

    /**
     * @param tripTypes The tripTypes
     */
    @JsonProperty("tripTypes")
    public void setTripTypes(List<String> tripTypes) {
        this.tripTypes = tripTypes;
    }

    /**
     * @return The travellingWhen
     */
    @JsonProperty("travellingWhen")
    public List<String> getTravellingWhen() {
        return travellingWhen;
    }

    /**
     * @param travellingWhen The travellingWhen
     */
    @JsonProperty("travellingWhen")
    public void setTravellingWhen(List<String> travellingWhen) {
        this.travellingWhen = travellingWhen;
    }

    /**
     * @return The travellingWith
     */
    @JsonProperty("travellingWith")
    public List<String> getTravellingWith() {
        return travellingWith;
    }

    /**
     * @param travellingWith The travellingWith
     */
    @JsonProperty("travellingWith")
    public void setTravellingWith(List<String> travellingWith) {
        this.travellingWith = travellingWith;
    }

    /**
     * @return The travellingSeason
     */
    @JsonProperty("travellingSeason")
    public String getTravellingSeason() {
        return travellingSeason;
    }

    /**
     * @param travellingSeason The travellingSeason
     */
    @JsonProperty("travellingSeason")
    public void setTravellingSeason(String travellingSeason) {
        this.travellingSeason = travellingSeason;
    }

    /**
     * @return The travellingPeriod
     */
    @JsonProperty("travellingPeriod")
    public TravellingPeriod getTravellingPeriod() {
        return travellingPeriod;
    }

    /**
     * @param travellingPeriod The travellingPeriod
     */
    @JsonProperty("travellingPeriod")
    public void setTravellingPeriod(TravellingPeriod travellingPeriod) {
        this.travellingPeriod = travellingPeriod;
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
