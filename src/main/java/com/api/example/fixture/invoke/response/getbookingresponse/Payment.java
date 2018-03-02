
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
    "type",
    "transactionId",
    "externalReference",
    "transactionType",
    "creditFileReference",
    "paymentTypeReference",
    "comment",
    "amount",
    "exchangeRate",
    "exchangeValue"
})
public class Payment {

    @JsonProperty("type")
    private String type;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("externalReference")
    private String externalReference;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("creditFileReference")
    private String creditFileReference;
    @JsonProperty("paymentTypeReference")
    private String paymentTypeReference;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("exchangeRate")
    private Integer exchangeRate;
    @JsonProperty("exchangeValue")
    private ExchangeValue exchangeValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("externalReference")
    public String getExternalReference() {
        return externalReference;
    }

    @JsonProperty("externalReference")
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("creditFileReference")
    public String getCreditFileReference() {
        return creditFileReference;
    }

    @JsonProperty("creditFileReference")
    public void setCreditFileReference(String creditFileReference) {
        this.creditFileReference = creditFileReference;
    }

    @JsonProperty("paymentTypeReference")
    public String getPaymentTypeReference() {
        return paymentTypeReference;
    }

    @JsonProperty("paymentTypeReference")
    public void setPaymentTypeReference(String paymentTypeReference) {
        this.paymentTypeReference = paymentTypeReference;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @JsonProperty("exchangeRate")
    public Integer getExchangeRate() {
        return exchangeRate;
    }

    @JsonProperty("exchangeRate")
    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @JsonProperty("exchangeValue")
    public ExchangeValue getExchangeValue() {
        return exchangeValue;
    }

    @JsonProperty("exchangeValue")
    public void setExchangeValue(ExchangeValue exchangeValue) {
        this.exchangeValue = exchangeValue;
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
