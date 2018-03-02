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
        "basePrice",
        "taxes",
        "fees",
        "discounts",
        "totalAmountWithCreditCard",
        "totalAmountWithDebitCard"
})
public class Pricing {

    @JsonProperty("basePrice")
    private String basePrice;
    @JsonProperty("taxes")
    private List<Object> taxes = new ArrayList<Object>();
    @JsonProperty("fees")
    private List<Fee> fees = new ArrayList<Fee>();
    @JsonProperty("discounts")
    private List<Object> discounts = new ArrayList<Object>();
    @JsonProperty("totalAmountWithCreditCard")
    private String totalAmountWithCreditCard;
    @JsonProperty("totalAmountWithDebitCard")
    private String totalAmountWithDebitCard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The basePrice
     */
    @JsonProperty("basePrice")
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice The basePrice
     */
    @JsonProperty("basePrice")
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return The taxes
     */
    @JsonProperty("taxes")
    public List<Object> getTaxes() {
        return taxes;
    }

    /**
     * @param taxes The taxes
     */
    @JsonProperty("taxes")
    public void setTaxes(List<Object> taxes) {
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
     * @return The discounts
     */
    @JsonProperty("discounts")
    public List<Object> getDiscounts() {
        return discounts;
    }

    /**
     * @param discounts The discounts
     */
    @JsonProperty("discounts")
    public void setDiscounts(List<Object> discounts) {
        this.discounts = discounts;
    }

    /**
     * @return The totalAmountWithCreditCard
     */
    @JsonProperty("totalAmountWithCreditCard")
    public String getTotalAmountWithCreditCard() {
        return totalAmountWithCreditCard;
    }

    /**
     * @param totalAmountWithCreditCard The totalAmountWithCreditCard
     */
    @JsonProperty("totalAmountWithCreditCard")
    public void setTotalAmountWithCreditCard(String totalAmountWithCreditCard) {
        this.totalAmountWithCreditCard = totalAmountWithCreditCard;
    }

    /**
     * @return The totalAmountWithDebitCard
     */
    @JsonProperty("totalAmountWithDebitCard")
    public String getTotalAmountWithDebitCard() {
        return totalAmountWithDebitCard;
    }

    /**
     * @param totalAmountWithDebitCard The totalAmountWithDebitCard
     */
    @JsonProperty("totalAmountWithDebitCard")
    public void setTotalAmountWithDebitCard(String totalAmountWithDebitCard) {
        this.totalAmountWithDebitCard = totalAmountWithDebitCard;
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
