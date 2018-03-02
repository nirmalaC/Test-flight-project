
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bookingReference",
    "bookingDateTime",
    "bookingLanguage",
    "defaultCardType",
    "bookingStatus",
    "bookingType",
    "bookingReason",
    "bookingCurrency",
    "channel",
    "employeeNumber",
    "agentId",
    "outbounds",
    "inbounds",
    "corporateDetails",
    "carHires",
    "travelInsurances",
    "hotels",
    "payments",
    "bookingContact",
    "otherBookingInfo",
    "comments",
    "priceSummary"
})
//@Builder
public class Booking {

    @JsonProperty("bookingReference")
    private String bookingReference;
    @JsonProperty("bookingDateTime")
    private String bookingDateTime;
    @JsonProperty("bookingLanguage")
    private String bookingLanguage;
    @JsonProperty("defaultCardType")
    private String defaultCardType;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("bookingType")
    private String bookingType;
    @JsonProperty("bookingReason")
    private String bookingReason;
    @JsonProperty("bookingCurrency")
    private BookingCurrency bookingCurrency;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("employeeNumber")
    private String employeeNumber;
    @JsonProperty("agentId")
    private String agentId;
    @JsonProperty("outbounds")
    private List<Outbound> outbounds = null;
    @JsonProperty("inbounds")
    private List<Inbound> inbounds = null;
    @JsonProperty("corporateDetails")
    private CorporateDetails corporateDetails;
    @JsonProperty("carHires")
    private List<CarHire> carHires = null;
    @JsonProperty("travelInsurances")
    private List<TravelInsurance> travelInsurances = null;
    @JsonProperty("hotels")
    private List<Hotel> hotels = null;
    @JsonProperty("payments")
    private List<Payment> payments = null;
    @JsonProperty("bookingContact")
    private BookingContact bookingContact;
    @JsonProperty("otherBookingInfo")
    private List<OtherBookingInfo> otherBookingInfo = null;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("priceSummary")
    private PriceSummary priceSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bookingReference")
    public String getBookingReference() {
        return bookingReference;
    }

    @JsonProperty("bookingReference")
    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    @JsonProperty("bookingDateTime")
    public String getBookingDateTime() {
        return bookingDateTime;
    }

    @JsonProperty("bookingDateTime")
    public void setBookingDateTime(String bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    @JsonProperty("bookingLanguage")
    public String getBookingLanguage() {
        return bookingLanguage;
    }

    @JsonProperty("bookingLanguage")
    public void setBookingLanguage(String bookingLanguage) {
        this.bookingLanguage = bookingLanguage;
    }

    @JsonProperty("defaultCardType")
    public String getDefaultCardType() {
        return defaultCardType;
    }

    @JsonProperty("defaultCardType")
    public void setDefaultCardType(String defaultCardType) {
        this.defaultCardType = defaultCardType;
    }

    @JsonProperty("bookingStatus")
    public String getBookingStatus() {
        return bookingStatus;
    }

    @JsonProperty("bookingStatus")
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @JsonProperty("bookingType")
    public String getBookingType() {
        return bookingType;
    }

    @JsonProperty("bookingType")
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    @JsonProperty("bookingReason")
    public String getBookingReason() {
        return bookingReason;
    }

    @JsonProperty("bookingReason")
    public void setBookingReason(String bookingReason) {
        this.bookingReason = bookingReason;
    }

    @JsonProperty("bookingCurrency")
    public BookingCurrency getBookingCurrency() {
        return bookingCurrency;
    }

    @JsonProperty("bookingCurrency")
    public void setBookingCurrency(BookingCurrency bookingCurrency) {
        this.bookingCurrency = bookingCurrency;
    }

    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    @JsonProperty("employeeNumber")
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @JsonProperty("employeeNumber")
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @JsonProperty("agentId")
    public String getAgentId() {
        return agentId;
    }

    @JsonProperty("agentId")
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @JsonProperty("outbounds")
    public List<Outbound> getOutbounds() {
        return outbounds;
    }

    @JsonProperty("outbounds")
    public void setOutbounds(List<Outbound> outbounds) {
        this.outbounds = outbounds;
    }

    @JsonProperty("inbounds")
    public List<Inbound> getInbounds() {
        return inbounds;
    }

    @JsonProperty("inbounds")
    public void setInbounds(List<Inbound> inbounds) {
        this.inbounds = inbounds;
    }

    @JsonProperty("corporateDetails")
    public CorporateDetails getCorporateDetails() {
        return corporateDetails;
    }

    @JsonProperty("corporateDetails")
    public void setCorporateDetails(CorporateDetails corporateDetails) {
        this.corporateDetails = corporateDetails;
    }

    @JsonProperty("carHires")
    public List<CarHire> getCarHires() {
        return carHires;
    }

    @JsonProperty("carHires")
    public void setCarHires(List<CarHire> carHires) {
        this.carHires = carHires;
    }

    @JsonProperty("travelInsurances")
    public List<TravelInsurance> getTravelInsurances() {
        return travelInsurances;
    }

    @JsonProperty("travelInsurances")
    public void setTravelInsurances(List<TravelInsurance> travelInsurances) {
        this.travelInsurances = travelInsurances;
    }

    @JsonProperty("hotels")
    public List<Hotel> getHotels() {
        return hotels;
    }

    @JsonProperty("hotels")
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @JsonProperty("payments")
    public List<Payment> getPayments() {
        return payments;
    }

    @JsonProperty("payments")
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @JsonProperty("bookingContact")
    public BookingContact getBookingContact() {
        return bookingContact;
    }

    @JsonProperty("bookingContact")
    public void setBookingContact(BookingContact bookingContact) {
        this.bookingContact = bookingContact;
    }

    @JsonProperty("otherBookingInfo")
    public List<OtherBookingInfo> getOtherBookingInfo() {
        return otherBookingInfo;
    }

    @JsonProperty("otherBookingInfo")
    public void setOtherBookingInfo(List<OtherBookingInfo> otherBookingInfo) {
        this.otherBookingInfo = otherBookingInfo;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("priceSummary")
    public PriceSummary getPriceSummary() {
        return priceSummary;
    }

    @JsonProperty("priceSummary")
    public void setPriceSummary(PriceSummary priceSummary) {
        this.priceSummary = priceSummary;
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
