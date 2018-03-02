package com.api.example.fixture.invoke.response.preferencesresponse;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "marketingCommunicationOptions",
        "contactMethodOptions",
        "contactTypeOptions",
        "frequencyOptions",
        "tripTypeOptions",
        "travellingWhenOptions",
        "travellingWithOptions",
        "travellingSeasonOptions",
        "seatingPreferenceOptions",
        "holdBagWeightOptions"
})
public class PreferencesReferenceData {

    @JsonProperty("marketingCommunicationOptions")
    private List<MarketingCommunicationOption> marketingCommunicationOptions = null;
    @JsonProperty("contactMethodOptions")
    private List<ContactMethodOption> contactMethodOptions = null;
    @JsonProperty("contactTypeOptions")
    private List<ContactTypeOption> contactTypeOptions = null;
    @JsonProperty("frequencyOptions")
    private List<FrequencyOption> frequencyOptions = null;
    @JsonProperty("tripTypeOptions")
    private List<TripTypeOption> tripTypeOptions = null;
    @JsonProperty("travellingWhenOptions")
    private List<TravellingWhenOption> travellingWhenOptions = null;
    @JsonProperty("travellingWithOptions")
    private List<TravellingWithOption> travellingWithOptions = null;
    @JsonProperty("travellingSeasonOptions")
    private List<TravellingSeasonOption> travellingSeasonOptions = null;
    @JsonProperty("seatingPreferenceOptions")
    private List<SeatingPreferenceOption> seatingPreferenceOptions = null;
    @JsonProperty("holdBagWeightOptions")
    private List<HoldBagWeightOption> holdBagWeightOptions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The marketingCommunicationOptions
     */
    @JsonProperty("marketingCommunicationOptions")
    public List<MarketingCommunicationOption> getMarketingCommunicationOptions() {
        return marketingCommunicationOptions;
    }

    /**
     * @param marketingCommunicationOptions The marketingCommunicationOptions
     */
    @JsonProperty("marketingCommunicationOptions")
    public void setMarketingCommunicationOptions(List<MarketingCommunicationOption> marketingCommunicationOptions) {
        this.marketingCommunicationOptions = marketingCommunicationOptions;
    }

    /**
     * @return The contactMethodOptions
     */
    @JsonProperty("contactMethodOptions")
    public List<ContactMethodOption> getContactMethodOptions() {
        return contactMethodOptions;
    }

    /**
     * @param contactMethodOptions The contactMethodOptions
     */
    @JsonProperty("contactMethodOptions")
    public void setContactMethodOptions(List<ContactMethodOption> contactMethodOptions) {
        this.contactMethodOptions = contactMethodOptions;
    }

    /**
     * @return The contactTypeOptions
     */
    @JsonProperty("contactTypeOptions")
    public List<ContactTypeOption> getContactTypeOptions() {
        return contactTypeOptions;
    }

    /**
     * @param contactTypeOptions The contactTypeOptions
     */
    @JsonProperty("contactTypeOptions")
    public void setContactTypeOptions(List<ContactTypeOption> contactTypeOptions) {
        this.contactTypeOptions = contactTypeOptions;
    }

    /**
     * @return The frequencyOptions
     */
    @JsonProperty("frequencyOptions")
    public List<FrequencyOption> getFrequencyOptions() {
        return frequencyOptions;
    }

    /**
     * @param frequencyOptions The frequencyOptions
     */
    @JsonProperty("frequencyOptions")
    public void setFrequencyOptions(List<FrequencyOption> frequencyOptions) {
        this.frequencyOptions = frequencyOptions;
    }

    /**
     * @return The tripTypeOptions
     */
    @JsonProperty("tripTypeOptions")
    public List<TripTypeOption> getTripTypeOptions() {
        return tripTypeOptions;
    }

    /**
     * @param tripTypeOptions The tripTypeOptions
     */
    @JsonProperty("tripTypeOptions")
    public void setTripTypeOptions(List<TripTypeOption> tripTypeOptions) {
        this.tripTypeOptions = tripTypeOptions;
    }

    /**
     * @return The travellingWhenOptions
     */
    @JsonProperty("travellingWhenOptions")
    public List<TravellingWhenOption> getTravellingWhenOptions() {
        return travellingWhenOptions;
    }

    /**
     * @param travellingWhenOptions The travellingWhenOptions
     */
    @JsonProperty("travellingWhenOptions")
    public void setTravellingWhenOptions(List<TravellingWhenOption> travellingWhenOptions) {
        this.travellingWhenOptions = travellingWhenOptions;
    }

    /**
     * @return The travellingWithOptions
     */
    @JsonProperty("travellingWithOptions")
    public List<TravellingWithOption> getTravellingWithOptions() {
        return travellingWithOptions;
    }

    /**
     * @param travellingWithOptions The travellingWithOptions
     */
    @JsonProperty("travellingWithOptions")
    public void setTravellingWithOptions(List<TravellingWithOption> travellingWithOptions) {
        this.travellingWithOptions = travellingWithOptions;
    }

    /**
     * @return The travellingSeasonOptions
     */
    @JsonProperty("travellingSeasonOptions")
    public List<TravellingSeasonOption> getTravellingSeasonOptions() {
        return travellingSeasonOptions;
    }

    /**
     * @param travellingSeasonOptions The travellingSeasonOptions
     */
    @JsonProperty("travellingSeasonOptions")
    public void setTravellingSeasonOptions(List<TravellingSeasonOption> travellingSeasonOptions) {
        this.travellingSeasonOptions = travellingSeasonOptions;
    }

    /**
     * @return The seatingPreferenceOptions
     */
    @JsonProperty("seatingPreferenceOptions")
    public List<SeatingPreferenceOption> getSeatingPreferenceOptions() {
        return seatingPreferenceOptions;
    }

    /**
     * @param seatingPreferenceOptions The seatingPreferenceOptions
     */
    @JsonProperty("seatingPreferenceOptions")
    public void setSeatingPreferenceOptions(List<SeatingPreferenceOption> seatingPreferenceOptions) {
        this.seatingPreferenceOptions = seatingPreferenceOptions;
    }

    /**
     * @return The holdBagWeightOptions
     */
    @JsonProperty("holdBagWeightOptions")
    public List<HoldBagWeightOption> getHoldBagWeightOptions() {
        return holdBagWeightOptions;
    }

    /**
     * @param holdBagWeightOptions The holdBagWeightOptions
     */
    @JsonProperty("holdBagWeightOptions")
    public void setHoldBagWeightOptions(List<HoldBagWeightOption> holdBagWeightOptions) {
        this.holdBagWeightOptions = holdBagWeightOptions;
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
