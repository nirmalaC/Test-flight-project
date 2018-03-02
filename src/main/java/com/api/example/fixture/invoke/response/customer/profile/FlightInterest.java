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
        "flightKey",
        "flightNumber",
        "carrier",
        "departureDateTime",
        "arrivalDateTime",
        "sector",
        "fareTypes"
})
public class FlightInterest {

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
    @JsonProperty("sector")
    private Sector sector;
    @JsonProperty("fareTypes")
    private List<FareType> fareTypes = new ArrayList<FareType>();
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
     * @return The flightNumber
     */
    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @param flightNumber The flightNumber
     */
    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * @return The carrier
     */
    @JsonProperty("carrier")
    public String getCarrier() {
        return carrier;
    }

    /**
     * @param carrier The carrier
     */
    @JsonProperty("carrier")
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * @return The departureDateTime
     */
    @JsonProperty("departureDateTime")
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * @param departureDateTime The departureDateTime
     */
    @JsonProperty("departureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * @return The arrivalDateTime
     */
    @JsonProperty("arrivalDateTime")
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * @param arrivalDateTime The arrivalDateTime
     */
    @JsonProperty("arrivalDateTime")
    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * @return The sector
     */
    @JsonProperty("sector")
    public Sector getSector() {
        return sector;
    }

    /**
     * @param sector The sector
     */
    @JsonProperty("sector")
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * @return The fareTypes
     */
    @JsonProperty("fareTypes")
    public List<FareType> getFareTypes() {
        return fareTypes;
    }

    /**
     * @param fareTypes The fareTypes
     */
    @JsonProperty("fareTypes")
    public void setFareTypes(List<FareType> fareTypes) {
        this.fareTypes = fareTypes;
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
