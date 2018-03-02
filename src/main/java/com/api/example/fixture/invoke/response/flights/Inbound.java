package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "result",
        "alternativeSectors"
})
public class Inbound {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("alternativeSectors")
    private List<AlternativeSector> alternativeSectors = new ArrayList<AlternativeSector>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The result
     */
    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * @return The alternativeSectors
     */
    @JsonProperty("alternativeSectors")
    public List<AlternativeSector> getAlternativeSectors() {
        return alternativeSectors;
    }

    /**
     * @param alternativeSectors The alternativeSectors
     */
    @JsonProperty("alternativeSectors")
    public void setAlternativeSectors(List<AlternativeSector> alternativeSectors) {
        this.alternativeSectors = alternativeSectors;
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
