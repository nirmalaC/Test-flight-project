package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "name",
        "phoneNumber",
        "email",
        "passengerType",
        "nifNumber",
        "ejPlusCardNumber"
})
public class PassengerDetails {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("passengerType")
    private String passengerType;
    @JsonProperty("nifNumber")
    private String nifNumber;
    @JsonProperty("ejPlusCardNumber")
    private String ejPlusCardNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The name
     */
    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return The phoneNumber
     */
    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber The phoneNumber
     */
    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The passengerType
     */
    @JsonProperty("passengerType")
    public String getPassengerType() {
        return passengerType;
    }

    /**
     * @param passengerType The passengerType
     */
    @JsonProperty("passengerType")
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    /**
     * @return The nifNumber
     */
    @JsonProperty("nifNumber")
    public String getNifNumber() {
        return nifNumber;
    }

    /**
     * @param nifNumber The nifNumber
     */
    @JsonProperty("nifNumber")
    public void setNifNumber(String nifNumber) {
        this.nifNumber = nifNumber;
    }

    /**
     * @return The ejPlusCardNumber
     */
    @JsonProperty("ejPlusCardNumber")
    public String getEjPlusCardNumber() {
        return ejPlusCardNumber;
    }

    /**
     * @param ejPlusCardNumber The ejPlusCardNumber
     */
    @JsonProperty("ejPlusCardNumber")
    public void setEjPlusCardNumber(String ejPlusCardNumber) {
        this.ejPlusCardNumber = ejPlusCardNumber;
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
