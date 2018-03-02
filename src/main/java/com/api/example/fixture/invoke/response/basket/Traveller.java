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
        "code",
        "TOEICode",
        "travellerType",
        "passengerDetails",
        "infantsOnLap",
        "infantsOnSeat",
        "age",
        "lead",
        "fareProduct",
        "fareType",
        "allocatedFareClass",
        "holdItems",
        "cabinItems",
        "additionalItems",
        "seat",
        "additionalSeats",
        "passengerAPIS",
        "specialRequests",
        "travellerTotalWithCreditCard",
        "travellerTotalWithDebitCard"
})
public class Traveller {

    @JsonProperty("code")
    private String code;
    @JsonProperty("TOEICode")
    private String tOEICode;
    @JsonProperty("travellerType")
    private String travellerType;
    @JsonProperty("passengerDetails")
    private PassengerDetails passengerDetails;
    @JsonProperty("infantsOnLap")
    private List<Object> infantsOnLap = new ArrayList<Object>();
    @JsonProperty("infantsOnSeat")
    private List<Object> infantsOnSeat = new ArrayList<Object>();
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("lead")
    private Boolean lead;
    @JsonProperty("fareProduct")
    private FareProduct fareProduct;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("allocatedFareClass")
    private String allocatedFareClass;
    @JsonProperty("holdItems")
    private List<HoldItem> holdItems = new ArrayList<HoldItem>();
    @JsonProperty("cabinItems")
    private List<CabinItem> cabinItems = new ArrayList<CabinItem>();
    @JsonProperty("additionalItems")
    private List<AdditionalItem> additionalItems = new ArrayList<AdditionalItem>();
    @JsonProperty("seat")
    private Seat seat;
    @JsonProperty("additionalSeats")
    private List<Object> additionalSeats = new ArrayList<Object>();
    @JsonProperty("passengerAPIS")
    private PassengerAPIS passengerAPIS;
    @JsonProperty("specialRequests")
    private List<SpecialRequest> specialRequests = new ArrayList<SpecialRequest>();
    @JsonProperty("travellerTotalWithCreditCard")
    private Double travellerTotalWithCreditCard;
    @JsonProperty("travellerTotalWithDebitCard")
    private Double travellerTotalWithDebitCard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The tOEICode
     */
    @JsonProperty("TOEICode")
    public String getTOEICode() {
        return tOEICode;
    }

    /**
     * @param tOEICode The TOEICode
     */
    @JsonProperty("TOEICode")
    public void setTOEICode(String tOEICode) {
        this.tOEICode = tOEICode;
    }

    /**
     * @return The travellerType
     */
    @JsonProperty("travellerType")
    public String getTravellerType() {
        return travellerType;
    }

    /**
     * @param travellerType The travellerType
     */
    @JsonProperty("travellerType")
    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    /**
     * @return The passengerDetails
     */
    @JsonProperty("passengerDetails")
    public PassengerDetails getPassengerDetails() {
        return passengerDetails;
    }

