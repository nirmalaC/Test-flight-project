
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxes",
    "fees",
    "discounts",
    "subtotalAmount",
    "totalAmount"
})
public class PriceSummary {

    @JsonProperty("taxes")
    private Taxes taxes;
    @JsonProperty("fees")
    private Fees fees;
    @JsonProperty("discounts")
    private Discounts discounts;
    @JsonProperty("subtotalAmount")
    private String subtotalAmount;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("taxes")
    public Taxes getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    @JsonProperty("fees")
    public Fees getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(Fees fees) {
        this.fees = fees;
    }

    @JsonProperty("discounts")
    public Discounts getDiscounts() {
        return discounts;
    }

    @JsonProperty("discounts")
    public void setDiscounts(Discounts discounts) {
        this.discounts = discounts;
    }

    @JsonProperty("subtotalAmount")
    public String getSubtotalAmount() {
        return subtotalAmount;
    }

    @JsonProperty("subtotalAmount")
    public void setSubtotalAmount(String subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
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
