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
        "type",
        "basePrice",
        "quantity",
        "totalTaxes",
        "totalFees",
        "totalDiscounts",
        "additionalSeats",
        "taxes",
        "fees",
        "totalPassengerFare"
})
//@Builder
@ToString
public class Passenger {

    @JsonProperty("type")
    private String type;
    @JsonProperty("basePrice")
    private Double basePrice;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("totalTaxes")
    private Integer totalTaxes;
    @JsonProperty("totalFees")
    private Double totalFees;
    @JsonProperty("totalDiscounts")
    private Double totalDiscounts;
    @JsonProperty("additionalSeats")
    private Integer additionalSeats;
    @JsonProperty("infantOnSeat")
    private boolean infantOnSeat;
    @JsonProperty("taxes")
    private List<Taxis> taxes = new ArrayList<Taxis>();
    @JsonProperty("fees")
    private List<Fee> fees = new ArrayList<Fee>();
    @JsonProperty("totalPassengerFare")
    private TotalPassengerFare totalPassengerFare;
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
     * @return The basePrice
     */
    @JsonProperty("basePrice")
    public Double getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice The basePrice
     */
    @JsonProperty("basePrice")
    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }


    @JsonProperty("infantOnSeat")
    public boolean getInfantOnSeat() {
        return infantOnSeat;
    }


    @JsonProperty("infantOnSeat")
    public void setInfantOnSeat(boolean infantOnSeat) {
        this.infantOnSeat = infantOnSeat;
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
     * @return The totalTaxes
     */
    @JsonProperty("totalTaxes")
    public Integer getTotalTaxes() {
        return totalTaxes;
    }

    /**
     * @param totalTaxes The totalTaxes
     */
    @JsonProperty("totalTaxes")
    public void setTotalTaxes(Integer totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    /**
     * @return The totalFees
     */
    @JsonProperty("totalFees")
    public Double getTotalFees() {
        return totalFees;
    }

    /**
     * @param totalFees The totalFees
     */
    @JsonProperty("totalFees")
    public void setTotalFees(Double totalFees) {
        this.totalFees = totalFees;
    }

    /**
     * @return The totalDiscounts
     */
    @JsonProperty("totalDiscounts")
    public double getTotalDiscounts() {
        return totalDiscounts;
    }

    /**
     * @param totalDiscounts The totalDiscounts
     */
    @JsonProperty("totalDiscounts")
    public void setTotalDiscounts(Double totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    /**
     * @return The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public Integer getAdditionalSeats() {
        return additionalSeats;
    }

    /**
     * @param additionalSeats The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public void setAdditionalSeats(Integer additionalSeats) {
        this.additionalSeats = additionalSeats;
    }

    /**
     * @return The taxes
     */
    @JsonProperty("taxes")
    public List<Taxis> getTaxes() {
        return taxes;
    }

    /**
     * @param taxes The taxes
     */
    @JsonProperty("taxes")
    public void setTaxes(List<Taxis> taxes) {
        this.taxes = taxes;
    }

    /**
     * @return The fees
     */
    @JsonProperty("fees")
    public List<Fee> getFees() {
        return fees;
    }

    /**
     * @param fees The fees
     */
    @JsonProperty("fees")
    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    /**
     * @return The totalPassengerFare
     */
    @JsonProperty("totalPassengerFare")
    public TotalPassengerFare getTotalPassengerFare() {
        return totalPassengerFare;
    }

    /**
     * @param totalPassengerFare The totalPassengerFare
     */
    @JsonProperty("totalPassengerFare")
    public void setTotalPassengerFare(TotalPassengerFare totalPassengerFare) {
        this.totalPassengerFare = totalPassengerFare;
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
