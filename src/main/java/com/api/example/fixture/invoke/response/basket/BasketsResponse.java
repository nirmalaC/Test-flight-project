package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "basket",
        "additionalInformations"
})
@ToString
public class BasketsResponse implements IResponse {

    @JsonProperty("basket")
    private Basket basket;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The basket
     */
    @JsonProperty("basket")
    public Basket getBasket() {
        return basket;
    }

    /**
     * @param basket The basket
     */
    @JsonProperty("basket")
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    /**
     * @return The additionalInformations
     */
    @JsonProperty("additionalInformations")
    public List<AdditionalInformation> getAdditionalInformations() {
        return additionalInformation;
    }

    /**
     * @param additionalInformations The additionalInformations
     */
    @JsonProperty("additionalInformation")
    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
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
