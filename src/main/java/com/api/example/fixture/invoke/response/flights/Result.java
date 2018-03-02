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
        "journeys"
})
@ToString
public class Result {

    @JsonProperty("journeys")
    private List<Journey> journeys = new ArrayList<Journey>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The journeys
     */
    @JsonProperty("journeys")
    public List<Journey> getJourneys() {
        return journeys;
    }

    /**
     * @param journeys The journeys
     */
    @JsonProperty("journeys")
    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
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
