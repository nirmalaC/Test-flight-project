package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "currency",
        "price",
        "outbound",
        "inbound"
})
public class SavedInspireMeIdea {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("price")
    private String price;
    @JsonProperty("outbound")
    private Outbound outbound;
    @JsonProperty("inbound")
    private Inbound inbound;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The price
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return The outbound
     */
    @JsonProperty("outbound")
    public Outbound getOutbound() {
        return outbound;
    }

    /**
     * @param outbound The outbound
     */
    @JsonProperty("outbound")
    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

    /**
     * @return The inbound
     */
    @JsonProperty("inbound")
    public Inbound getInbound() {
        return inbound;
    }

    /**
     * @param inbound The inbound
     */
    @JsonProperty("inbound")
    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
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
