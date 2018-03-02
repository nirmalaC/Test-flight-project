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
        "type",
        "bundleCode",
        "code",
        "name",
        "description",
        "quantity",
        "pricing",
        "travellerCode",
        "travelType",
        "originAirport",
        "originAirportCountry",
        "destinationAirport",
        "destinationAirportCountry",
        "travelInsurancePolicies"
})
public class TravelInsurance {

    @JsonProperty("type")
    private String type;
    @JsonProperty("bundleCode")
    private String bundleCode;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("pricing")
    private Pricing pricing;
    @JsonProperty("travellerCode")
    private String travellerCode;
    @JsonProperty("travelType")
    private String travelType;
    @JsonProperty("originAirport")
    private String originAirport;
    @JsonProperty("originAirportCountry")
    private String originAirportCountry;
    @JsonProperty("destinationAirport")
    private String destinationAirport;
    @JsonProperty("destinationAirportCountry")
    private String destinationAirportCountry;
    @JsonProperty("travelInsurancePolicies")
    private List<TravelInsurancePolicy> travelInsurancePolicies = new ArrayList<TravelInsurancePolicy>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The bundleCode
     */
    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    /**
     * @param bundleCode The bundleCode
     */
    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

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
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The pricing
     */
    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    /**
     * @param pricing The pricing
     */
    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * @return The travellerCode
     */
    @JsonProperty("travellerCode")
    public String getTravellerCode() {
        return travellerCode;
    }

    /**
     * @param travellerCode The travellerCode
     */
    @JsonProperty("travellerCode")
    public void setTravellerCode(String travellerCode) {
        this.travellerCode = travellerCode;
    }

    /**
     * @return The travelType
     */
    @JsonProperty("travelType")
    public String getTravelType() {
        return travelType;
    }

    /**
     * @param travelType The travelType
     */
    @JsonProperty("travelType")
    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    /**
     * @return The originAirport
     */
    @JsonProperty("originAirport")
    public String getOriginAirport() {
        return originAirport;
    }

    /**
     * @param originAirport The originAirport
     */
    @JsonProperty("originAirport")
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    /**
     * @return The originAirportCountry
     */
    @JsonProperty("originAirportCountry")
    public String getOriginAirportCountry() {
        return originAirportCountry;
    }

    /**
     * @param originAirportCountry The originAirportCountry
     */
    @JsonProperty("originAirportCountry")
    public void setOriginAirportCountry(String originAirportCountry) {
        this.originAirportCountry = originAirportCountry;
    }

    /**
     * @return The destinationAirport
     */
    @JsonProperty("destinationAirport")
    public String getDestinationAirport() {
        return destinationAirport;
    }

    /**
     * @param destinationAirport The destinationAirport
     */
    @JsonProperty("destinationAirport")
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * @return The destinationAirportCountry
     */
    @JsonProperty("destinationAirportCountry")
    public String getDestinationAirportCountry() {
        return destinationAirportCountry;
    }

    /**
     * @param destinationAirportCountry The destinationAirportCountry
     */
    @JsonProperty("destinationAirportCountry")
    public void setDestinationAirportCountry(String destinationAirportCountry) {
        this.destinationAirportCountry = destinationAirportCountry;
    }

    /**
     * @return The travelInsurancePolicies
     */
    @JsonProperty("travelInsurancePolicies")
    public List<TravelInsurancePolicy> getTravelInsurancePolicies() {
        return travelInsurancePolicies;
    }

    /**
     * @param travelInsurancePolicies The travelInsurancePolicies
     */
    @JsonProperty("travelInsurancePolicies")
    public void setTravelInsurancePolicies(List<TravelInsurancePolicy> travelInsurancePolicies) {
        this.travelInsurancePolicies = travelInsurancePolicies;
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
