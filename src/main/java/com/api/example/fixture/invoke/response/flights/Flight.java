package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "carrier",
        "flightNumber",
        "flightKey",
        "duration",
        "availableStatus",
        "operationalStatus",
        "isApisRequired",
        "isWrappedFare",
        "isSpeedyBoardingAllowed",
        "equipment",
        "departure",
        "arrival",
        "inventory",
        "fareTypes"
})
@ToString
@Builder(builderClassName = "FlightBuilder", buildMethodName = "execute", builderMethodName = "build", toBuilder = true)
public class Flight {

    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("flightNumber")
    private Integer flightNumber;
    @JsonProperty("flightKey")
    private String flightKey;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("availableStatus")
    private String availableStatus;
    @JsonProperty("operationalStatus")
    private String operationalStatus;
    @JsonProperty("isApisRequired")
    private Boolean isApisRequired;
    @JsonProperty("isWrappedFare")
    private Boolean isWrappedFare;
    @JsonProperty("isSpeedyBoardingAllowed")
    private Boolean isSpeedyBoardingAllowed;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonProperty("inventory")
    private Inventory inventory;
    @JsonProperty("fareTypes")
    private List<FareType> fareTypes = new ArrayList<FareType>();
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Flight() {
    }

    /**
     * @param isWrappedFare
     * @param departure
     * @param flightNumber
     * @param flightKey
     * @param availableStatus
     * @param isSpeedyBoardingAllowed
     * @param fareTypes
     * @param duration
     * @param inventory
     * @param isApisRequired
     * @param carrier
     * @param arrival
     * @param operationalStatus
     */
    public Flight(String carrier, Integer flightNumber, String flightKey, String duration, String availableStatus, String operationalStatus, Boolean isApisRequired, Boolean isWrappedFare, Boolean isSpeedyBoardingAllowed, Departure departure, Arrival arrival, Inventory inventory, List<FareType> fareTypes) {
        this.carrier = carrier;
        this.flightNumber = flightNumber;
        this.flightKey = flightKey;
        this.duration = duration;
        this.availableStatus = availableStatus;
        this.operationalStatus = operationalStatus;
        this.isApisRequired = isApisRequired;
        this.isWrappedFare = isWrappedFare;
        this.isSpeedyBoardingAllowed = isSpeedyBoardingAllowed;
        this.departure = departure;
        this.arrival = arrival;
        this.inventory = inventory;
        this.fareTypes = fareTypes;
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
     * @return The flightNumber
     */
    @JsonProperty("flightNumber")
    public Integer getFlightNumber() {
        return flightNumber;
    }

    /**
     * @param flightNumber The flightNumber
     */
    @JsonProperty("flightNumber")
    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

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
     * @return The duration
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return The availableStatus
     */
    @JsonProperty("availableStatus")
    public String getAvailableStatus() {
        return availableStatus;
    }

    /**
     * @param availableStatus The availableStatus
     */
    @JsonProperty("availableStatus")
    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    /**
     * @return The operationalStatus
     */
    @JsonProperty("operationalStatus")
    public String getOperationalStatus() {
        return operationalStatus;
    }

    /**
     * @param operationalStatus The operationalStatus
     */
    @JsonProperty("operationalStatus")
    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    /**
     * @return The isApisRequired
     */
    @JsonProperty("isApisRequired")
    public Boolean getIsApisRequired() {
        return isApisRequired;
    }

    /**
     * @param isApisRequired The isApisRequired
     */
    @JsonProperty("isApisRequired")
    public void setIsApisRequired(Boolean isApisRequired) {
        this.isApisRequired = isApisRequired;
    }

    /**
     * @return The isWrappedFare
     */
    @JsonProperty("isWrappedFare")
    public Boolean getIsWrappedFare() {
        return isWrappedFare;
    }

    /**
     * @param isWrappedFare The isWrappedFare
     */
    @JsonProperty("isWrappedFare")
    public void setIsWrappedFare(Boolean isWrappedFare) {
        this.isWrappedFare = isWrappedFare;
    }

    /**
     * @return The isSpeedyBoardingAllowed
     */
    @JsonProperty("isSpeedyBoardingAllowed")
    public Boolean getIsSpeedyBoardingAllowed() {
        return isSpeedyBoardingAllowed;
    }

    /**
     * @param isSpeedyBoardingAllowed The isSpeedyBoardingAllowed
     */
    @JsonProperty("isSpeedyBoardingAllowed")
    public void setIsSpeedyBoardingAllowed(Boolean isSpeedyBoardingAllowed) {
        this.isSpeedyBoardingAllowed = isSpeedyBoardingAllowed;
    }

//    /**
//     * @return The equipment
//     */
//    @JsonProperty("equipment")
//    public String getEquipment() {
//        return equipment;
//    }
//
//    /**
//     * @param equipment The equipment
//     */
//    @JsonProperty("equipment")
//    public void setEquipment(String equipment) {
//        this.equipment = equipment;
//    }

    /**
     * @return The departure
     */
    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    /**
     * @param departure The departure
     */
    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    /**
     * @return The arrival
     */
    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }

    /**
     * @param arrival The arrival
     */
    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    /**
     * @return The inventory
     */
    @JsonProperty("inventory")
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @param inventory The inventory
     */
    @JsonProperty("inventory")
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
