package com.api.example.fixture.invoke.response.passengertypes;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "maxPassengersPerBooking",
        "adultInfantOnLapRatio"
})
public class PassengerRules {

    @JsonProperty("maxPassengersPerBooking")
    private Integer maxPassengersPerBooking;
    @JsonProperty("adultInfantOnLapRatio")
    private String adultInfantOnLapRatio;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The maxPassengersPerBooking
     */
    @JsonProperty("maxPassengersPerBooking")
    public Integer getMaxPassengersPerBooking() {
        return maxPassengersPerBooking;
    }

    /**
     * @param maxPassengersPerBooking The maxPassengersPerBooking
     */
    @JsonProperty("maxPassengersPerBooking")
    public void setMaxPassengersPerBooking(Integer maxPassengersPerBooking) {
        this.maxPassengersPerBooking = maxPassengersPerBooking;
    }

    /**
     * @return The adultInfantOnLapRatio
     */
    @JsonProperty("adultInfantOnLapRatio")
    public String getAdultInfantOnLapRatio() {
        return adultInfantOnLapRatio;
    }

    /**
     * @param adultInfantOnLapRatio The adultInfantOnLapRatio
     */
    @JsonProperty("adultInfantOnLapRatio")
    public void setAdultInfantOnLapRatio(String adultInfantOnLapRatio) {
        this.adultInfantOnLapRatio = adultInfantOnLapRatio;
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
