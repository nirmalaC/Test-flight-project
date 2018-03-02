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
        "optedOutMarketing",
        "optedOutPeriod",
        "contactMethods",
        "contactTypes",
        "frequency"
})
public class CommunicationPreferences {

    @JsonProperty("optedOutMarketing")
    private List<String> optedOutMarketing = new ArrayList<String>();
    @JsonProperty("optedOutPeriod")
    private OptedOutPeriod optedOutPeriod;
    @JsonProperty("contactMethods")
    private List<String> contactMethods = new ArrayList<String>();
    @JsonProperty("contactTypes")
    private List<String> contactTypes = new ArrayList<String>();
    @JsonProperty("frequency")
    private String frequency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The optedOutPeriod
     */
    @JsonProperty("optedOutPeriod")
    public OptedOutPeriod getOptedOutPeriod() {
        return optedOutPeriod;
    }

    /**
     * @param optedOutPeriod The optedOutPeriod
     */
    @JsonProperty("optedOutPeriod")
    public void setOptedOutPeriod(OptedOutPeriod optedOutPeriod) {
        this.optedOutPeriod = optedOutPeriod;
    }

    /**
     * @return The contactMethods
     */
    @JsonProperty("contactMethods")
    public List<String> getContactMethods() {
        return contactMethods;
    }

    /**
     * @param contactMethods The contactMethods
     */
    @JsonProperty("contactMethods")
    public void setContactMethods(List<String> contactMethods) {
        this.contactMethods = contactMethods;
    }

    /**
     * @return The contactTypes
     */
    @JsonProperty("contactTypes")
    public List<String> getContactTypes() {
        return contactTypes;
    }

    /**
     * @param contactTypes The contactTypes
     */
    @JsonProperty("contactTypes")
    public void setContactTypes(List<String> contactTypes) {
        this.contactTypes = contactTypes;
    }

    /**
     * @return The frequency
     */
    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency The frequency
     */
    @JsonProperty("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
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
