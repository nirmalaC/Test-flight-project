package com.api.example.fixture.invoke.response.languages;


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
        "nativeName",
        "isActive"
})
public class Language {

    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("nativeName")
    private String nativeName;
    @JsonProperty("isActive")
    private Boolean isActive;
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
     * @return The nativeName
     */
    @JsonProperty("nativeName")
    public String getNativeName() {
        return nativeName;
    }

    /**
     * @param nativeName The nativeName
     */
    @JsonProperty("nativeName")
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     * @return The isActive
     */
    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive The isActive
     */
    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
