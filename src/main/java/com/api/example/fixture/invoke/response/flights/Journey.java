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
        "isDirect",
        "stops",
        "totalDuration",
        "flights"
})
@ToString
public class Journey {

    @JsonProperty("isDirect")
    private Boolean isDirect;
    @JsonProperty("stops")
    private Integer stops;
    @JsonProperty("totalDuration")
    private String totalDuration;
    @JsonProperty("flights")
    private List<Flight> flights = new ArrayList<Flight>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The isDirect
     */
    @JsonProperty("isDirect")
    public Boolean getIsDirect() {
        return isDirect;
    }

    /**
     * @param isDirect The isDirect
     */
    @JsonProperty("isDirect")
    public void setIsDirect(Boolean isDirect) {
        this.isDirect = isDirect;
    }

    /**
     * @return The stops
     */
    @JsonProperty("stops")
    public Integer getStops() {
        return stops;
    }

    /**
     * @param stops The stops
     */
    @JsonProperty("stops")
    public void setStops(Integer stops) {
        this.stops = stops;
    }

    /**
     * @return The totalDuration
     */
    @JsonProperty("totalDuration")
    public String getTotalDuration() {
        return totalDuration;
    }

    /**
     * @param totalDuration The totalDuration
     */
    @JsonProperty("totalDuration")
    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    /**
     * @return The flights
     */
    @JsonProperty("flights")
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * @param flights The flights
     */
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
