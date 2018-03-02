
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private List<TravelInsurancePolicy> travelInsurancePolicies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("travellerCode")
    public String getTravellerCode() {
        return travellerCode;
    }

    @JsonProperty("travellerCode")
    public void setTravellerCode(String travellerCode) {
        this.travellerCode = travellerCode;
    }

    @JsonProperty("travelType")
    public String getTravelType() {
        return travelType;
    }

    @JsonProperty("travelType")
    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    @JsonProperty("originAirport")
    public String getOriginAirport() {
        return originAirport;
    }

    @JsonProperty("originAirport")
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    @JsonProperty("originAirportCountry")
    public String getOriginAirportCountry() {
        return originAirportCountry;
    }

    @JsonProperty("originAirportCountry")
    public void setOriginAirportCountry(String originAirportCountry) {
        this.originAirportCountry = originAirportCountry;
    }

    @JsonProperty("destinationAirport")
    public String getDestinationAirport() {
        return destinationAirport;
    }

    @JsonProperty("destinationAirport")
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @JsonProperty("destinationAirportCountry")
    public String getDestinationAirportCountry() {
        return destinationAirportCountry;
    }

    @JsonProperty("destinationAirportCountry")
    public void setDestinationAirportCountry(String destinationAirportCountry) {
        this.destinationAirportCountry = destinationAirportCountry;
    }

    @JsonProperty("travelInsurancePolicies")
    public List<TravelInsurancePolicy> getTravelInsurancePolicies() {
        return travelInsurancePolicies;
    }

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
