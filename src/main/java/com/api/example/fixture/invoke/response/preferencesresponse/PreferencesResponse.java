package com.api.example.fixture.invoke.response.preferencesresponse;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "preferencesReferenceData"
})
public class PreferencesResponse implements IResponse {

    @JsonProperty("preferencesReferenceData")
    private PreferencesReferenceData preferencesReferenceData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The preferencesReferenceData
     */
    @JsonProperty("preferencesReferenceData")
    public PreferencesReferenceData getPreferencesReferenceData() {
        return preferencesReferenceData;
    }

    /**
     * @param preferencesReferenceData The preferencesReferenceData
     */
    @JsonProperty("preferencesReferenceData")
    public void setPreferencesReferenceData(PreferencesReferenceData preferencesReferenceData) {
        this.preferencesReferenceData = preferencesReferenceData;
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
