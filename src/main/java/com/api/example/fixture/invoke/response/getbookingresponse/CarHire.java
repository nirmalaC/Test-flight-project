
package com.api.example.fixture.invoke.response.getbookingresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private List<CarExtra> carExtras = null;
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

    @JsonProperty("bundleCode")
    public String getBundleCode() {
        return bundleCode;
    }

    @JsonProperty("bundleCode")
    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("rateId")
    public String getRateId() {
        return rateId;
    }

    @JsonProperty("rateId")
    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    @JsonProperty("checkInStation")
    public CheckInStation getCheckInStation() {
        return checkInStation;
    }

    @JsonProperty("checkInStation")
    public void setCheckInStation(CheckInStation checkInStation) {
        this.checkInStation = checkInStation;
    }

    @JsonProperty("checkOutStation")
    public CheckOutStation getCheckOutStation() {
        return checkOutStation;
    }

    @JsonProperty("checkOutStation")
    public void setCheckOutStation(CheckOutStation checkOutStation) {
        this.checkOutStation = checkOutStation;
    }

    @JsonProperty("checkInDateTime")
    public String getCheckInDateTime() {
        return checkInDateTime;
    }

    @JsonProperty("checkInDateTime")
    public void setCheckInDateTime(String checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    @JsonProperty("checkOutDateTime")
    public String getCheckOutDateTime() {
        return checkOutDateTime;
    }

    @JsonProperty("checkOutDateTime")
    public void setCheckOutDateTime(String checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    @JsonProperty("customerEmail")
    public String getCustomerEmail() {
        return customerEmail;
    }

    @JsonProperty("customerEmail")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @JsonProperty("customerPhone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    @JsonProperty("customerPhone")
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @JsonProperty("primaryDriver")
    public PrimaryDriver getPrimaryDriver() {
        return primaryDriver;
    }

    @JsonProperty("primaryDriver")
    public void setPrimaryDriver(PrimaryDriver primaryDriver) {
        this.primaryDriver = primaryDriver;
    }

    @JsonProperty("otherDrivers")
    public OtherDrivers getOtherDrivers() {
        return otherDrivers;
    }

    @JsonProperty("otherDrivers")
    public void setOtherDrivers(OtherDrivers otherDrivers) {
        this.otherDrivers = otherDrivers;
    }

    @JsonProperty("carExtras")
    public List<CarExtra> getCarExtras() {
        return carExtras;
    }

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
