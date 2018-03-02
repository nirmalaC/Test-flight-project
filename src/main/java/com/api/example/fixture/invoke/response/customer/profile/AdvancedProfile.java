package com.api.example.fixture.invoke.response.customer.profile;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "relatedBookings",
        "savedPayments",
        "savedPassengers",
        "recentSearches",
        "flightInterests",
        "identityDocuments",
        "savedSSRs",
        "significantOthers",
        "dependents",
        "comments",
        "auditData",
        "communicationPreferences",
        "travelPreferences",
        "ancillaryPreferences",
        "savedInspireMeIdeas",
        "savedDestinations",
        "savedBasketTrip"
})
public class AdvancedProfile {

    @JsonProperty("relatedBookings")
    private List<RelatedBooking> relatedBookings = new ArrayList<RelatedBooking>();
    @JsonProperty("savedPayments")
    private SavedPayments savedPayments;
    @JsonProperty("savedPassengers")
    private List<SavedPassenger> savedPassengers = new ArrayList<SavedPassenger>();
    @JsonProperty("recentSearches")
    private List<RecentSearch> recentSearches = new ArrayList<RecentSearch>();
    @JsonProperty("flightInterests")
    private List<FlightInterest> flightInterests = new ArrayList<FlightInterest>();
    @JsonProperty("identityDocuments")
    private List<IdentityDocument> identityDocuments = new ArrayList<IdentityDocument>();
    @JsonProperty("savedSSRs")
    private SavedSSRs savedSSRs;
    @JsonProperty("significantOthers")
    private SignificantOthers significantOthers;
    @JsonProperty("dependents")
    private List<Dependent> dependents = new ArrayList<Dependent>();
    @JsonProperty("comments")
    private List<Comment> comments = new ArrayList<Comment>();
    @JsonProperty("auditData")
    private List<AuditDatum> auditData = new ArrayList<AuditDatum>();
    @JsonProperty("communicationPreferences")
    private CommunicationPreferences communicationPreferences;
    @JsonProperty("travelPreferences")
    private TravelPreferences travelPreferences;
    @JsonProperty("ancillaryPreferences")
    private AncillaryPreferences ancillaryPreferences;
    @JsonProperty("savedInspireMeIdeas")
    private List<SavedInspireMeIdea> savedInspireMeIdeas = new ArrayList<SavedInspireMeIdea>();
    @JsonProperty("savedDestinations")
    private List<String> savedDestinations = new ArrayList<String>();
    @JsonProperty("savedBasketTrip")
    private List<String> savedBasketTrip = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The relatedBookings
     */
    @JsonProperty("relatedBookings")
    public List<RelatedBooking> getRelatedBookings() {
        return relatedBookings;
    }

    /**
     * @param relatedBookings The relatedBookings
     */
    @JsonProperty("relatedBookings")
    public void setRelatedBookings(List<RelatedBooking> relatedBookings) {
        this.relatedBookings = relatedBookings;
    }

    /**
     * @return The savedPayments
     */
    @JsonProperty("savedPayments")
    public SavedPayments getSavedPayments() {
        return savedPayments;
    }

    /**
     * @param savedPayments The savedPayments
     */
    @JsonProperty("savedPayments")
    public void setSavedPayments(SavedPayments savedPayments) {
        this.savedPayments = savedPayments;
    }

    /**
     * @return The savedPassengers
     */
    @JsonProperty("savedPassengers")
    public List<SavedPassenger> getSavedPassengers() {
        return savedPassengers;
    }

    /**
     * @param savedPassengers The savedPassengers
     */
    @JsonProperty("savedPassengers")
    public void setSavedPassengers(List<SavedPassenger> savedPassengers) {
        this.savedPassengers = savedPassengers;
    }

    /**
     * @return The recentSearches
     */
    @JsonProperty("recentSearches")
    public List<RecentSearch> getRecentSearches() {
        return recentSearches;
    }

    /**
     * @param recentSearches The recentSearches
     */
    @JsonProperty("recentSearches")
    public void setRecentSearches(List<RecentSearch> recentSearches) {
        this.recentSearches = recentSearches;
    }

    /**
     * @return The flightInterests
     */
    @JsonProperty("flightInterests")
    public List<FlightInterest> getFlightInterests() {
        return flightInterests;
    }

    /**
     * @param flightInterests The flightInterests
     */
    @JsonProperty("flightInterests")
    public void setFlightInterests(List<FlightInterest> flightInterests) {
        this.flightInterests = flightInterests;
    }

