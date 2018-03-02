
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
    "seatNumber",
    "seatBand",
    "seatCharacteristics"
})
public class Seat {

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
    @JsonProperty("seatNumber")
    private String seatNumber;
    @JsonProperty("seatBand")
    private String seatBand;
    @JsonProperty("seatCharacteristics")
    private List<String> seatCharacteristics = null;
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

    @JsonProperty("seatNumber")
    public String getSeatNumber() {
        return seatNumber;
    }

    @JsonProperty("seatNumber")
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @JsonProperty("seatBand")
    public String getSeatBand() {
        return seatBand;
    }

    @JsonProperty("seatBand")
    public void setSeatBand(String seatBand) {
        this.seatBand = seatBand;
    }

    @JsonProperty("seatCharacteristics")
    public List<String> getSeatCharacteristics() {
        return seatCharacteristics;
    }

    @JsonProperty("seatCharacteristics")
    public void setSeatCharacteristics(List<String> seatCharacteristics) {
        this.seatCharacteristics = seatCharacteristics;
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
