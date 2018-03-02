package com.api.example.fixture.invoke.response.registerCustomerResponse;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "registrationConfirmation",
        "additionalInformation"
})
public class RegisterCustomerResponse implements IResponse {

    @JsonProperty("registrationConfirmation")
    private RegistrationConfirmation registrationConfirmation;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The registrationConfirmation
     */
    @JsonProperty("registrationConfirmation")
    public RegistrationConfirmation getRegistrationConfirmation() {
        return registrationConfirmation;
    }

    /**
     * @param registrationConfirmation The registrationConfirmation
     */
    @JsonProperty("registrationConfirmation")
    public void setRegistrationConfirmation(RegistrationConfirmation registrationConfirmation) {
        this.registrationConfirmation = registrationConfirmation;
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
