package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "name",
        "marketGroup",
        "terminal"
})
public class Arrival {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("marketGroup")
    private String marketGroup;
    @JsonProperty("terminal")
    private String terminal;
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
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The marketGroup
     */
    @JsonProperty("marketGroup")
    public String getMarketGroup() {
        return marketGroup;
    }

    /**
     * @param marketGroup The marketGroup
     */
    @JsonProperty("marketGroup")
    public void setMarketGroup(String marketGroup) {
        this.marketGroup = marketGroup;
    }

    /**
     * @return The terminal
     */
    @JsonProperty("terminal")
    public String getTerminal() {
        return terminal;
    }

    /**
     * @param terminal The terminal
     */
    @JsonProperty("terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
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
