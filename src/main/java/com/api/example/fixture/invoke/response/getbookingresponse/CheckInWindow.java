
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
    "opening",
    "closing"
})
public class CheckInWindow {

    @JsonProperty("opening")
    private String opening;
    @JsonProperty("closing")
    private String closing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("opening")
    public String getOpening() {
        return opening;
    }

    @JsonProperty("opening")
    public void setOpening(String opening) {
        this.opening = opening;
    }

    @JsonProperty("closing")
    public String getClosing() {
        return closing;
    }

    @JsonProperty("closing")
    public void setClosing(String closing) {
        this.closing = closing;
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
