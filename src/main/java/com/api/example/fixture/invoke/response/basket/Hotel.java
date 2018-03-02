package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
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
    private List<Room> room = new ArrayList<Room>();
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

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The bundleCode
     */
    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    /**
     * @param bundleCode The bundleCode
     */
    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    /**
     * @return The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The pricing
     */
    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    /**
     * @param pricing The pricing
     */
    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * @return The hotelAddress
     */
    @JsonProperty("hotelAddress")
    public HotelAddress getHotelAddress() {
        return hotelAddress;
    }

    /**
     * @param hotelAddress The hotelAddress
     */
    @JsonProperty("hotelAddress")
    public void setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    /**
     * @return The room
     */
    @JsonProperty("room")
    public List<Room> getRoom() {
        return room;
    }

    /**
     * @param room The room
     */
    @JsonProperty("room")
    public void setRoom(List<Room> room) {
        this.room = room;
    }

    /**
     * @return The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The checkInDate
     */
    @JsonProperty("checkInDate")
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate The checkInDate
     */
    @JsonProperty("checkInDate")
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return The checkoutDate
     */
    @JsonProperty("checkoutDate")
    public String getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutDate The checkoutDate
     */
    @JsonProperty("checkoutDate")
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

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
     * @return The leadPassenger
     */
    @JsonProperty("leadPassenger")
    public String getLeadPassenger() {
        return leadPassenger;
    }

    /**
     * @param leadPassenger The leadPassenger
     */
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
