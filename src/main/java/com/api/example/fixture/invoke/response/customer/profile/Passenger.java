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
        "code",
        "type",
        "title",
        "firstName",
        "lastName",
        "email",
        "ejPlusCardNumber",
        "nifNumber",
        "flightClubId",
        "flightClubExpiryDate",
        "identityDocuments",
        "savedSSRs"
})
public class Passenger {

    @JsonProperty("code")
    private String code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("ejPlusCardNumber")
    private String ejPlusCardNumber;
    @JsonProperty("nifNumber")
    private String nifNumber;
    @JsonProperty("flightClubId")
    private String flightClubId;
    @JsonProperty("flightClubExpiryDate")
    private String flightClubExpiryDate;
    @JsonProperty("identityDocuments")
    private List<IdentityDocument> identityDocuments = new ArrayList<IdentityDocument>();
    @JsonProperty("savedSSRs")
    private SavedSSRs savedSSRs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The identityDocuments
     */
    @JsonProperty("identityDocuments")
    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    /**
     * @param identityDocuments The identityDocuments
     */
    @JsonProperty("identityDocuments")
    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }

    /**
     * @return The savedSSRs
     */
    @JsonProperty("savedSSRs")
    public SavedSSRs getSavedSSRs() {
        return savedSSRs;
    }

    /**
     * @param savedSSRs The savedSSRs
     */
    @JsonProperty("savedSSRs")
    public void setSavedSSRs(SavedSSRs savedSSRs) {
        this.savedSSRs = savedSSRs;
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
