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
        "seatingPreferences",
        "seatNumber",
        "holdBagQuantity",
        "holdBagWeight"
})
public class AncillaryPreferences {

    @JsonProperty("seatingPreferences")
    private List<String> seatingPreferences = new ArrayList<String>();
    @JsonProperty("seatNumber")
    private String seatNumber;
    @JsonProperty("holdBagQuantity")
    private String holdBagQuantity;
    @JsonProperty("holdBagWeight")
    private String holdBagWeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The seatingPreferences
     */
    @JsonProperty("seatingPreferences")
    public List<String> getSeatingPreferences() {
        return seatingPreferences;
    }

    /**
     * @param seatingPreferences The seatingPreferences
     */
    @JsonProperty("seatingPreferences")
    public void setSeatingPreferences(List<String> seatingPreferences) {
        this.seatingPreferences = seatingPreferences;
    }

    /**
     * @return The seatNumber
     */
    @JsonProperty("seatNumber")
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber The seatNumber
     */
    @JsonProperty("seatNumber")
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return The holdBagQuantity
     */
    @JsonProperty("holdBagQuantity")
    public String getHoldBagQuantity() {
        return holdBagQuantity;
    }

    /**
     * @param holdBagQuantity The holdBagQuantity
     */
    @JsonProperty("holdBagQuantity")
    public void setHoldBagQuantity(String holdBagQuantity) {
        this.holdBagQuantity = holdBagQuantity;
    }

    /**
     * @return The holdBagWeight
     */
    @JsonProperty("holdBagWeight")
    public String getHoldBagWeight() {
        return holdBagWeight;
    }

    /**
     * @param holdBagWeight The holdBagWeight
     */
    @JsonProperty("holdBagWeight")
    public void setHoldBagWeight(String holdBagWeight) {
        this.holdBagWeight = holdBagWeight;
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
