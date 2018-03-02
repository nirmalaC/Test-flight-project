package com.api.example.fixture.invoke.response.traveller;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
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
        "additionalInformations"
})
public class TravellerUpdateResponse implements IResponse {

    @JsonProperty("additionalInformations")
    private List<AdditionalInformation> additionalInformations = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
