
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
    "corporateId",
    "officeId",
    "dealId",
    "discountTier",
    "iataCode",
    "ejContact"
})
public class CorporateDetails {

    @JsonProperty("corporateId")
    private String corporateId;
    @JsonProperty("officeId")
    private String officeId;
    @JsonProperty("dealId")
    private String dealId;
    @JsonProperty("discountTier")
    private String discountTier;
    @JsonProperty("iataCode")
    private String iataCode;
    @JsonProperty("ejContact")
    private String ejContact;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("corporateId")
    public String getCorporateId() {
        return corporateId;
    }

    @JsonProperty("corporateId")
    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    @JsonProperty("officeId")
    public String getOfficeId() {
        return officeId;
    }

    @JsonProperty("officeId")
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    @JsonProperty("dealId")
    public String getDealId() {
        return dealId;
    }

    @JsonProperty("dealId")
    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    @JsonProperty("discountTier")
    public String getDiscountTier() {
        return discountTier;
    }

    @JsonProperty("discountTier")
    public void setDiscountTier(String discountTier) {
        this.discountTier = discountTier;
    }

    @JsonProperty("iataCode")
    public String getIataCode() {
        return iataCode;
    }

    @JsonProperty("iataCode")
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @JsonProperty("ejContact")
    public String getEjContact() {
        return ejContact;
    }

    @JsonProperty("ejContact")
    public void setEjContact(String ejContact) {
        this.ejContact = ejContact;
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