    /**
     * @return The identityDocuments
     */
    @JsonProperty("identityDocuments")
    public List<IdentityDocument> getIdentityDocuments() {
        return identityDocuments;
    }

    /**
     * @param identityDocuments The identityDocuments
     */
    @JsonProperty("identityDocuments")
    public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
        this.identityDocuments = identityDocuments;
    }

    /**
     * @return The savedSSRs
     */
    @JsonProperty("savedSSRs")
    public SavedSSRs getSavedSSRs() {
        return savedSSRs;
    }

    /**
     * @param savedSSRs The savedSSRs
     */
    @JsonProperty("savedSSRs")
    public void setSavedSSRs(SavedSSRs savedSSRs) {
        this.savedSSRs = savedSSRs;
    }

    /**
     * @return The significantOthers
     */
    @JsonProperty("significantOthers")
    public SignificantOthers getSignificantOthers() {
        return significantOthers;
    }

    /**
     * @param significantOthers The significantOthers
     */
    @JsonProperty("significantOthers")
    public void setSignificantOthers(SignificantOthers significantOthers) {
        this.significantOthers = significantOthers;
    }

    /**
     * @return The dependents
     */
    @JsonProperty("dependents")
    public List<Dependent> getDependents() {
        return dependents;
    }

    /**
     * @param dependents The dependents
     */
    @JsonProperty("dependents")
    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    /**
     * @return The comments
     */
    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return The auditData
     */
    @JsonProperty("auditData")
    public List<AuditDatum> getAuditData() {
        return auditData;
    }

    /**
     * @param auditData The auditData
     */
    @JsonProperty("auditData")
    public void setAuditData(List<AuditDatum> auditData) {
        this.auditData = auditData;
    }

    /**
     * @return The communicationPreferences
     */
    @JsonProperty("communicationPreferences")
    public CommunicationPreferences getCommunicationPreferences() {
        return communicationPreferences;
    }

    /**
     * @param communicationPreferences The communicationPreferences
     */
    @JsonProperty("communicationPreferences")
    public void setCommunicationPreferences(CommunicationPreferences communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
    }

    /**
     * @return The travelPreferences
     */
    @JsonProperty("travelPreferences")
    public TravelPreferences getTravelPreferences() {
        return travelPreferences;
    }

    /**
     * @param travelPreferences The travelPreferences
     */
    @JsonProperty("travelPreferences")
    public void setTravelPreferences(TravelPreferences travelPreferences) {
        this.travelPreferences = travelPreferences;
    }

    /**
     * @return The ancillaryPreferences
     */
    @JsonProperty("ancillaryPreferences")
    public AncillaryPreferences getAncillaryPreferences() {
        return ancillaryPreferences;
    }

    /**
     * @param ancillaryPreferences The ancillaryPreferences
     */
    @JsonProperty("ancillaryPreferences")
    public void setAncillaryPreferences(AncillaryPreferences ancillaryPreferences) {
        this.ancillaryPreferences = ancillaryPreferences;
    }

    /**
     * @return The savedInspireMeIdeas
     */
    @JsonProperty("savedInspireMeIdeas")
    public List<SavedInspireMeIdea> getSavedInspireMeIdeas() {
        return savedInspireMeIdeas;
    }

    /**
     * @param savedInspireMeIdeas The savedInspireMeIdeas
     */
    @JsonProperty("savedInspireMeIdeas")
    public void setSavedInspireMeIdeas(List<SavedInspireMeIdea> savedInspireMeIdeas) {
        this.savedInspireMeIdeas = savedInspireMeIdeas;
    }

    /**
     * @return The savedDestinations
     */
    @JsonProperty("savedDestinations")
    public List<String> getSavedDestinations() {
        return savedDestinations;
    }

    /**
     * @param savedDestinations The savedDestinations
     */
    @JsonProperty("savedDestinations")
    public void setSavedDestinations(List<String> savedDestinations) {
        this.savedDestinations = savedDestinations;
    }

    /**
     * @return The savedBasketTrip
     */
    @JsonProperty("savedBasketTrip")
    public List<String> getSavedBasketTrip() {
        return savedBasketTrip;
    }

    /**
     * @param savedBasketTrip The savedBasketTrip
     */
    @JsonProperty("savedBasketTrip")
    public void setSavedBasketTrip(List<String> savedBasketTrip) {
        this.savedBasketTrip = savedBasketTrip;
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
