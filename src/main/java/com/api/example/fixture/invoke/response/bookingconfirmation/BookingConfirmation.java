package com.api.example.fixture.invoke.response.bookingconfirmation;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingReference",
        "bookingStatus",
        "href"
})
public class BookingConfirmation {

    @JsonProperty("bookingReference")
    private String bookingReference;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("href")
    private String href;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The bookingReference
     */
    @JsonProperty("bookingReference")
    public String getBookingReference() {
        return bookingReference;
    }

    /**
     * @param bookingReference The bookingReference
     */
    @JsonProperty("bookingReference")
    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    /**
     * @return The bookingStatus
     */
    @JsonProperty("bookingStatus")
    public String getBookingStatus() {
        return bookingStatus;
    }

    /**
     * @param bookingStatus The bookingStatus
     */
    @JsonProperty("bookingStatus")
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * @return The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * @param href The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
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