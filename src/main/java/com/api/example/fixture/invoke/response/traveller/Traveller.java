package com.api.example.fixture.invoke.response.traveller;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "travellerType",
        "relatedAdult",
        "passengerDetails",
        "age",
        "lead",
        "passengerAPIS",
        "specialRequests"
})
@Builder
public class Traveller {

    @JsonProperty("code")
    private String code;
    @JsonProperty("travellerType")
    private String travellerType;
    @JsonProperty("relatedAdult")
    private String relatedAdult;
    @JsonProperty("passengerDetails")
    private PassengerDetails passengerDetails;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("lead")
    private Boolean lead;
    @JsonProperty("passengerAPIS")
    private PassengerAPIS passengerAPIS;
    @JsonProperty("specialRequests")
    private SpecialRequests specialRequests;
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
     * @return The travellerType
     */
    @JsonProperty("travellerType")
    public String getTravellerType() {
        return travellerType;
    }

    /**
     * @param travellerType The travellerType
     */
    @JsonProperty("travellerType")
    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    /**
     * @return The relatedAdult
     */
    @JsonProperty("relatedAdult")
    public String getRelatedAdult() {
        return relatedAdult;
    }

    /**
     * @param relatedAdult The relatedAdult
     */
    @JsonProperty("relatedAdult")
    public void setRelatedAdult(String relatedAdult) {
        this.relatedAdult = relatedAdult;
    }

    /**
     * @return The passengerDetails
     */
    @JsonProperty("passengerDetails")
    public PassengerDetails getPassengerDetails() {
        return passengerDetails;
    }

    /**
     * @param passengerDetails The passengerDetails
     */
    @JsonProperty("passengerDetails")
    public void setPassengerDetails(PassengerDetails passengerDetails) {
        this.passengerDetails = passengerDetails;
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
     * @return The lead
     */
    @JsonProperty("lead")
    public Boolean getLead() {
        return lead;
    }

    /**
     * @param lead The lead
     */
    @JsonProperty("lead")
    public void setLead(Boolean lead) {
        this.lead = lead;
    }

    /**
     * @return The passengerAPIS
     */
    @JsonProperty("passengerAPIS")
    public PassengerAPIS getPassengerAPIS() {
        return passengerAPIS;
    }

    /**
     * @param passengerAPIS The passengerAPIS
     */
    @JsonProperty("passengerAPIS")
    public void setPassengerAPIS(PassengerAPIS passengerAPIS) {
        this.passengerAPIS = passengerAPIS;
    }

    /**
     * @return The specialRequests
     */
    @JsonProperty("specialRequests")
    public SpecialRequests getSpecialRequests() {
        return specialRequests;
    }

    /**
     * @param specialRequests The specialRequests
     */
    @JsonProperty("specialRequests")
    public void setSpecialRequests(SpecialRequests specialRequests) {
        this.specialRequests = specialRequests;
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
