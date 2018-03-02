package com.api.example.fixture.invoke.response.passengertypes;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
import com.api.example.fixture.invoke.response.common.AdditionalInformation;
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
        "passengerTypes",
        "passengerRules",
        "additionalInformations"
})
public class PassengerTypesResponse implements IResponse {

    @JsonProperty("passengerTypes")
    private List<PassengerType> passengerTypes = new ArrayList<PassengerType>();
    @JsonProperty("passengerRules")
    private PassengerRules passengerRules;
    @JsonProperty("additionalInformations")
    private List<AdditionalInformation> additionalInformations = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The passengerTypes
     */
    @JsonProperty("passengerTypes")
    public List<PassengerType> getPassengerTypes() {
        return passengerTypes;
    }

    /**
     * @param passengerTypes The passengerTypes
     */
    @JsonProperty("passengerTypes")
    public void setPassengerTypes(List<PassengerType> passengerTypes) {
        this.passengerTypes = passengerTypes;
    }

    /**
     * @return The passengerRules
     */
    @JsonProperty("passengerRules")
    public PassengerRules getPassengerRules() {
        return passengerRules;
    }

    /**
     * @param passengerRules The passengerRules
     */
    @JsonProperty("passengerRules")
    public void setPassengerRules(PassengerRules passengerRules) {
        this.passengerRules = passengerRules;
    }

    /**
     * @return The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public List<AdditionalInformation> getAdditionalInformations() {
        return additionalInformations;
    }

    /**
     * @param additionalInformations The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public void setAdditionalInformations(List<AdditionalInformation> additionalInformations) {
        this.additionalInformations = additionalInformations;
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
