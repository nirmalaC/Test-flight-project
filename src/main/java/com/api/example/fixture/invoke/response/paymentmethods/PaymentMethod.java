package com.api.example.fixture.invoke.response.paymentmethods;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import com.api.example.fixture.invoke.response.common.LocalizedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "paymentMethodId",
        "paymentMethod",
        "code",
        "localizedNames",
        "description",
        "bankNameRequired",
        "cardHolderNameRequired",
        "cardNumberRequired",
        "isCreditCard",
        "issueNumberRequired",
        "issuers",
        "securityCodeLength",
        "securityNumberRequired",
        "startDateRequired"
})
public class PaymentMethod implements IRequestBody {

    @JsonProperty("paymentMethodId")
    private String paymentMethodId;
    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("bankNameRequired")
    private Boolean bankNameRequired;
    @JsonProperty("cardHolderNameRequired")
    private Boolean cardHolderNameRequired;
    @JsonProperty("cardNumberRequired")
    private Boolean cardNumberRequired;
    @JsonProperty("isCreditCard")
    private Boolean isCreditCard;
    @JsonProperty("issueNumberRequired")
    private Boolean issueNumberRequired;
    @JsonProperty("issuers")
    private String issuers;
    @JsonProperty("securityCodeLength")
    private String securityCodeLength;
    @JsonProperty("securityNumberRequired")
    private Boolean securityNumberRequired;
    @JsonProperty("startDateRequired")
    private Boolean startDateRequired;

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
     * @return The localizedNames
     */
    @JsonProperty("localizedNames")
    public List<LocalizedName> getLocalizedNames() {
        return localizedNames;
    }

    /**
     * @param localizedNames The localizedNames
     */
    @JsonProperty("localizedNames")
    public void setLocalizedNames(List<LocalizedName> localizedNames) {
        this.localizedNames = localizedNames;
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
     * @return The bankNameRequired
     */
    @JsonProperty("bankNameRequired")
    public Boolean getBankNameRequired() {
        return bankNameRequired;
    }

    /**
     * @param bankNameRequired The bankNameRequired
     */
    @JsonProperty("bankNameRequired")
    public void setBankNameRequired(Boolean bankNameRequired) {
        this.bankNameRequired = bankNameRequired;
    }

    /**
     * @return The cardHolderNameRequired
     */
    @JsonProperty("cardHolderNameRequired")
    public Boolean getCardHolderNameRequired() {
        return cardHolderNameRequired;
    }

    /**
     * @param cardHolderNameRequired The cardHolderNameRequired
     */
    @JsonProperty("cardHolderNameRequired")
    public void setCardHolderNameRequired(Boolean cardHolderNameRequired) {
        this.cardHolderNameRequired = cardHolderNameRequired;
    }

    /**
     * @return The cardNumberRequired
     */
    @JsonProperty("cardNumberRequired")
    public Boolean getCardNumberRequired() {
        return cardNumberRequired;
    }

    /**
     * @param cardNumberRequired The cardNumberRequired
     */
    @JsonProperty("cardNumberRequired")
    public void setCardNumberRequired(Boolean cardNumberRequired) {
        this.cardNumberRequired = cardNumberRequired;
    }

    /**
     * @return The isCreditCard
     */
    @JsonProperty("isCreditCard")
    public Boolean getIsCreditCard() {
        return isCreditCard;
    }

    /**
     * @param isCreditCard The isCreditCard
     */
    @JsonProperty("isCreditCard")
    public void setIsCreditCard(Boolean isCreditCard) {
        this.isCreditCard = isCreditCard;
    }

    /**
     * @return The issueNumberRequired
     */
    @JsonProperty("issueNumberRequired")
    public Boolean getIssueNumberRequired() {
        return issueNumberRequired;
    }

    /**
     * @param issueNumberRequired The issueNumberRequired
     */
    @JsonProperty("issueNumberRequired")
    public void setIssueNumberRequired(Boolean issueNumberRequired) {
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
    public Boolean getSecurityNumberRequired() {
        return securityNumberRequired;
    }

    /**
     * @param securityNumberRequired The securityNumberRequired
     */
    @JsonProperty("securityNumberRequired")
    public void setSecurityNumberRequired(Boolean securityNumberRequired) {
        this.securityNumberRequired = securityNumberRequired;
    }

    /**
     * @return The startDateRequired
     */
    @JsonProperty("startDateRequired")
    public Boolean getStartDateRequired() {
        return startDateRequired;
    }

    /**
     * @param startDateRequired The startDateRequired
     */
    @JsonProperty("startDateRequired")
    public void setStartDateRequired(Boolean startDateRequired) {
        this.startDateRequired = startDateRequired;
    }

}
