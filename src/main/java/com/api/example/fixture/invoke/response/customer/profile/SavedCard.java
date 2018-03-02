package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "type",
        "default",
        "validToMonth",
        "validToYear",
        "validFromMonth",
        "validFromYear",
        "lastFourDigits"
})
public class SavedCard {

    @JsonProperty("code")
    private String code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("default")
    private Boolean _default;
    @JsonProperty("validToMonth")
    private String validToMonth;
    @JsonProperty("validToYear")
    private String validToYear;
    @JsonProperty("validFromMonth")
    private String validFromMonth;
    @JsonProperty("validFromYear")
    private String validFromYear;
    @JsonProperty("lastFourDigits")
    private String lastFourDigits;
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
     * @return The _default
     */
    @JsonProperty("default")
    public Boolean getDefault() {
        return _default;
    }

    /**
     * @param _default The default
     */
    @JsonProperty("default")
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     * @return The validToMonth
     */
    @JsonProperty("validToMonth")
    public String getValidToMonth() {
        return validToMonth;
    }

    /**
     * @param validToMonth The validToMonth
     */
    @JsonProperty("validToMonth")
    public void setValidToMonth(String validToMonth) {
        this.validToMonth = validToMonth;
    }

    /**
     * @return The validToYear
     */
    @JsonProperty("validToYear")
    public String getValidToYear() {
        return validToYear;
    }

    /**
     * @param validToYear The validToYear
     */
    @JsonProperty("validToYear")
    public void setValidToYear(String validToYear) {
        this.validToYear = validToYear;
    }

    /**
     * @return The validFromMonth
     */
    @JsonProperty("validFromMonth")
    public String getValidFromMonth() {
        return validFromMonth;
    }

    /**
     * @param validFromMonth The validFromMonth
     */
    @JsonProperty("validFromMonth")
    public void setValidFromMonth(String validFromMonth) {
        this.validFromMonth = validFromMonth;
    }

    /**
     * @return The validFromYear
     */
    @JsonProperty("validFromYear")
    public String getValidFromYear() {
        return validFromYear;
    }

    /**
     * @param validFromYear The validFromYear
     */
    @JsonProperty("validFromYear")
    public void setValidFromYear(String validFromYear) {
        this.validFromYear = validFromYear;
    }

    /**
     * @return The lastFourDigits
     */
    @JsonProperty("lastFourDigits")
    public String getLastFourDigits() {
        return lastFourDigits;
    }

    /**
     * @param lastFourDigits The lastFourDigits
     */
    @JsonProperty("lastFourDigits")
    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
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
