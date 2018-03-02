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
        "personalDetails",
        "contactAddress"
})
public class BasicProfile {

    @JsonProperty("personalDetails")
    private PersonalDetails personalDetails;
    @JsonProperty("contactAddress")
    private List<ContactAddress> contactAddress = new ArrayList<ContactAddress>();
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
