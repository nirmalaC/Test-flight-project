package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "basketLanguage",
        "defaultCardType",
        "basketType",
        "bookingReason",
        "currency",
        "outbounds",
        "inbounds",
        "carHires",
        "travelInsurances",
        "hotels",
        "taxes",
        "fees",
        "discounts",
        "subtotalAmountWithCreditCard",
        "subtotalAmountWithDebitCard",
        "totalAmountWithCreditCard",
        "totalAmountWithDebitCard"
})
public class Basket {

    @JsonProperty("code")
    private String code;
    @JsonProperty("basketLanguage")
    private String basketLanguage;
    @JsonProperty("defaultCardType")
    private String defaultCardType;
    @JsonProperty("basketType")
    private String basketType;
    @JsonProperty("bookingReason")
    private String bookingReason;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("outbounds")
    private List<Outbound> outbounds = new ArrayList<Outbound>();
    @JsonProperty("inbounds")
    private List<Inbound> inbounds = new ArrayList<Inbound>();
    @JsonProperty("carHires")
    private List<CarHire> carHires = new ArrayList<CarHire>();
    @JsonProperty("travelInsurances")
    private List<TravelInsurance> travelInsurances = new ArrayList<TravelInsurance>();
    @JsonProperty("hotels")
    private List<Hotel> hotels = new ArrayList<Hotel>();
    @JsonProperty("taxes")
    private Taxes taxes;
    @JsonProperty("fees")
    private Fees fees;
    @JsonProperty("discounts")
    private Discounts discounts;
    @JsonProperty("subtotalAmountWithCreditCard")
    private Double subtotalAmountWithCreditCard;
    @JsonProperty("subtotalAmountWithDebitCard")
    private Double subtotalAmountWithDebitCard;
    @JsonProperty("totalAmountWithCreditCard")
    private Double totalAmountWithCreditCard;
    @JsonProperty("totalAmountWithDebitCard")
    private Double totalAmountWithDebitCard;
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
     * @return The basketLanguage
     */
    @JsonProperty("basketLanguage")
    public String getBasketLanguage() {
        return basketLanguage;
    }

    /**
     * @param basketLanguage The basketLanguage
     */
    @JsonProperty("basketLanguage")
    public void setBasketLanguage(String basketLanguage) {
        this.basketLanguage = basketLanguage;
    }

    /**
     * @return The defaultCardType
     */
    @JsonProperty("defaultCardType")
    public String getDefaultCardType() {
        return defaultCardType;
    }

    /**
     * @param defaultCardType The defaultCardType
     */
    @JsonProperty("defaultCardType")
    public void setDefaultCardType(String defaultCardType) {
        this.defaultCardType = defaultCardType;
    }

    /**
     * @return The basketType
     */
    @JsonProperty("basketType")
    public String getBasketType() {
        return basketType;
    }

    /**
     * @param basketType The basketType
     */
    @JsonProperty("basketType")
    public void setBasketType(String basketType) {
        this.basketType = basketType;
    }

    /**
     * @return The bookingReason
     */
    @JsonProperty("bookingReason")
    public String getBookingReason() {
        return bookingReason;
    }

    /**
     * @param bookingReason The bookingReason
     */
    @JsonProperty("bookingReason")
    public void setBookingReason(String bookingReason) {
        this.bookingReason = bookingReason;
    }

    /**
     * @return The currency
     */
    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return The outbounds
     */
    @JsonProperty("outbounds")
    public List<Outbound> getOutbounds() {
        return outbounds;
    }

    /**
     * @param outbounds The outbounds
     */
    @JsonProperty("outbounds")
    public void setOutbounds(List<Outbound> outbounds) {
        this.outbounds = outbounds;
    }

    /**
     * @return The inbounds
     */
    @JsonProperty("inbounds")
    public List<Inbound> getInbounds() {
        return inbounds;
    }

    /**
     * @param inbounds The inbounds
     */
    @JsonProperty("inbounds")
    public void setInbounds(List<Inbound> inbounds) {
        this.inbounds = inbounds;
    }

