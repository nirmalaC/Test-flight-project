package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "ssrCode",
        "ssrDescription"
})
public class Ssr {

    @JsonProperty("ssrCode")
    private String ssrCode;
    @JsonProperty("ssrDescription")
    private String ssrDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The ssrCode
     */
    @JsonProperty("ssrCode")
    public String getSsrCode() {
        return ssrCode;
    }

    /**
     * @param ssrCode The ssrCode
     */
    @JsonProperty("ssrCode")
    public void setSsrCode(String ssrCode) {
        this.ssrCode = ssrCode;
    }

    /**
     * @return The ssrDescription
     */
    @JsonProperty("ssrDescription")
    public String getSsrDescription() {
        return ssrDescription;
    }

    /**
     * @param ssrDescription The ssrDescription
     */
    @JsonProperty("ssrDescription")
    public void setSsrDescription(String ssrDescription) {
        this.ssrDescription = ssrDescription;
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
