package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "savedCards"
})
public class SavedPayments {

    @JsonProperty("savedCards")
    private List<SavedCard> savedCards = new ArrayList<SavedCard>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The savedCards
     */
    @JsonProperty("savedCards")
    public List<SavedCard> getSavedCards() {
        return savedCards;
    }

    /**
     * @param savedCards The savedCards
     */
    @JsonProperty("savedCards")
    public void setSavedCards(List<SavedCard> savedCards) {
        this.savedCards = savedCards;
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
