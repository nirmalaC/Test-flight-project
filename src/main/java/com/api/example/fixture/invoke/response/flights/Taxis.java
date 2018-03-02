package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "value",
        "percentageValue"
})
public class Taxis {

    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("percentageValue")
    private Integer percentageValue;
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
     * @return The value
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @return The percentageValue
     */
    @JsonProperty("percentageValue")
    public Integer getPercentageValue() {
        return percentageValue;
    }

    /**
     * @param percentageValue The percentageValue
     */
    @JsonProperty("percentageValue")
    public void setPercentageValue(Integer percentageValue) {
        this.percentageValue = percentageValue;
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
