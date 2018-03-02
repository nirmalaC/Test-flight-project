package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "departure",
        "arrival"
})
public class Sector {

    @JsonProperty("code")
    private String code;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The departure
     */
    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    /**
     * @param departure The departure
     */
    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    /**
     * @return The arrival
     */
    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }

    /**
     * @param arrival The arrival
     */
    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
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
