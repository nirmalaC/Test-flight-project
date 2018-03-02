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
        "remainingChanges",
        "changesEndDate",
        "passengers"
})
public class SignificantOthers {

    @JsonProperty("remainingChanges")
    private String remainingChanges;
    @JsonProperty("changesEndDate")
    private String changesEndDate;
    @JsonProperty("passengers")
    private List<Passenger> passengers = new ArrayList<Passenger>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The remainingChanges
     */
    @JsonProperty("remainingChanges")
    public String getRemainingChanges() {
        return remainingChanges;
    }

    /**
     * @param remainingChanges The remainingChanges
     */
    @JsonProperty("remainingChanges")
    public void setRemainingChanges(String remainingChanges) {
        this.remainingChanges = remainingChanges;
    }

    /**
     * @return The changesEndDate
     */
    @JsonProperty("changesEndDate")
    public String getChangesEndDate() {
        return changesEndDate;
    }

    /**
     * @param changesEndDate The changesEndDate
     */
    @JsonProperty("changesEndDate")
    public void setChangesEndDate(String changesEndDate) {
        this.changesEndDate = changesEndDate;
    }

    /**
     * @return The passengers
     */
    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * @param passengers The passengers
     */
    @JsonProperty("passengers")
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
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
