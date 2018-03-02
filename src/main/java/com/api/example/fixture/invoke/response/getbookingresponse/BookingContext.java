
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedFunctions",
    "allowedDocuments",
    "booking"
})
//@Builder
public class BookingContext {

    @JsonProperty("allowedFunctions")
    private List<String> allowedFunctions = null;
    @JsonProperty("allowedDocuments")
    private List<String> allowedDocuments = null;
    @JsonProperty("booking")
    private Booking booking;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("allowedFunctions")
    public List<String> getAllowedFunctions() {
        return allowedFunctions;
    }

    @JsonProperty("allowedFunctions")
    public void setAllowedFunctions(List<String> allowedFunctions) {
        this.allowedFunctions = allowedFunctions;
    }

    @JsonProperty("allowedDocuments")
    public List<String> getAllowedDocuments() {
        return allowedDocuments;
    }

    @JsonProperty("allowedDocuments")
    public void setAllowedDocuments(List<String> allowedDocuments) {
        this.allowedDocuments = allowedDocuments;
    }

    @JsonProperty("booking")
    public Booking getBooking() {
        return booking;
    }

    @JsonProperty("booking")
    public void setBooking(Booking booking) {
        this.booking = booking;
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
