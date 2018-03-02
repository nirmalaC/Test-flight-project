
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("passengerType")
    public String getPassengerType() {
        return passengerType;
    }

    @JsonProperty("passengerType")
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    @JsonProperty("nifNumber")
    public String getNifNumber() {
        return nifNumber;
    }

    @JsonProperty("nifNumber")
    public void setNifNumber(String nifNumber) {
        this.nifNumber = nifNumber;
    }

    @JsonProperty("ejPlusCardNumber")
    public String getEjPlusCardNumber() {
        return ejPlusCardNumber;
    }

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
