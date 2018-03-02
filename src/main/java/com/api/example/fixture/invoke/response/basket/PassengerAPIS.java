package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "name",
        "dateOfBirth",
        "documentExpiryDate",
        "documentNumber",
        "documentType",
        "gender",
        "nationality",
        "countryOfIssue"
})
public class PassengerAPIS {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("documentExpiryDate")
    private String documentExpiryDate;
    @JsonProperty("documentNumber")
    private String documentNumber;
    @JsonProperty("documentType")
    private String documentType;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("countryOfIssue")
    private String countryOfIssue;
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
     * @return The dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth The dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return The documentExpiryDate
     */
    @JsonProperty("documentExpiryDate")
    public String getDocumentExpiryDate() {
        return documentExpiryDate;
    }

    /**
     * @param documentExpiryDate The documentExpiryDate
     */
    @JsonProperty("documentExpiryDate")
    public void setDocumentExpiryDate(String documentExpiryDate) {
        this.documentExpiryDate = documentExpiryDate;
    }

    /**
     * @return The documentNumber
     */
    @JsonProperty("documentNumber")
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber The documentNumber
     */
    @JsonProperty("documentNumber")
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     * @return The documentType
     */
    @JsonProperty("documentType")
    public String getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType The documentType
     */
    @JsonProperty("documentType")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * @return The gender
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return The nationality
     */
    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality The nationality
     */
    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return The countryOfIssue
     */
    @JsonProperty("countryOfIssue")
    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    /**
     * @param countryOfIssue The countryOfIssue
     */
    @JsonProperty("countryOfIssue")
    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
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
