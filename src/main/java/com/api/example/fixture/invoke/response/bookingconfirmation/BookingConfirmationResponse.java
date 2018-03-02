package com.api.example.fixture.invoke.response.bookingconfirmation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "bookingConfirmation",
        "additionalInformation"
})
public class BookingConfirmationResponse implements IResponse {

    @JsonProperty("bookingConfirmation")
    private BookingConfirmation bookingConfirmation;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = new ArrayList<AdditionalInformation>();

    /**
     * @return The bookingConfirmation
     */
    @JsonProperty("bookingConfirmation")
    public BookingConfirmation getBookingConfirmation() {
        return bookingConfirmation;
    }

    /**
     * @param bookingConfirmation The bookingConfirmation
     */
    @JsonProperty("bookingConfirmation")
    public void setBookingConfirmation(BookingConfirmation bookingConfirmation) {
        this.bookingConfirmation = bookingConfirmation;
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

}
