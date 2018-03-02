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
        "allowedFunctions",
        "basicProfile",
        "advancedProfile"
})
public class Customer {

    @JsonProperty("allowedFunctions")
    private List<String> allowedFunctions = new ArrayList<String>();
    @JsonProperty("basicProfile")
    private BasicProfile basicProfile;
    @JsonProperty("advancedProfile")
    private AdvancedProfile advancedProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The allowedFunctions
     */
    @JsonProperty("allowedFunctions")
    public List<String> getAllowedFunctions() {
        return allowedFunctions;
    }

    /**
     * @param allowedFunctions The allowedFunctions
     */
    @JsonProperty("allowedFunctions")
    public void setAllowedFunctions(List<String> allowedFunctions) {
        this.allowedFunctions = allowedFunctions;
    }

    /**
     * @return The basicProfile
     */
    @JsonProperty("basicProfile")
    public BasicProfile getBasicProfile() {
        return basicProfile;
    }

    /**
     * @param basicProfile The basicProfile
     */
    @JsonProperty("basicProfile")
    public void setBasicProfile(BasicProfile basicProfile) {
        this.basicProfile = basicProfile;
    }

    /**
     * @return The advancedProfile
     */
    @JsonProperty("advancedProfile")
    public AdvancedProfile getAdvancedProfile() {
        return advancedProfile;
    }

    /**
     * @param advancedProfile The advancedProfile
     */
    @JsonProperty("advancedProfile")
    public void setAdvancedProfile(AdvancedProfile advancedProfile) {
        this.advancedProfile = advancedProfile;
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
