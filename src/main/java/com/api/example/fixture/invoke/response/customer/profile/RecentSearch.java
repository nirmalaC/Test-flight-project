package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "outbound",
        "inbound",
        "passengerMix"
})
public class RecentSearch {

    @JsonProperty("outbound")
    private Outbound outbound;
    @JsonProperty("inbound")
    private Inbound inbound;
    @JsonProperty("passengerMix")
    private List<PassengerMix> passengerMix = new ArrayList<PassengerMix>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The passengerMix
     */
    @JsonProperty("passengerMix")
    public List<PassengerMix> getPassengerMix() {
        return passengerMix;
    }

    /**
     * @param passengerMix The passengerMix
     */
    @JsonProperty("passengerMix")
    public void setPassengerMix(List<PassengerMix> passengerMix) {
        this.passengerMix = passengerMix;
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