    /**
     * @param passengerDetails The passengerDetails
     */
    @JsonProperty("passengerDetails")
    public void setPassengerDetails(PassengerDetails passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    /**
     * @return The infantsOnLap
     */
    @JsonProperty("infantsOnLap")
    public List<Object> getInfantsOnLap() {
        return infantsOnLap;
    }

    /**
     * @param infantsOnLap The infantsOnLap
     */
    @JsonProperty("infantsOnLap")
    public void setInfantsOnLap(List<Object> infantsOnLap) {
        this.infantsOnLap = infantsOnLap;
    }

    /**
     * @return The infantsOnSeat
     */
    @JsonProperty("infantsOnSeat")
    public List<Object> getInfantsOnSeat() {
        return infantsOnSeat;
    }

    /**
     * @param infantsOnSeat The infantsOnSeat
     */
    @JsonProperty("infantsOnSeat")
    public void setInfantsOnSeat(List<Object> infantsOnSeat) {
        this.infantsOnSeat = infantsOnSeat;
    }

    /**
     * @return The age
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * @param age The age
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return The lead
     */
    @JsonProperty("lead")
    public Boolean getLead() {
        return lead;
    }

    /**
     * @param lead The lead
     */
    @JsonProperty("lead")
    public void setLead(Boolean lead) {
        this.lead = lead;
    }

    /**
     * @return The fareProduct
     */
    @JsonProperty("fareProduct")
    public FareProduct getFareProduct() {
        return fareProduct;
    }

    /**
     * @param fareProduct The fareProduct
     */
    @JsonProperty("fareProduct")
    public void setFareProduct(FareProduct fareProduct) {
        this.fareProduct = fareProduct;
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
     * @return The allocatedFareClass
     */
    @JsonProperty("allocatedFareClass")
    public String getAllocatedFareClass() {
        return allocatedFareClass;
    }

    /**
     * @param allocatedFareClass The allocatedFareClass
     */
    @JsonProperty("allocatedFareClass")
    public void setAllocatedFareClass(String allocatedFareClass) {
        this.allocatedFareClass = allocatedFareClass;
    }

    /**
     * @return The holdItems
     */
    @JsonProperty("holdItems")
    public List<HoldItem> getHoldItems() {
        return holdItems;
    }

    /**
     * @param holdItems The holdItems
     */
    @JsonProperty("holdItems")
    public void setHoldItems(List<HoldItem> holdItems) {
        this.holdItems = holdItems;
    }

    /**
     * @return The cabinItems
     */
    @JsonProperty("cabinItems")
    public List<CabinItem> getCabinItems() {
        return cabinItems;
    }

    /**
     * @param cabinItems The cabinItems
     */
    @JsonProperty("cabinItems")
    public void setCabinItems(List<CabinItem> cabinItems) {
        this.cabinItems = cabinItems;
    }

    /**
     * @return The additionalItems
     */
    @JsonProperty("additionalItems")
    public List<AdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    /**
     * @param additionalItems The additionalItems
     */
    @JsonProperty("additionalItems")
    public void setAdditionalItems(List<AdditionalItem> additionalItems) {
        this.additionalItems = additionalItems;
    }

    /**
     * @return The seat
     */
    @JsonProperty("seat")
    public Seat getSeat() {
        return seat;
    }

    /**
     * @param seat The seat
     */
    @JsonProperty("seat")
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * @return The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public List<Object> getAdditionalSeats() {
        return additionalSeats;
    }

    /**
     * @param additionalSeats The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public void setAdditionalSeats(List<Object> additionalSeats) {
        this.additionalSeats = additionalSeats;
    }

    /**
     * @return The passengerAPIS
     */
    @JsonProperty("passengerAPIS")
    public PassengerAPIS getPassengerAPIS() {
        return passengerAPIS;
    }

    /**
     * @param passengerAPIS The passengerAPIS
     */
    @JsonProperty("passengerAPIS")
    public void setPassengerAPIS(PassengerAPIS passengerAPIS) {
        this.passengerAPIS = passengerAPIS;
    }

    /**
     * @return The specialRequests
     */
    @JsonProperty("specialRequests")
    public List<SpecialRequest> getSpecialRequests() {
        return specialRequests;
    }

    /**
     * @param specialRequests The specialRequests
     */
    @JsonProperty("specialRequests")
    public void setSpecialRequests(List<SpecialRequest> specialRequests) {
        this.specialRequests = specialRequests;
    }

    /**
     * @return The travellerTotalWithCreditCard
     */
    @JsonProperty("travellerTotalWithCreditCard")
    public Double getTravellerTotalWithCreditCard() {
        return travellerTotalWithCreditCard;
    }

    /**
     * @param travellerTotalWithCreditCard The travellerTotalWithCreditCard
     */
    @JsonProperty("travellerTotalWithCreditCard")
    public void setTravellerTotalWithCreditCard(Double travellerTotalWithCreditCard) {
        this.travellerTotalWithCreditCard = travellerTotalWithCreditCard;
    }

    /**
     * @return The travellerTotalWithDebitCard
     */
    @JsonProperty("travellerTotalWithDebitCard")
    public Double getTravellerTotalWithDebitCard() {
        return travellerTotalWithDebitCard;
    }

    /**
     * @param travellerTotalWithDebitCard The travellerTotalWithDebitCard
     */
    @JsonProperty("travellerTotalWithDebitCard")
    public void setTravellerTotalWithDebitCard(Double travellerTotalWithDebitCard) {
        this.travellerTotalWithDebitCard = travellerTotalWithDebitCard;
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
