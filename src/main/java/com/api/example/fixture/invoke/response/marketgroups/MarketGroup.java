package com.api.example.fixture.invoke.response.marketgroups;

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
        "type",
        "status",
        "localizedNames",
        "localizedDescriptions",
        "airports"
})
public class MarketGroup {

    @JsonProperty("code")
    private String code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("localizedDescriptions")
    private List<LocalizedDescription> localizedDescriptions = new ArrayList<LocalizedDescription>();
    @JsonProperty("airports")
    private List<String> airports = new ArrayList<String>();
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
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
     * @return The localizedDescriptions
     */
    @JsonProperty("localizedDescriptions")
    public List<LocalizedDescription> getLocalizedDescriptions() {
        return localizedDescriptions;
    }

    /**
     * @param localizedDescriptions The localizedDescriptions
     */
    @JsonProperty("localizedDescriptions")
    public void setLocalizedDescriptions(List<LocalizedDescription> localizedDescriptions) {
        this.localizedDescriptions = localizedDescriptions;
    }

    /**
     * @return The airports
     */
    @JsonProperty("airports")
    public List<String> getAirports() {
        return airports;
    }

    /**
     * @param airports The airports
     */
    @JsonProperty("airports")
    public void setAirports(List<String> airports) {
        this.airports = airports;
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
