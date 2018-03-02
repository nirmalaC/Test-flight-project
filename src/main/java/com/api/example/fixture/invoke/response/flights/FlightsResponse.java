package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "defaultCardType",
        "currency",
        "outbound",
        "inbound",
        "additionalInformation"
})
public class FlightsResponse implements IResponse {

    @JsonProperty("defaultCardType")
    private String defaultCardType;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("outbound")
    private Outbound outbound;
    @JsonProperty("inbound")
    private Inbound inbound;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The defaultCardType
     */
    @JsonProperty("defaultCardType")
    public String getDefaultCardType() {
        return defaultCardType;
    }

    /**
     * @param defaultCardType The defaultCardType
     */
    @JsonProperty("defaultCardType")
    public void setDefaultCardType(String defaultCardType) {
        this.defaultCardType = defaultCardType;
    }

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

    /**
     * @return The additionalInformation
     */
    @JsonProperty("additionalInformation")
    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation The additionalInformation
     */
    @JsonProperty("additionalInformation")
    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
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
