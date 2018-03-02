package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "insuredAddress",
        "insuredDOB",
        "policyType",
        "coverageArea",
        "quotePackId",
        "premiumAmountPaid"
})
public class TravelInsurancePolicy {

    @JsonProperty("insuredAddress")
    private InsuredAddress insuredAddress;
    @JsonProperty("insuredDOB")
    private String insuredDOB;
    @JsonProperty("policyType")
    private String policyType;
    @JsonProperty("coverageArea")
    private String coverageArea;
    @JsonProperty("quotePackId")
    private String quotePackId;
    @JsonProperty("premiumAmountPaid")
    private PremiumAmountPaid premiumAmountPaid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The insuredAddress
     */
    @JsonProperty("insuredAddress")
    public InsuredAddress getInsuredAddress() {
        return insuredAddress;
    }

    /**
     * @param insuredAddress The insuredAddress
     */
    @JsonProperty("insuredAddress")
    public void setInsuredAddress(InsuredAddress insuredAddress) {
        this.insuredAddress = insuredAddress;
    }

    /**
     * @return The insuredDOB
     */
    @JsonProperty("insuredDOB")
    public String getInsuredDOB() {
        return insuredDOB;
    }

    /**
     * @param insuredDOB The insuredDOB
     */
    @JsonProperty("insuredDOB")
    public void setInsuredDOB(String insuredDOB) {
        this.insuredDOB = insuredDOB;
    }

    /**
     * @return The policyType
     */
    @JsonProperty("policyType")
    public String getPolicyType() {
        return policyType;
    }

    /**
     * @param policyType The policyType
     */
    @JsonProperty("policyType")
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    /**
     * @return The coverageArea
     */
    @JsonProperty("coverageArea")
    public String getCoverageArea() {
        return coverageArea;
    }

    /**
     * @param coverageArea The coverageArea
     */
    @JsonProperty("coverageArea")
    public void setCoverageArea(String coverageArea) {
        this.coverageArea = coverageArea;
    }

    /**
     * @return The quotePackId
     */
    @JsonProperty("quotePackId")
    public String getQuotePackId() {
        return quotePackId;
    }

    /**
     * @param quotePackId The quotePackId
     */
    @JsonProperty("quotePackId")
    public void setQuotePackId(String quotePackId) {
        this.quotePackId = quotePackId;
    }

    /**
     * @return The premiumAmountPaid
     */
    @JsonProperty("premiumAmountPaid")
    public PremiumAmountPaid getPremiumAmountPaid() {
        return premiumAmountPaid;
    }

    /**
     * @param premiumAmountPaid The premiumAmountPaid
     */
    @JsonProperty("premiumAmountPaid")
    public void setPremiumAmountPaid(PremiumAmountPaid premiumAmountPaid) {
        this.premiumAmountPaid = premiumAmountPaid;
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
