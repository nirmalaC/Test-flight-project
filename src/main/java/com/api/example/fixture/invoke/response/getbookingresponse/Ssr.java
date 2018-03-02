
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonProperty("ssrCode")
    public String getSsrCode() {
        return ssrCode;
    }

    @JsonProperty("ssrCode")
    public void setSsrCode(String ssrCode) {
        this.ssrCode = ssrCode;
    }

    @JsonProperty("ssrDescription")
    public String getSsrDescription() {
        return ssrDescription;
    }

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
