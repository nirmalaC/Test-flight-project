package com.api.example.fixture.invoke.response.basket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "passengerType",
        "quantity",
        "additionalSeats"
})
@Builder
public class Passenger {

    @JsonProperty("passengerType")
    private String passengerType;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("additionalSeats")
    private Integer additionalSeats;
    @JsonProperty("infantOwnSeat")
    private boolean infantOwnSeat;

    @JsonProperty("infantOwnSeat")
    public boolean getInfantOwnSeat() {
        return infantOwnSeat;
    }

    @JsonProperty("infantOwnSeat")
    public void setInfantOwnSeat(boolean infantOwnSeat) {
        this.infantOwnSeat = infantOwnSeat;
    }

    /**
     * @return The passengerType
     */
    @JsonProperty("passengerType")
    public String getPassengerType() {
        return passengerType;
    }

    /**
     * @param passengerType The passengerType
     */
    @JsonProperty("passengerType")
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
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
     * @return The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public Integer getAdditionalSeats() {
        return additionalSeats;
    }

    /**
     * @param additionalSeats The additionalSeats
     */
    @JsonProperty("additionalSeats")
    public void setAdditionalSeats(Integer additionalSeats) {
        this.additionalSeats = additionalSeats;
    }


}
