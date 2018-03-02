
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.IResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bookingContext",
    "additionalInformation"
})
//@Builder
//@Data
public class GetBookingResponse implements IResponse {

    @JsonProperty("bookingContext")
    private BookingContext bookingContext;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bookingContext")
    public BookingContext getBookingContext() {
        return bookingContext;
    }

    @JsonProperty("bookingContext")
    public void setBookingContext(BookingContext bookingContext) {
        this.bookingContext = bookingContext;
    }

    @JsonProperty("additionalInformation")
    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

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
