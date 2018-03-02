package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "restURI",
        "referenceNumber",
        "date",
        "status",
        "outboundSectorName",
        "currency",
        "totalAmount"
})
public class RelatedBooking {

    @JsonProperty("restURI")
    private String restURI;
    @JsonProperty("referenceNumber")
    private String referenceNumber;
    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("outboundSectorName")
    private String outboundSectorName;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("totalAmount")
    private String totalAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The restURI
     */
    @JsonProperty("restURI")
    public String getRestURI() {
        return restURI;
    }

    /**
     * @param restURI The restURI
     */
    @JsonProperty("restURI")
    public void setRestURI(String restURI) {
        this.restURI = restURI;
    }

    /**
     * @return The referenceNumber
     */
    @JsonProperty("referenceNumber")
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * @param referenceNumber The referenceNumber
     */
    @JsonProperty("referenceNumber")
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * @return The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
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
     * @return The outboundSectorName
     */
    @JsonProperty("outboundSectorName")
    public String getOutboundSectorName() {
        return outboundSectorName;
    }

    /**
     * @param outboundSectorName The outboundSectorName
     */
    @JsonProperty("outboundSectorName")
    public void setOutboundSectorName(String outboundSectorName) {
        this.outboundSectorName = outboundSectorName;
    }

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The totalAmount
     */
    @JsonProperty("totalAmount")
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount The totalAmount
     */
    @JsonProperty("totalAmount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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
