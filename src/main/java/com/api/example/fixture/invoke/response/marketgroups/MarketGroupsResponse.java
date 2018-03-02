package com.api.example.fixture.invoke.response.marketgroups;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
import com.api.example.fixture.invoke.response.common.AdditionalInformation;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "marketGroups",
        "additionalInformations"
})
public class MarketGroupsResponse implements IResponse {

    @JsonProperty("marketGroups")
    private List<MarketGroup> marketGroups = new ArrayList<MarketGroup>();
    @JsonProperty("additionalInformations")
    private List<AdditionalInformation> additionalInformations = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The marketGroups
     */
    @JsonProperty("marketGroups")
    public List<MarketGroup> getMarketGroups() {
        return marketGroups;
    }

    /**
     * @param marketGroups The marketGroups
     */
    @JsonProperty("marketGroups")
    public void setMarketGroups(List<MarketGroup> marketGroups) {
        this.marketGroups = marketGroups;
    }

    /**
     * @return The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public List<AdditionalInformation> getAdditionalInformations() {
        return additionalInformations;
    }

    /**
     * @param additionalInformations The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public void setAdditionalInformations(List<AdditionalInformation> additionalInformations) {
        this.additionalInformations = additionalInformations;
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
