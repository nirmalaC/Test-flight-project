
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isDirect",
    "totalDuration",
    "stops",
    "totalAmount",
    "flights"
})
public class Inbound {

    @JsonProperty("isDirect")
    private Boolean isDirect;
    @JsonProperty("totalDuration")
    private String totalDuration;
    @JsonProperty("stops")
    private Integer stops;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonProperty("flights")
    private List<Flight> flights = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isDirect")
    public Boolean getIsDirect() {
        return isDirect;
    }

    @JsonProperty("isDirect")
    public void setIsDirect(Boolean isDirect) {
        this.isDirect = isDirect;
    }

    @JsonProperty("totalDuration")
    public String getTotalDuration() {
        return totalDuration;
    }

    @JsonProperty("totalDuration")
    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    @JsonProperty("stops")
    public Integer getStops() {
        return stops;
    }

    @JsonProperty("stops")
    public void setStops(Integer stops) {
        this.stops = stops;
    }

    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("flights")
    public List<Flight> getFlights() {
        return flights;
    }

    @JsonProperty("flights")
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
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
