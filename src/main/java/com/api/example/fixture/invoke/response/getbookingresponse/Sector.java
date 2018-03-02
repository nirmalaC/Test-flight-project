
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "departure",
    "arrival",
    "apisRequired",
    "nifNumberRequired",
    "checkInWindow"
})
public class Sector {

    @JsonProperty("code")
    private String code;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonProperty("apisRequired")
    private Boolean apisRequired;
    @JsonProperty("nifNumberRequired")
    private Boolean nifNumberRequired;
    @JsonProperty("checkInWindow")
    private CheckInWindow checkInWindow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }

    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("apisRequired")
    public Boolean getApisRequired() {
        return apisRequired;
    }

    @JsonProperty("apisRequired")
    public void setApisRequired(Boolean apisRequired) {
        this.apisRequired = apisRequired;
    }

    @JsonProperty("nifNumberRequired")
    public Boolean getNifNumberRequired() {
        return nifNumberRequired;
    }

    @JsonProperty("nifNumberRequired")
    public void setNifNumberRequired(Boolean nifNumberRequired) {
        this.nifNumberRequired = nifNumberRequired;
    }

    @JsonProperty("checkInWindow")
    public CheckInWindow getCheckInWindow() {
        return checkInWindow;
    }

    @JsonProperty("checkInWindow")
    public void setCheckInWindow(CheckInWindow checkInWindow) {
        this.checkInWindow = checkInWindow;
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
