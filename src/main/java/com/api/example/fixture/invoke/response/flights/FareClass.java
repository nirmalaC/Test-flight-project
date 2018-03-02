package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "availableUnits"
})
public class FareClass {

    @JsonProperty("code")
    private String code;
    @JsonProperty("availableUnits")
    private Integer availableUnits;
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
     * @return The availableUnits
     */
    @JsonProperty("availableUnits")
    public Integer getAvailableUnits() {
        return availableUnits;
    }

    /**
     * @param availableUnits The availableUnits
     */
    @JsonProperty("availableUnits")
    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
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
