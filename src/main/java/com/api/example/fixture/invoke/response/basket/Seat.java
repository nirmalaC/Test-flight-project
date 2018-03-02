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
    private List<String> seatCharacteristics = new ArrayList<String>();
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
     * @return The seatBand
     */
    @JsonProperty("seatBand")
    public String getSeatBand() {
        return seatBand;
    }

    /**
     * @param seatBand The seatBand
     */
    @JsonProperty("seatBand")
    public void setSeatBand(String seatBand) {
        this.seatBand = seatBand;
    }

    /**
     * @return The seatCharacteristics
     */
    @JsonProperty("seatCharacteristics")
    public List<String> getSeatCharacteristics() {
        return seatCharacteristics;
    }

    /**
     * @param seatCharacteristics The seatCharacteristics
     */
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
