package com.api.example.fixture.invoke.response.getairports;


import com.fasterxml.jackson.annotation.*;
import com.api.example.fixture.invoke.response.common.LocalizedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "code",
        "localizedNames",
        "localizedCityNames",
        "country",
        "geoLocation",
        "address",
        "gmtOffset",
        "defaultCurrency",
        "terminals",
        "availableServices",
        "isAvoidStopOver",
        "isOnlineCheckInAvailable",
        "isMobileCheckInAvailable",
        "onlineCheckInCloseTime",
        "airportCheckInCloseTime"
})
public class Airport {

    @JsonProperty("code")
    private String code;
    @JsonProperty("localizedNames")
    private List<LocalizedName> localizedNames = new ArrayList<LocalizedName>();
    @JsonProperty("localizedCityNames")
    private List<LocalizedCityName> localizedCityNames = new ArrayList<LocalizedCityName>();
    @JsonProperty("country")
    private String country;
    @JsonProperty("geoLocation")
    private GeoLocation geoLocation;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("gmtOffset")
    private Double gmtOffset;
    @JsonProperty("defaultCurrency")
    private String defaultCurrency;
    @JsonProperty("terminals")
    private List<Object> terminals = new ArrayList<Object>();
    @JsonProperty("availableServices")
    private List<Object> availableServices = new ArrayList<Object>();
    @JsonProperty("isAvoidStopOver")
    private Boolean isAvoidStopOver;
    @JsonProperty("isOnlineCheckInAvailable")
    private Boolean isOnlineCheckInAvailable;
    @JsonProperty("isMobileCheckInAvailable")
    private Boolean isMobileCheckInAvailable;
    @JsonProperty("onlineCheckInCloseTime")
    private Integer onlineCheckInCloseTime;
    @JsonProperty("airportCheckInCloseTime")
    private Integer airportCheckInCloseTime;
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
     * @return The localizedCityNames
     */
    @JsonProperty("localizedCityNames")
    public List<LocalizedCityName> getLocalizedCityNames() {
        return localizedCityNames;
    }

    /**
     * @param localizedCityNames The localizedCityNames
     */
    @JsonProperty("localizedCityNames")
    public void setLocalizedCityNames(List<LocalizedCityName> localizedCityNames) {
        this.localizedCityNames = localizedCityNames;
    }

    /**
     * @return The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The geoLocation
     */
    @JsonProperty("geoLocation")
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     * @param geoLocation The geoLocation
     */
    @JsonProperty("geoLocation")
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    /**
     * @return The address
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The gmtOffset
     */
    @JsonProperty("gmtOffset")
    public Double getGmtOffset() {
        return gmtOffset;
    }

    /**
     * @param gmtOffset The gmtOffset
     */
    @JsonProperty("gmtOffset")
    public void setGmtOffset(Double gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    /**
     * @return The defaultCurrency
     */
    @JsonProperty("defaultCurrency")
    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * @param defaultCurrency The defaultCurrency
     */
    @JsonProperty("defaultCurrency")
    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * @return The terminals
     */
    @JsonProperty("terminals")
    public List<Object> getTerminals() {
        return terminals;
    }

    /**
     * @param terminals The terminals
     */
    @JsonProperty("terminals")
    public void setTerminals(List<Object> terminals) {
        this.terminals = terminals;
    }

    /**
     * @return The availableServices
     */
    @JsonProperty("availableServices")
    public List<Object> getAvailableServices() {
        return availableServices;
    }

    /**
     * @param availableServices The availableServices
     */
    @JsonProperty("availableServices")
    public void setAvailableServices(List<Object> availableServices) {
        this.availableServices = availableServices;
    }

    /**
     * @return The isAvoidStopOver
     */
    @JsonProperty("isAvoidStopOver")
    public Boolean getIsAvoidStopOver() {
        return isAvoidStopOver;
    }

    /**
     * @param isAvoidStopOver The isAvoidStopOver
     */
    @JsonProperty("isAvoidStopOver")
    public void setIsAvoidStopOver(Boolean isAvoidStopOver) {
        this.isAvoidStopOver = isAvoidStopOver;
    }

    /**
     * @return The isOnlineCheckInAvailable
     */
    @JsonProperty("isOnlineCheckInAvailable")
    public Boolean getIsOnlineCheckInAvailable() {
        return isOnlineCheckInAvailable;
    }

    /**
     * @param isOnlineCheckInAvailable The isOnlineCheckInAvailable
     */
    @JsonProperty("isOnlineCheckInAvailable")
    public void setIsOnlineCheckInAvailable(Boolean isOnlineCheckInAvailable) {
        this.isOnlineCheckInAvailable = isOnlineCheckInAvailable;
    }

    /**
     * @return The isMobileCheckInAvailable
     */
    @JsonProperty("isMobileCheckInAvailable")
    public Boolean getIsMobileCheckInAvailable() {
        return isMobileCheckInAvailable;
    }

    /**
     * @param isMobileCheckInAvailable The isMobileCheckInAvailable
     */
    @JsonProperty("isMobileCheckInAvailable")
    public void setIsMobileCheckInAvailable(Boolean isMobileCheckInAvailable) {
        this.isMobileCheckInAvailable = isMobileCheckInAvailable;
    }

    /**
     * @return The onlineCheckInCloseTime
     */
    @JsonProperty("onlineCheckInCloseTime")
    public Integer getOnlineCheckInCloseTime() {
        return onlineCheckInCloseTime;
    }

    /**
     * @param onlineCheckInCloseTime The onlineCheckInCloseTime
     */
    @JsonProperty("onlineCheckInCloseTime")
    public void setOnlineCheckInCloseTime(Integer onlineCheckInCloseTime) {
        this.onlineCheckInCloseTime = onlineCheckInCloseTime;
    }

    /**
     * @return The airportCheckInCloseTime
     */
    @JsonProperty("airportCheckInCloseTime")
    public Integer getAirportCheckInCloseTime() {
        return airportCheckInCloseTime;
    }

    /**
     * @param airportCheckInCloseTime The airportCheckInCloseTime
     */
    @JsonProperty("airportCheckInCloseTime")
    public void setAirportCheckInCloseTime(Integer airportCheckInCloseTime) {
        this.airportCheckInCloseTime = airportCheckInCloseTime;
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
