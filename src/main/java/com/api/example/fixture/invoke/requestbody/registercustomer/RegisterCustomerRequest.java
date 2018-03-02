package com.api.example.fixture.invoke.requestbody.registercustomer;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "personalDetails",
        "contactAddress",
        "optedOutMarketing",
        "preferredAirports"
})
@Builder
public class RegisterCustomerRequest implements IRequestBody {

    @JsonProperty("personalDetails")
    private PersonalDetails personalDetails;
    @JsonProperty("contactAddress")
    private List<ContactAddress> contactAddress = null;
    @JsonProperty("optedOutMarketing")
    private List<String> optedOutMarketing = null;
    @JsonProperty("preferredAirports")
    private List<String> preferredAirports = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The personalDetails
     */
    @JsonProperty("personalDetails")
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * @param personalDetails The personalDetails
     */
    @JsonProperty("personalDetails")
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    /**
     * @return The contactAddress
     */
    @JsonProperty("contactAddress")
    public List<ContactAddress> getContactAddress() {
        return contactAddress;
    }

    /**
     * @param contactAddress The contactAddress
     */
    @JsonProperty("contactAddress")
    public void setContactAddress(List<ContactAddress> contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * @return The optedOutMarketing
     */
    @JsonProperty("optedOutMarketing")
    public List<String> getOptedOutMarketing() {
        return optedOutMarketing;
    }

    /**
     * @param optedOutMarketing The optedOutMarketing
     */
    @JsonProperty("optedOutMarketing")
    public void setOptedOutMarketing(List<String> optedOutMarketing) {
        this.optedOutMarketing = optedOutMarketing;
    }

    /**
     * @return The preferredAirports
     */
    @JsonProperty("preferredAirports")
    public List<String> getPreferredAirports() {
        return preferredAirports;
    }

    /**
     * @param preferredAirports The preferredAirports
     */
    @JsonProperty("preferredAirports")
    public void setPreferredAirports(List<String> preferredAirports) {
        this.preferredAirports = preferredAirports;
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
