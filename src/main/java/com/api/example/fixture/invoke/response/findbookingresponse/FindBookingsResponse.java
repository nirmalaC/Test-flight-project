package com.api.example.fixture.invoke.response.findbookingresponse;

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
        "bookings",
        "availableSortFields",
        "additionalInformation"
})
public class FindBookingsResponse implements IResponse {

    @JsonProperty("bookings")
    private List<Booking> bookings = new ArrayList<Booking>();
    @JsonProperty("availableSortFields")
    private List<AvailableSortField> availableSortFields = new ArrayList<AvailableSortField>();
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = new ArrayList<AdditionalInformation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The bookings
     */
    @JsonProperty("bookings")
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * @param bookings The bookings
     */
    @JsonProperty("bookings")
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * @return The availableSortFields
     */
    @JsonProperty("availableSortFields")
    public List<AvailableSortField> getAvailableSortFields() {
        return availableSortFields;
    }

    /**
     * @param availableSortFields The availableSortFields
     */
    @JsonProperty("availableSortFields")
    public void setAvailableSortFields(List<AvailableSortField> availableSortFields) {
        this.availableSortFields = availableSortFields;
    }

    /**
     * @return The additionalInformation
     */
    @JsonProperty("additionalInformation")
    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation The additionalInformation
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
