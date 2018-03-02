package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "capacity",
        "available",
        "seats",
        "lid"
})
public class Inventory {

    @JsonProperty("capacity")
    private Integer capacity;
    @JsonProperty("available")
    private Integer available;
    @JsonProperty("seats")
    private Integer seats;
    @JsonProperty("lid")
    private Integer lid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The capacity
     */
    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * @param capacity The capacity
     */
    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * @return The available
     */
    @JsonProperty("available")
    public Integer getAvailable() {
        return available;
    }

    /**
     * @param available The available
     */
    @JsonProperty("available")
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * @return The seats
     */
    @JsonProperty("seats")
    public Integer getSeats() {
        return seats;
    }

    /**
     * @param seats The seats
     */
    @JsonProperty("seats")
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    /**
     * @return The lid
     */
    @JsonProperty("lid")
    public Integer getLid() {
        return lid;
    }

    /**
     * @param lid The lid
     */
    @JsonProperty("lid")
    public void setLid(Integer lid) {
        this.lid = lid;
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
