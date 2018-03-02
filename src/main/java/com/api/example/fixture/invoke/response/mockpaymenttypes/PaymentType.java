package com.api.example.fixture.invoke.response.mockpaymenttypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "allowedCurrencies",
        "allowedDaysTillDeparture",
        "allowedMarketCountryCode",
        "bankNameRequired",
        "cardHolderNameRequired",
        "cardNumberRequired",
        "code",
        "description",
        "isCreditCard",
        "issueNumberRequired",
        "issuers",
        "paymentMethod",
        "paymentMethodId",
        "securityCodeLength",
        "securityNumberRequired",
        "startDateRequired"
})
public class PaymentType {

    @JsonProperty("allowedCurrencies")
    private AllowedCurrencies allowedCurrencies;
    @JsonProperty("allowedDaysTillDeparture")
    private String allowedDaysTillDeparture;
    @JsonProperty("allowedMarketCountryCode")
    private String allowedMarketCountryCode;
    @JsonProperty("bankNameRequired")
    private String bankNameRequired;
    @JsonProperty("cardHolderNameRequired")
    private String cardHolderNameRequired;
    @JsonProperty("cardNumberRequired")
    private String cardNumberRequired;
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isCreditCard")
    private String isCreditCard;
    @JsonProperty("issueNumberRequired")
    private String issueNumberRequired;
    @JsonProperty("issuers")
    private String issuers;
    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("paymentMethodId")
    private String paymentMethodId;
    @JsonProperty("securityCodeLength")
    private String securityCodeLength;
    @JsonProperty("securityNumberRequired")
    private String securityNumberRequired;
    @JsonProperty("startDateRequired")
    private String startDateRequired;

    /**
     * @return The allowedCurrencies
     */
    @JsonProperty("allowedCurrencies")
    public AllowedCurrencies getAllowedCurrencies() {
        return allowedCurrencies;
    }

    /**
     * @param allowedCurrencies The allowedCurrencies
     */
    @JsonProperty("allowedCurrencies")
    public void setAllowedCurrencies(AllowedCurrencies allowedCurrencies) {
        this.allowedCurrencies = allowedCurrencies;
    }

    /**
     * @return The allowedDaysTillDeparture
     */
    @JsonProperty("allowedDaysTillDeparture")
    public String getAllowedDaysTillDeparture() {
        return allowedDaysTillDeparture;
    }

    /**
     * @param allowedDaysTillDeparture The allowedDaysTillDeparture
     */
    @JsonProperty("allowedDaysTillDeparture")
    public void setAllowedDaysTillDeparture(String allowedDaysTillDeparture) {
        this.allowedDaysTillDeparture = allowedDaysTillDeparture;
    }

    /**
     * @return The allowedMarketCountryCode
     */
    @JsonProperty("allowedMarketCountryCode")
    public String getAllowedMarketCountryCode() {
        return allowedMarketCountryCode;
    }

    /**
     * @param allowedMarketCountryCode The allowedMarketCountryCode
     */
    @JsonProperty("allowedMarketCountryCode")
    public void setAllowedMarketCountryCode(String allowedMarketCountryCode) {
        this.allowedMarketCountryCode = allowedMarketCountryCode;
    }

    /**
     * @return The bankNameRequired
     */
    @JsonProperty("bankNameRequired")
    public String getBankNameRequired() {
        return bankNameRequired;
    }

    /**
     * @param bankNameRequired The bankNameRequired
     */
    @JsonProperty("bankNameRequired")
    public void setBankNameRequired(String bankNameRequired) {
        this.bankNameRequired = bankNameRequired;
    }

    /**
     * @return The cardHolderNameRequired
     */
    @JsonProperty("cardHolderNameRequired")
    public String getCardHolderNameRequired() {
        return cardHolderNameRequired;
    }

    /**
     * @param cardHolderNameRequired The cardHolderNameRequired
     */
    @JsonProperty("cardHolderNameRequired")
    public void setCardHolderNameRequired(String cardHolderNameRequired) {
        this.cardHolderNameRequired = cardHolderNameRequired;
    }

    /**
     * @return The cardNumberRequired
     */
    @JsonProperty("cardNumberRequired")
    public String getCardNumberRequired() {
        return cardNumberRequired;
    }

    /**
     * @param cardNumberRequired The cardNumberRequired
     */
    @JsonProperty("cardNumberRequired")
    public void setCardNumberRequired(String cardNumberRequired) {
        this.cardNumberRequired = cardNumberRequired;
    }

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
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The isCreditCard
     */
    @JsonProperty("isCreditCard")
    public String getIsCreditCard() {
        return isCreditCard;
    }

    /**
     * @param isCreditCard The isCreditCard
     */
    @JsonProperty("isCreditCard")
    public void setIsCreditCard(String isCreditCard) {
        this.isCreditCard = isCreditCard;
    }

    /**
     * @return The issueNumberRequired
     */
    @JsonProperty("issueNumberRequired")
    public String getIssueNumberRequired() {
        return issueNumberRequired;
    }

    /**
     * @param issueNumberRequired The issueNumberRequired
     */
    @JsonProperty("issueNumberRequired")
    public void setIssueNumberRequired(String issueNumberRequired) {
        this.issueNumberRequired = issueNumberRequired;
    }

    /**
     * @return The issuers
     */
    @JsonProperty("issuers")
    public String getIssuers() {
        return issuers;
    }

    /**
     * @param issuers The issuers
     */
    @JsonProperty("issuers")
    public void setIssuers(String issuers) {
        this.issuers = issuers;
    }

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
     * @return The paymentMethodId
     */
    @JsonProperty("paymentMethodId")
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * @param paymentMethodId The paymentMethodId
     */
    @JsonProperty("paymentMethodId")
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    /**
     * @return The securityCodeLength
     */
    @JsonProperty("securityCodeLength")
    public String getSecurityCodeLength() {
        return securityCodeLength;
    }

    /**
     * @param securityCodeLength The securityCodeLength
     */
    @JsonProperty("securityCodeLength")
    public void setSecurityCodeLength(String securityCodeLength) {
        this.securityCodeLength = securityCodeLength;
    }

    /**
     * @return The securityNumberRequired
     */
    @JsonProperty("securityNumberRequired")
    public String getSecurityNumberRequired() {
        return securityNumberRequired;
    }

    /**
     * @param securityNumberRequired The securityNumberRequired
     */
    @JsonProperty("securityNumberRequired")
    public void setSecurityNumberRequired(String securityNumberRequired) {
        this.securityNumberRequired = securityNumberRequired;
    }

    /**
     * @return The startDateRequired
     */
    @JsonProperty("startDateRequired")
    public String getStartDateRequired() {
        return startDateRequired;
    }

    /**
     * @param startDateRequired The startDateRequired
     */
    @JsonProperty("startDateRequired")
    public void setStartDateRequired(String startDateRequired) {
        this.startDateRequired = startDateRequired;
    }

}
