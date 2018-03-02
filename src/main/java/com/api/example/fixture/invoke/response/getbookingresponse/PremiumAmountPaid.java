
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
    "basePrice",
    "taxes",
    "fees",
    "discounts",
    "totalAmount"
})
public class PremiumAmountPaid {

    @JsonProperty("basePrice")
    private String basePrice;
    @JsonProperty("taxes")
    private List<Object> taxes = null;
    @JsonProperty("fees")
    private List<Object> fees = null;
    @JsonProperty("discounts")
    private List<Object> discounts = null;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("basePrice")
    public String getBasePrice() {
        return basePrice;
    }

    @JsonProperty("basePrice")
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    @JsonProperty("taxes")
    public List<Object> getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(List<Object> taxes) {
        this.taxes = taxes;
    }

    @JsonProperty("fees")
    public List<Object> getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(List<Object> fees) {
        this.fees = fees;
    }

    @JsonProperty("discounts")
    public List<Object> getDiscounts() {
        return discounts;
    }

    @JsonProperty("discounts")
    public void setDiscounts(List<Object> discounts) {
        this.discounts = discounts;
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
