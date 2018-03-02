package com.api.example.fixture.invoke.response.findbookingresponse;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "referenceNumber",
        "bookingDate",
        "bookingStatus",
        "outboundSectorCode",
        "outboundSectorName",
        "outboundDepartureDate",
        "customerTitle",
        "customerFirstName",
        "customerLastName",
        "customerEmail",
        "customerContactNumber",
        "customerPostalCode",
        "currency",
        "totalAmount"
})
public class Booking {

    @JsonProperty("referenceNumber")
    private String referenceNumber;
    @JsonProperty("bookingDate")
    private String bookingDate;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("outboundSectorCode")
    private String outboundSectorCode;
    @JsonProperty("outboundSectorName")
    private String outboundSectorName;
    @JsonProperty("outboundDepartureDate")
    private String outboundDepartureDate;
    @JsonProperty("customerTitle")
    private String customerTitle;
    @JsonProperty("customerFirstName")
    private String customerFirstName;
    @JsonProperty("customerLastName")
    private String customerLastName;
    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonProperty("customerContactNumber")
    private String customerContactNumber;
    @JsonProperty("customerPostalCode")
    private String customerPostalCode;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The referenceNumber
     */
    @JsonProperty("referenceNumber")
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * @param referenceNumber The referenceNumber
     */
    @JsonProperty("referenceNumber")
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * @return The bookingDate
     */
    @JsonProperty("bookingDate")
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate The bookingDate
     */
    @JsonProperty("bookingDate")
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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
     * @return The outboundSectorCode
     */
    @JsonProperty("outboundSectorCode")
    public String getOutboundSectorCode() {
        return outboundSectorCode;
    }

    /**
     * @param outboundSectorCode The outboundSectorCode
     */
    @JsonProperty("outboundSectorCode")
    public void setOutboundSectorCode(String outboundSectorCode) {
        this.outboundSectorCode = outboundSectorCode;
    }

    /**
     * @return The outboundSectorName
     */
    @JsonProperty("outboundSectorName")
    public String getOutboundSectorName() {
        return outboundSectorName;
    }

    /**
     * @param outboundSectorName The outboundSectorName
     */
    @JsonProperty("outboundSectorName")
    public void setOutboundSectorName(String outboundSectorName) {
        this.outboundSectorName = outboundSectorName;
    }

    /**
     * @return The outboundDepartureDate
     */
    @JsonProperty("outboundDepartureDate")
    public String getOutboundDepartureDate() {
        return outboundDepartureDate;
    }

    /**
     * @param outboundDepartureDate The outboundDepartureDate
     */
    @JsonProperty("outboundDepartureDate")
    public void setOutboundDepartureDate(String outboundDepartureDate) {
        this.outboundDepartureDate = outboundDepartureDate;
    }

    /**
     * @return The customerTitle
     */
    @JsonProperty("customerTitle")
    public String getCustomerTitle() {
        return customerTitle;
    }

    /**
     * @param customerTitle The customerTitle
     */
    @JsonProperty("customerTitle")
    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    /**
     * @return The customerFirstName
     */
    @JsonProperty("customerFirstName")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * @param customerFirstName The customerFirstName
     */
    @JsonProperty("customerFirstName")
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * @return The customerLastName
     */
    @JsonProperty("customerLastName")
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * @param customerLastName The customerLastName
     */
    @JsonProperty("customerLastName")
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * @return The customerEmail
     */
    @JsonProperty("customerEmail")
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail The customerEmail
     */
    @JsonProperty("customerEmail")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return The customerContactNumber
     */
    @JsonProperty("customerContactNumber")
    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    /**
     * @param customerContactNumber The customerContactNumber
     */
    @JsonProperty("customerContactNumber")
    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    /**
     * @return The customerPostalCode
     */
    @JsonProperty("customerPostalCode")
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     * @param customerPostalCode The customerPostalCode
     */
    @JsonProperty("customerPostalCode")
    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The totalAmount
     */
    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount The totalAmount
     */
    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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
