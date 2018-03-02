package com.api.example.fixture.invoke.response.customer.identify;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "customerId",
        "title",
        "firstName",
        "lastName",
        "easyjetPlusCardNumber",
        "flightClubNumber",
        "email",
        "postcode",
        "countryName"
})
public class Customer {

    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("easyjetPlusCardNumber")
    private String easyjetPlusCardNumber;
    @JsonProperty("flightClubNumber")
    private String flightClubNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("countryName")
    private String countryName;
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
     * @return The easyjetPlusCardNumber
     */
    @JsonProperty("easyjetPlusCardNumber")
    public String getEasyjetPlusCardNumber() {
        return easyjetPlusCardNumber;
    }

    /**
     * @param easyjetPlusCardNumber The easyjetPlusCardNumber
     */
    @JsonProperty("easyjetPlusCardNumber")
    public void setEasyjetPlusCardNumber(String easyjetPlusCardNumber) {
        this.easyjetPlusCardNumber = easyjetPlusCardNumber;
    }

    /**
     * @return The flightClubNumber
     */
    @JsonProperty("flightClubNumber")
    public String getFlightClubNumber() {
        return flightClubNumber;
    }

    /**
     * @param flightClubNumber The flightClubNumber
     */
    @JsonProperty("flightClubNumber")
    public void setFlightClubNumber(String flightClubNumber) {
        this.flightClubNumber = flightClubNumber;
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
     * @return The postcode
     */
    @JsonProperty("postcode")
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode The postcode
     */
    @JsonProperty("postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return The countryName
     */
    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName The countryName
     */
    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
