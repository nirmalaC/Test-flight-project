package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "customerId",
        "email",
        "status",
        "type",
        "group",
        "title",
        "firstName",
        "lastName",
        "ejPlusCardNumber",
        "nifNumber",
        "phoneNumber",
        "alternativePhoneNumber",
        "flightClubId",
        "flightClubExpiryDate",
        "employeeId",
        "employeeEmail",
        "keyDates"
})
public class PersonalDetails {

    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonProperty("group")
    private String group;
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
    @JsonProperty("employeeId")
    private String employeeId;
    @JsonProperty("employeeEmail")
    private String employeeEmail;
    @JsonProperty("keyDates")
    private List<KeyDate> keyDates = new ArrayList<KeyDate>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The customerId
     */
    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId The customerId
     */
    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

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
     * @return The group
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
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
     * @return The employeeId
     */
    @JsonProperty("employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId The employeeId
     */
    @JsonProperty("employeeId")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return The employeeEmail
     */
    @JsonProperty("employeeEmail")
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * @param employeeEmail The employeeEmail
     */
    @JsonProperty("employeeEmail")
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
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
