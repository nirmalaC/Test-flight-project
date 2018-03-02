package com.api.example.fixture.invoke.response.traveller;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "travellers"
})
@Builder
public class Travellers implements IRequestBody {

    @JsonProperty("travellers")
    private List<Traveller> travellers = new ArrayList<Traveller>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The travellers
     */
    @JsonProperty("travellers")
    public List<Traveller> getTravellers() {
        return travellers;
    }

    /**
     * @param travellers The travellers
     */
    @JsonProperty("travellers")
    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
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
