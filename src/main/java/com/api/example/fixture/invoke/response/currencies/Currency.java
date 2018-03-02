package com.api.example.fixture.invoke.response.currencies;

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
        "localizedNames",
        "displaySymbol",
        "decimalPlaces",
        "isBaseCurrency",
        "isActive"
})
public class Currency {

    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("displaySymbol")
    private String displaySymbol;
    @JsonProperty("decimalPlaces")
    private Integer decimalPlaces;
    @JsonProperty("isBaseCurrency")
    private Boolean isBaseCurrency;
    @JsonProperty("isActive")
    private Boolean isActive;
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

    /**
     * @return The displaySymbol
     */
    @JsonProperty("displaySymbol")
    public String getDisplaySymbol() {
        return displaySymbol;
    }

    /**
     * @param displaySymbol The displaySymbol
     */
    @JsonProperty("displaySymbol")
    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    /**
     * @return The decimalPlaces
     */
    @JsonProperty("decimalPlaces")
    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    /**
     * @param decimalPlaces The decimalPlaces
     */
    @JsonProperty("decimalPlaces")
    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    /**
     * @return The isBaseCurrency
     */
    @JsonProperty("isBaseCurrency")
    public Boolean getIsBaseCurrency() {
        return isBaseCurrency;
    }

    /**
     * @param isBaseCurrency The isBaseCurrency
     */
    @JsonProperty("isBaseCurrency")
    public void setIsBaseCurrency(Boolean isBaseCurrency) {
        this.isBaseCurrency = isBaseCurrency;
    }

    /**
     * @return The isActive
     */
    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive The isActive
     */
    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
