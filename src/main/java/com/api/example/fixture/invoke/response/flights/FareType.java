package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "fareTypeCode",
        "isLowestFare",
        "gdsFareClass",
        "totalFare",
        "discounts",
        "fareClass",
        "passengers"
})
@ToString
public class FareType {

    @JsonProperty("fareTypeCode")
    private String fareTypeCode;
    @JsonProperty("isLowestFare")
    private Boolean isLowestFare;
    @JsonProperty("gdsFareClass")
    private String gdsFareClass;
    @JsonProperty("totalFare")
    private TotalFare totalFare;
    @JsonProperty("discounts")
    private List<Discount> discounts = new ArrayList<Discount>();
    @JsonProperty("fareClass")
    private FareClass fareClass;
    @JsonProperty("passengers")
    private List<Passenger> passengers = new ArrayList<Passenger>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The fareTypeCode
     */
    @JsonProperty("fareTypeCode")
    public String getFareTypeCode() {
        return fareTypeCode;
    }

    /**
     * @param fareTypeCode The fareTypeCode
     */
    @JsonProperty("fareTypeCode")
    public void setFareTypeCode(String fareTypeCode) {
        this.fareTypeCode = fareTypeCode;
    }

    /**
     * @return The isLowestFare
     */
    @JsonProperty("isLowestFare")
    public Boolean getIsLowestFare() {
        return isLowestFare;
    }

    /**
     * @param isLowestFare The isLowestFare
     */
    @JsonProperty("isLowestFare")
    public void setIsLowestFare(Boolean isLowestFare) {
        this.isLowestFare = isLowestFare;
    }

    /**
     * @return The gdsFareClass
     */
    @JsonProperty("gdsFareClass")
    public String getGdsFareClass() {
        return gdsFareClass;
    }

    /**
     * @param gdsFareClass The gdsFareClass
     */
    @JsonProperty("gdsFareClass")
    public void setGdsFareClass(String gdsFareClass) {
        this.gdsFareClass = gdsFareClass;
    }

    /**
     * @return The totalFare
     */
    @JsonProperty("totalFare")
    public TotalFare getTotalFare() {
        return totalFare;
    }

    /**
     * @param totalFare The totalFare
     */
    @JsonProperty("totalFare")
    public void setTotalFare(TotalFare totalFare) {
        this.totalFare = totalFare;
    }

    /**
     * @return The discounts
     */
    @JsonProperty("discounts")
    public List<Discount> getDiscounts() {
        return discounts;
    }

    /**
     * @param discounts The discounts
     */
    @JsonProperty("discounts")
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    /**
     * @return The fareClass
     */
    @JsonProperty("fareClass")
    public FareClass getFareClass() {
        return fareClass;
    }

    /**
     * @param fareClass The fareClass
     */
    @JsonProperty("fareClass")
    public void setFareClass(FareClass fareClass) {
        this.fareClass = fareClass;
    }

    /**
     * @return The passengers
     */
    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * @param passengers The passengers
     */
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
