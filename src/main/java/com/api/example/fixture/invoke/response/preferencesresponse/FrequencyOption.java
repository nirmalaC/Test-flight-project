package com.api.example.fixture.invoke.response.preferencesresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "localizedNames"
})
public class FrequencyOption {

    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = null;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
