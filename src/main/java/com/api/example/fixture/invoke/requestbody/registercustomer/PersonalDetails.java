package com.api.example.fixture.invoke.requestbody.registercustomer;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "password",
        "age",
        "title",
        "firstName",
        "lastName",
        "ejPlusCardNumber",
        "nifNumber",
        "phoneNumber",
        "alternativePhoneNumber",
        "flightClubId",
        "flightClubExpiryDate",
        "keyDates"
})
@Builder
public class PersonalDetails {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("ejPlusCardNumber")
    private String ejPlusCardNumber;
    @JsonProperty("nifNumber")
    private String nifNumber;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("alternativePhoneNumber")
    private String alternativePhoneNumber;
    @JsonProperty("flightClubId")
    private String flightClubId;
    @JsonProperty("flightClubExpiryDate")
    private String flightClubExpiryDate;
    @JsonProperty("keyDates")
    private List<KeyDate> keyDates = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The password
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The age
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * @param age The age
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The firstName
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The firstName
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The lastName
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The lastName
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return The alternativePhoneNumber
     */
    @JsonProperty("alternativePhoneNumber")
    public String getAlternativePhoneNumber() {
        return alternativePhoneNumber;
    }

    /**
     * @param alternativePhoneNumber The alternativePhoneNumber
     */
    @JsonProperty("alternativePhoneNumber")
    public void setAlternativePhoneNumber(String alternativePhoneNumber) {
        this.alternativePhoneNumber = alternativePhoneNumber;
    }

    /**
     * @return The flightClubId
     */
    @JsonProperty("flightClubId")
    public String getFlightClubId() {
        return flightClubId;
    }

    /**
     * @param flightClubId The flightClubId
     */
    @JsonProperty("flightClubId")
    public void setFlightClubId(String flightClubId) {
        this.flightClubId = flightClubId;
    }

    /**
     * @return The flightClubExpiryDate
     */
    @JsonProperty("flightClubExpiryDate")
    public String getFlightClubExpiryDate() {
        return flightClubExpiryDate;
    }

    /**
     * @param flightClubExpiryDate The flightClubExpiryDate
     */
    @JsonProperty("flightClubExpiryDate")
    public void setFlightClubExpiryDate(String flightClubExpiryDate) {
        this.flightClubExpiryDate = flightClubExpiryDate;
    }

    /**
     * @return The keyDates
     */
    @JsonProperty("keyDates")
    public List<KeyDate> getKeyDates() {
        return keyDates;
    }

    /**
     * @param keyDates The keyDates
     */
    @JsonProperty("keyDates")
    public void setKeyDates(List<KeyDate> keyDates) {
        this.keyDates = keyDates;
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
