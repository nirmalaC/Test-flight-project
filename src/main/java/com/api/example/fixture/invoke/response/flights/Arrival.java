package com.api.example.fixture.invoke.response.flights;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "airportCode",
        "airportName",
        "date",
        "marketGroup",
        "terminal"
})
public class Arrival {

    @JsonProperty("airportCode")
    private String airportCode;
    @JsonProperty("airportName")
    private String airportName;
    @JsonProperty("date")
    private String date;
    @JsonProperty("marketGroup")
    private String marketGroup;
    @JsonProperty("terminal")
    private String terminal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The airportCode
     */
    @JsonProperty("airportCode")
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * @param airportCode The airportCode
     */
    @JsonProperty("airportCode")
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    /**
     * @return The airportName
     */
    @JsonProperty("airportName")
    public String getAirportName() {
        return airportName;
    }

    /**
     * @param airportName The airportName
     */
    @JsonProperty("airportName")
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    /**
     * @return The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
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
