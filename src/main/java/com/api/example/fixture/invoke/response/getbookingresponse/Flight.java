
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flightKey",
    "flightNumber",
    "carrier",
    "departureDateTime",
    "arrivalDateTime",
    "commercialStatus",
    "operationalStatus",
    "disruptionLevel",
    "closed",
    "locked",
    "sector",
    "passengers"
})
public class Flight {

    @JsonProperty("flightKey")
    private String flightKey;
    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("departureDateTime")
    private String departureDateTime;
    @JsonProperty("arrivalDateTime")
    private String arrivalDateTime;
    @JsonProperty("commercialStatus")
    private String commercialStatus;
    @JsonProperty("operationalStatus")
    private String operationalStatus;
    @JsonProperty("disruptionLevel")
    private String disruptionLevel;
    @JsonProperty("closed")
    private Boolean closed;
    @JsonProperty("locked")
    private Boolean locked;
    @JsonProperty("sector")
    private Sector sector;
    @JsonProperty("passengers")
    private List<Passenger> passengers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("flightKey")
    public String getFlightKey() {
        return flightKey;
    }

    @JsonProperty("flightKey")
    public void setFlightKey(String flightKey) {
        this.flightKey = flightKey;
    }

    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("carrier")
    public String getCarrier() {
        return carrier;
    }

    @JsonProperty("carrier")
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @JsonProperty("departureDateTime")
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    @JsonProperty("departureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    @JsonProperty("arrivalDateTime")
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    @JsonProperty("arrivalDateTime")
    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    @JsonProperty("commercialStatus")
    public String getCommercialStatus() {
        return commercialStatus;
    }

    @JsonProperty("commercialStatus")
    public void setCommercialStatus(String commercialStatus) {
        this.commercialStatus = commercialStatus;
    }

    @JsonProperty("operationalStatus")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    @JsonProperty("operationalStatus")
    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    @JsonProperty("disruptionLevel")
    public String getDisruptionLevel() {
        return disruptionLevel;
    }

    @JsonProperty("disruptionLevel")
    public void setDisruptionLevel(String disruptionLevel) {
        this.disruptionLevel = disruptionLevel;
    }

    @JsonProperty("closed")
    public Boolean getClosed() {
        return closed;
    }

    @JsonProperty("closed")
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @JsonProperty("locked")
    public Boolean getLocked() {
        return locked;
    }

    @JsonProperty("locked")
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @JsonProperty("sector")
    public Sector getSector() {
        return sector;
    }

    @JsonProperty("sector")
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

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
