package com.api.example.database.otherdb.models;

import lombok.Data;

/**
 * Created by daniel on 23/11/2016.
 */
@Data
public class EresFlightDbModel {

    private String flightKey;
    private String localDepartureDate;
    private String capacity;
    private String seatsSold;
    private String lid;
    private String iropLid;
    private String speedyBoardingCount;
    private String speedyBoardingSold;

    public EresFlightDbModel(String flightKey, String localDepartureDate, String capacity, String seatsSold, String lid, String iropLid, String speedyBoardingCount, String speedyBoardingSold) {
        this.flightKey = flightKey;
        this.localDepartureDate = localDepartureDate;
        this.capacity = capacity;
        this.seatsSold = seatsSold;
        this.lid = lid;
        this.iropLid = iropLid;
        this.speedyBoardingCount = speedyBoardingCount;
        this.speedyBoardingSold = speedyBoardingSold;
    }
}
