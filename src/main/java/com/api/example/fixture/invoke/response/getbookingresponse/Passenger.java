
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
    "code",
    "toeiCode",
    "travellerType",
    "passengerDetails",
    "passengerStatus",
    "ICTSStatus",
    "infantsOnLap",
    "infantsOnSeat",
    "age",
    "lead",
    "fareType",
    "allocatedFareClass",
    "passengerMap",
    "fareProduct",
    "holdItems",
    "cabinItems",
    "additionalItems",
    "seat",
    "additionalSeats",
    "passengerAPIS",
    "specialRequests",
    "totalAmount"
})
public class Passenger {

    @JsonProperty("code")
    private String code;
    @JsonProperty("toeiCode")
    private String toeiCode;
    @JsonProperty("travellerType")
    private String travellerType;
    @JsonProperty("passengerDetails")
    private PassengerDetails passengerDetails;
    @JsonProperty("passengerStatus")
    private String passengerStatus;
    @JsonProperty("ICTSStatus")
    private String iCTSStatus;
    @JsonProperty("infantsOnLap")
    private List<String> infantsOnLap = null;
    @JsonProperty("infantsOnSeat")
    private List<String> infantsOnSeat = null;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("lead")
    private Boolean lead;
    @JsonProperty("fareType")
    private String fareType;
    @JsonProperty("allocatedFareClass")
    private String allocatedFareClass;
    @JsonProperty("passengerMap")
    private List<String> passengerMap = null;
    @JsonProperty("fareProduct")
    private FareProduct fareProduct;
    @JsonProperty("holdItems")
    private List<HoldItem> holdItems = null;
    @JsonProperty("cabinItems")
    private List<CabinItem> cabinItems = null;
    @JsonProperty("additionalItems")
    private List<AdditionalItem> additionalItems = null;
    @JsonProperty("seat")
    private Seat seat;
    @JsonProperty("additionalSeats")
    private List<AdditionalSeat> additionalSeats = null;
    @JsonProperty("passengerAPIS")
    private PassengerAPIS passengerAPIS;
    @JsonProperty("specialRequests")
    private List<SpecialRequest> specialRequests = null;
    @JsonProperty("totalAmount")
    private String totalAmount;
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

    @JsonProperty("toeiCode")
    public String getToeiCode() {
        return toeiCode;
    }

    @JsonProperty("toeiCode")
    public void setToeiCode(String toeiCode) {
        this.toeiCode = toeiCode;
    }

    @JsonProperty("travellerType")
    public String getTravellerType() {
        return travellerType;
    }

    @JsonProperty("travellerType")
    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    @JsonProperty("passengerDetails")
    public PassengerDetails getPassengerDetails() {
        return passengerDetails;
    }

    @JsonProperty("passengerDetails")
    public void setPassengerDetails(PassengerDetails passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    @JsonProperty("passengerStatus")
    public String getPassengerStatus() {
        return passengerStatus;
    }

    @JsonProperty("passengerStatus")
    public void setPassengerStatus(String passengerStatus) {
        this.passengerStatus = passengerStatus;
    }

    @JsonProperty("ICTSStatus")
    public String getICTSStatus() {
        return iCTSStatus;
    }

    @JsonProperty("ICTSStatus")
    public void setICTSStatus(String iCTSStatus) {
        this.iCTSStatus = iCTSStatus;
    }

    @JsonProperty("infantsOnLap")
    public List<String> getInfantsOnLap() {
        return infantsOnLap;
    }

    @JsonProperty("infantsOnLap")
    public void setInfantsOnLap(List<String> infantsOnLap) {
        this.infantsOnLap = infantsOnLap;
    }

    @JsonProperty("infantsOnSeat")
    public List<String> getInfantsOnSeat() {
        return infantsOnSeat;
    }

    @JsonProperty("infantsOnSeat")
    public void setInfantsOnSeat(List<String> infantsOnSeat) {
        this.infantsOnSeat = infantsOnSeat;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("lead")
    public Boolean getLead() {
        return lead;
    }

    @JsonProperty("lead")
    public void setLead(Boolean lead) {
        this.lead = lead;
    }

    @JsonProperty("fareType")
    public String getFareType() {
        return fareType;
    }

    @JsonProperty("fareType")
    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    @JsonProperty("allocatedFareClass")
    public String getAllocatedFareClass() {
        return allocatedFareClass;
    }

    @JsonProperty("allocatedFareClass")
    public void setAllocatedFareClass(String allocatedFareClass) {
        this.allocatedFareClass = allocatedFareClass;
    }

    @JsonProperty("passengerMap")
    public List<String> getPassengerMap() {
        return passengerMap;
    }

    @JsonProperty("passengerMap")
    public void setPassengerMap(List<String> passengerMap) {
        this.passengerMap = passengerMap;
    }

    @JsonProperty("fareProduct")
    public FareProduct getFareProduct() {
        return fareProduct;
    }

    @JsonProperty("fareProduct")
    public void setFareProduct(FareProduct fareProduct) {
        this.fareProduct = fareProduct;
    }

    @JsonProperty("holdItems")
    public List<HoldItem> getHoldItems() {
        return holdItems;
    }

    @JsonProperty("holdItems")
    public void setHoldItems(List<HoldItem> holdItems) {
        this.holdItems = holdItems;
    }

    @JsonProperty("cabinItems")
    public List<CabinItem> getCabinItems() {
        return cabinItems;
    }

    @JsonProperty("cabinItems")
    public void setCabinItems(List<CabinItem> cabinItems) {
        this.cabinItems = cabinItems;
    }

    @JsonProperty("additionalItems")
    public List<AdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    @JsonProperty("additionalItems")
    public void setAdditionalItems(List<AdditionalItem> additionalItems) {
        this.additionalItems = additionalItems;
    }

    @JsonProperty("seat")
    public Seat getSeat() {
        return seat;
    }

    @JsonProperty("seat")
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @JsonProperty("additionalSeats")
    public List<AdditionalSeat> getAdditionalSeats() {
        return additionalSeats;
    }

    @JsonProperty("additionalSeats")
    public void setAdditionalSeats(List<AdditionalSeat> additionalSeats) {
        this.additionalSeats = additionalSeats;
    }

    @JsonProperty("passengerAPIS")
    public PassengerAPIS getPassengerAPIS() {
        return passengerAPIS;
    }

    @JsonProperty("passengerAPIS")
    public void setPassengerAPIS(PassengerAPIS passengerAPIS) {
        this.passengerAPIS = passengerAPIS;
    }

    @JsonProperty("specialRequests")
    public List<SpecialRequest> getSpecialRequests() {
        return specialRequests;
    }

    @JsonProperty("specialRequests")
    public void setSpecialRequests(List<SpecialRequest> specialRequests) {
        this.specialRequests = specialRequests;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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