    /**
     * @return The carHires
     */
    @JsonProperty("carHires")
    public List<CarHire> getCarHires() {
        return carHires;
    }

    /**
     * @param carHires The carHires
     */
    @JsonProperty("carHires")
    public void setCarHires(List<CarHire> carHires) {
        this.carHires = carHires;
    }

    /**
     * @return The travelInsurances
     */
    @JsonProperty("travelInsurances")
    public List<TravelInsurance> getTravelInsurances() {
        return travelInsurances;
    }

    /**
     * @param travelInsurances The travelInsurances
     */
    @JsonProperty("travelInsurances")
    public void setTravelInsurances(List<TravelInsurance> travelInsurances) {
        this.travelInsurances = travelInsurances;
    }

    /**
     * @return The hotels
     */
    @JsonProperty("hotels")
    public List<Hotel> getHotels() {
        return hotels;
    }

    /**
     * @param hotels The hotels
     */
    @JsonProperty("hotels")
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * @return The taxes
     */
    @JsonProperty("taxes")
    public Taxes getTaxes() {
        return taxes;
    }

    /**
     * @param taxes The taxes
     */
    @JsonProperty("taxes")
    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    /**
     * @return The fees
     */
    @JsonProperty("fees")
    public Fees getFees() {
        return fees;
    }

    /**
     * @param fees The fees
     */
    @JsonProperty("fees")
    public void setFees(Fees fees) {
        this.fees = fees;
    }

    /**
     * @return The discounts
     */
    @JsonProperty("discounts")
    public Discounts getDiscounts() {
        return discounts;
    }

    /**
     * @param discounts The discounts
     */
    @JsonProperty("discounts")
    public void setDiscounts(Discounts discounts) {
        this.discounts = discounts;
    }

    /**
     * @return The subtotalAmountWithCreditCard
     */
    @JsonProperty("subtotalAmountWithCreditCard")
    public Double getSubtotalAmountWithCreditCard() {
        return subtotalAmountWithCreditCard;
    }

    /**
     * @param subtotalAmountWithCreditCard The subtotalAmountWithCreditCard
     */
    @JsonProperty("subtotalAmountWithCreditCard")
    public void setSubtotalAmountWithCreditCard(Double subtotalAmountWithCreditCard) {
        this.subtotalAmountWithCreditCard = subtotalAmountWithCreditCard;
    }

    /**
     * @return The subtotalAmountWithDebitCard
     */
    @JsonProperty("subtotalAmountWithDebitCard")
    public Double getSubtotalAmountWithDebitCard() {
        return subtotalAmountWithDebitCard;
    }

    /**
     * @param subtotalAmountWithDebitCard The subtotalAmountWithDebitCard
     */
    @JsonProperty("subtotalAmountWithDebitCard")
    public void setSubtotalAmountWithDebitCard(Double subtotalAmountWithDebitCard) {
        this.subtotalAmountWithDebitCard = subtotalAmountWithDebitCard;
    }

    /**
     * @return The totalAmountWithCreditCard
     */
    @JsonProperty("totalAmountWithCreditCard")
    public Double getTotalAmountWithCreditCard() {
        return totalAmountWithCreditCard;
    }

    /**
     * @param totalAmountWithCreditCard The totalAmountWithCreditCard
     */
    @JsonProperty("totalAmountWithCreditCard")
    public void setTotalAmountWithCreditCard(Double totalAmountWithCreditCard) {
        this.totalAmountWithCreditCard = totalAmountWithCreditCard;
    }

    /**
     * @return The totalAmountWithDebitCard
     */
    @JsonProperty("totalAmountWithDebitCard")
    public Double getTotalAmountWithDebitCard() {
        return totalAmountWithDebitCard;
    }

    /**
     * @param totalAmountWithDebitCard The totalAmountWithDebitCard
     */
    @JsonProperty("totalAmountWithDebitCard")
    public void setTotalAmountWithDebitCard(Double totalAmountWithDebitCard) {
        this.totalAmountWithDebitCard = totalAmountWithDebitCard;
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
