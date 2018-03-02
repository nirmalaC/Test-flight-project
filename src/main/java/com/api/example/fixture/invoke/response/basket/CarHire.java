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
        "type",
        "bundleCode",
        "code",
        "name",
        "description",
        "quantity",
        "pricing",
        "category",
        "rateId",
        "checkInStation",
        "checkOutStation",
        "checkInDateTime",
        "checkOutDateTime",
        "customerEmail",
        "customerPhone",
        "primaryDriver",
        "otherDrivers",
        "carExtras"
})
public class CarHire {

    @JsonProperty("type")
    private String type;
    @JsonProperty("bundleCode")
    private String bundleCode;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("pricing")
    private Pricing pricing;
    @JsonProperty("category")
    private String category;
    @JsonProperty("rateId")
    private String rateId;
    @JsonProperty("checkInStation")
    private CheckInStation checkInStation;
    @JsonProperty("checkOutStation")
    private CheckOutStation checkOutStation;
    @JsonProperty("checkInDateTime")
    private String checkInDateTime;
    @JsonProperty("checkOutDateTime")
    private String checkOutDateTime;
    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonProperty("customerPhone")
    private String customerPhone;
    @JsonProperty("primaryDriver")
    private PrimaryDriver primaryDriver;
    @JsonProperty("otherDrivers")
    private OtherDrivers otherDrivers;
    @JsonProperty("carExtras")
    private List<CarExtra> carExtras = new ArrayList<CarExtra>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The bundleCode
     */
    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    /**
     * @param bundleCode The bundleCode
     */
    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
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
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
     * @return The quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The pricing
     */
    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    /**
     * @param pricing The pricing
     */
    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * @return The category
     */
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return The rateId
     */
    @JsonProperty("rateId")
    public String getRateId() {
        return rateId;
    }

    /**
     * @param rateId The rateId
     */
    @JsonProperty("rateId")
    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    /**
     * @return The checkInStation
     */
    @JsonProperty("checkInStation")
    public CheckInStation getCheckInStation() {
        return checkInStation;
    }

    /**
     * @param checkInStation The checkInStation
     */
    @JsonProperty("checkInStation")
    public void setCheckInStation(CheckInStation checkInStation) {
        this.checkInStation = checkInStation;
    }

    /**
     * @return The checkOutStation
     */
    @JsonProperty("checkOutStation")
    public CheckOutStation getCheckOutStation() {
        return checkOutStation;
    }

    /**
     * @param checkOutStation The checkOutStation
     */
    @JsonProperty("checkOutStation")
    public void setCheckOutStation(CheckOutStation checkOutStation) {
        this.checkOutStation = checkOutStation;
    }

    /**
     * @return The checkInDateTime
     */
    @JsonProperty("checkInDateTime")
    public String getCheckInDateTime() {
        return checkInDateTime;
    }

    /**
     * @param checkInDateTime The checkInDateTime
     */
    @JsonProperty("checkInDateTime")
    public void setCheckInDateTime(String checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    /**
     * @return The checkOutDateTime
     */
    @JsonProperty("checkOutDateTime")
    public String getCheckOutDateTime() {
        return checkOutDateTime;
    }

    /**
     * @param checkOutDateTime The checkOutDateTime
     */
    @JsonProperty("checkOutDateTime")
    public void setCheckOutDateTime(String checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    /**
     * @return The customerEmail
     */
    @JsonProperty("customerEmail")
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail The customerEmail
     */
    @JsonProperty("customerEmail")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return The customerPhone
     */
    @JsonProperty("customerPhone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone The customerPhone
     */
    @JsonProperty("customerPhone")
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return The primaryDriver
     */
    @JsonProperty("primaryDriver")
    public PrimaryDriver getPrimaryDriver() {
        return primaryDriver;
    }

    /**
     * @param primaryDriver The primaryDriver
     */
    @JsonProperty("primaryDriver")
    public void setPrimaryDriver(PrimaryDriver primaryDriver) {
        this.primaryDriver = primaryDriver;
    }

    /**
     * @return The otherDrivers
     */
    @JsonProperty("otherDrivers")
    public OtherDrivers getOtherDrivers() {
        return otherDrivers;
    }

    /**
     * @param otherDrivers The otherDrivers
     */
    @JsonProperty("otherDrivers")
    public void setOtherDrivers(OtherDrivers otherDrivers) {
        this.otherDrivers = otherDrivers;
    }

    /**
     * @return The carExtras
     */
    @JsonProperty("carExtras")
    public List<CarExtra> getCarExtras() {
        return carExtras;
    }

    /**
     * @param carExtras The carExtras
     */
    @JsonProperty("carExtras")
    public void setCarExtras(List<CarExtra> carExtras) {
        this.carExtras = carExtras;
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
