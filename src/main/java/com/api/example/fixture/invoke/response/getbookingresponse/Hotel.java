
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "bundleCode",
    "code",
    "name",
    "description",
    "quantity",
    "pricing",
    "hotelAddress",
    "room",
    "phone",
    "checkInDate",
    "checkoutDate",
    "bookingReference",
    "leadPassenger"
})
public class Hotel {

    @JsonProperty("type")
    private String type;
    @JsonProperty("bundleCode")
    private String bundleCode;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("pricing")
    private Pricing pricing;
    @JsonProperty("hotelAddress")
    private HotelAddress hotelAddress;
    @JsonProperty("room")
    private List<Room> room = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("checkInDate")
    private String checkInDate;
    @JsonProperty("checkoutDate")
    private String checkoutDate;
    @JsonProperty("bookingReference")
    private String bookingReference;
    @JsonProperty("leadPassenger")
    private String leadPassenger;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("hotelAddress")
    public HotelAddress getHotelAddress() {
        return hotelAddress;
    }

    @JsonProperty("hotelAddress")
    public void setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @JsonProperty("room")
    public List<Room> getRoom() {
        return room;
    }

    @JsonProperty("room")
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("checkInDate")
    public String getCheckInDate() {
        return checkInDate;
    }

    @JsonProperty("checkInDate")
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    @JsonProperty("checkoutDate")
    public String getCheckoutDate() {
        return checkoutDate;
    }

    @JsonProperty("checkoutDate")
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @JsonProperty("bookingReference")
    public String getBookingReference() {
        return bookingReference;
    }

    @JsonProperty("bookingReference")
    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    @JsonProperty("leadPassenger")
    public String getLeadPassenger() {
        return leadPassenger;
    }

    @JsonProperty("leadPassenger")
    public void setLeadPassenger(String leadPassenger) {
        this.leadPassenger = leadPassenger;
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
