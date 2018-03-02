package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "address",
        "emailAddress",
        "phone",
        "openingTime",
        "closingTime",
        "faxNumber",
        "stationCode",
        "stationName"
})
public class CheckOutStation {

    @JsonProperty("address")
    private Address address;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("openingTime")
    private String openingTime;
    @JsonProperty("closingTime")
    private String closingTime;
    @JsonProperty("faxNumber")
    private String faxNumber;
    @JsonProperty("stationCode")
    private String stationCode;
    @JsonProperty("stationName")
    private String stationName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The address
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The emailAddress
     */
    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress The emailAddress
     */
    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
     * @return The openingTime
     */
    @JsonProperty("openingTime")
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * @param openingTime The openingTime
     */
    @JsonProperty("openingTime")
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * @return The closingTime
     */
    @JsonProperty("closingTime")
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * @param closingTime The closingTime
     */
    @JsonProperty("closingTime")
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * @return The faxNumber
     */
    @JsonProperty("faxNumber")
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * @param faxNumber The faxNumber
     */
    @JsonProperty("faxNumber")
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * @return The stationCode
     */
    @JsonProperty("stationCode")
    public String getStationCode() {
        return stationCode;
    }

    /**
     * @param stationCode The stationCode
     */
    @JsonProperty("stationCode")
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    /**
     * @return The stationName
     */
    @JsonProperty("stationName")
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName The stationName
     */
    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
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
