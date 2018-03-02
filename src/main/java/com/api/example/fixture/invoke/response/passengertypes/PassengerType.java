package com.api.example.fixture.invoke.response.passengertypes;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.common.LocalizedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "localizedNames",
        "minAge",
        "maxPermitted",
        "maxAge"
})
public class PassengerType {

    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("minAge")
    private Integer minAge;
    @JsonProperty("maxPermitted")
    private Integer maxPermitted;
    @JsonProperty("maxAge")
    private Integer maxAge;
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
     * @return The localizedNames
     */
    @JsonProperty("localizedNames")
    public List<LocalizedName> getLocalizedNames() {
        return localizedNames;
    }

    /**
     * @param localizedNames The localizedNames
     */
    @JsonProperty("localizedNames")
    public void setLocalizedNames(List<LocalizedName> localizedNames) {
        this.localizedNames = localizedNames;
    }

    /**
     * @return The minAge
     */
    @JsonProperty("minAge")
    public Integer getMinAge() {
        return minAge;
    }

    /**
     * @param minAge The minAge
     */
    @JsonProperty("minAge")
    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    /**
     * @return The maxPermitted
     */
    @JsonProperty("maxPermitted")
    public Integer getMaxPermitted() {
        return maxPermitted;
    }

    /**
     * @param maxPermitted The maxPermitted
     */
    @JsonProperty("maxPermitted")
    public void setMaxPermitted(Integer maxPermitted) {
        this.maxPermitted = maxPermitted;
    }

    /**
     * @return The maxAge
     */
    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge The maxAge
     */
    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
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
