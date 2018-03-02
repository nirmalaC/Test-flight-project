package com.api.example.fixture.invoke.requestbody.commitbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "paymentMethod",
        "paymentCode",
        "paymentAmount",
        "paymentCurrency",
        "savePaymentMethod",
        "token"
})
@Builder
public class PaymentMethod implements IRequestBody {

    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("paymentCode")
    private String paymentCode;
    @JsonProperty("paymentAmount")
    private Double paymentAmount;
    @JsonProperty("paymentCurrency")
    private String paymentCurrency;
    @JsonProperty("savePaymentMethod")
    private Boolean savePaymentMethod;
    @JsonProperty("token")
    private String token;

    /**
     * @return The paymentMethod
     */
    @JsonProperty("paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod The paymentMethod
     */
    @JsonProperty("paymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return The paymentCode
     */
    @JsonProperty("paymentCode")
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * @param paymentCode The paymentCode
     */
    @JsonProperty("paymentCode")
    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    /**
     * @return The paymentAmount
     */
    @JsonProperty("paymentAmount")
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount The paymentAmount
     */
    @JsonProperty("paymentAmount")
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return The paymentCurrency
     */
    @JsonProperty("paymentCurrency")
    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    /**
     * @param paymentCurrency The paymentCurrency
     */
    @JsonProperty("paymentCurrency")
    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    /**
     * @return The savePaymentMethod
     */
    @JsonProperty("savePaymentMethod")
    public Boolean getSavePaymentMethod() {
        return savePaymentMethod;
    }

    /**
     * @param savePaymentMethod The savePaymentMethod
     */
    @JsonProperty("savePaymentMethod")
    public void setSavePaymentMethod(Boolean savePaymentMethod) {
        this.savePaymentMethod = savePaymentMethod;
    }

    /**
     * @return The token
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * @param token The token
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }


}
