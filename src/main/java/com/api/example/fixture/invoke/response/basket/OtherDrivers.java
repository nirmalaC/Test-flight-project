package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "driverName",
        "age",
        "countryOfResidence",
        "drivingLicenceNumber",
        "drivingLicenceIssuingCountry",
        "drivingLicenceExpiryDate"
})
public class OtherDrivers {

    @JsonProperty("driverName")
    private DriverName driverName;
    @JsonProperty("age")
    private String age;
    @JsonProperty("countryOfResidence")
    private String countryOfResidence;
    @JsonProperty("drivingLicenceNumber")
    private String drivingLicenceNumber;
    @JsonProperty("drivingLicenceIssuingCountry")
    private String drivingLicenceIssuingCountry;
    @JsonProperty("drivingLicenceExpiryDate")
    private String drivingLicenceExpiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The driverName
     */
    @JsonProperty("driverName")
    public DriverName getDriverName() {
        return driverName;
    }

    /**
     * @param driverName The driverName
     */
    @JsonProperty("driverName")
    public void setDriverName(DriverName driverName) {
        this.driverName = driverName;
    }

    /**
     * @return The age
     */
    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    /**
     * @param age The age
     */
    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return The countryOfResidence
     */
    @JsonProperty("countryOfResidence")
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * @param countryOfResidence The countryOfResidence
     */
    @JsonProperty("countryOfResidence")
    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    /**
     * @return The drivingLicenceNumber
     */
    @JsonProperty("drivingLicenceNumber")
    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    /**
     * @param drivingLicenceNumber The drivingLicenceNumber
     */
    @JsonProperty("drivingLicenceNumber")
    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    /**
     * @return The drivingLicenceIssuingCountry
     */
    @JsonProperty("drivingLicenceIssuingCountry")
    public String getDrivingLicenceIssuingCountry() {
        return drivingLicenceIssuingCountry;
    }

    /**
     * @param drivingLicenceIssuingCountry The drivingLicenceIssuingCountry
     */
    @JsonProperty("drivingLicenceIssuingCountry")
    public void setDrivingLicenceIssuingCountry(String drivingLicenceIssuingCountry) {
        this.drivingLicenceIssuingCountry = drivingLicenceIssuingCountry;
    }

    /**
     * @return The drivingLicenceExpiryDate
     */
    @JsonProperty("drivingLicenceExpiryDate")
    public String getDrivingLicenceExpiryDate() {
        return drivingLicenceExpiryDate;
    }

    /**
     * @param drivingLicenceExpiryDate The drivingLicenceExpiryDate
     */
    @JsonProperty("drivingLicenceExpiryDate")
    public void setDrivingLicenceExpiryDate(String drivingLicenceExpiryDate) {
        this.drivingLicenceExpiryDate = drivingLicenceExpiryDate;
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
