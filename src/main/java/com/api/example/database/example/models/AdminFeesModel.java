package com.api.example.database.example.models;

import lombok.Data;

/**
 * Created by AndrewGr on 14/12/2016.
 */
@Data
public class AdminFeesModel {
    private String feeCode;
    private String passengerType;
    private Double feeValue;
    private String feeCurrency;

    public AdminFeesModel(String feeCode, String passengerType, String feeValue, String feeCurrency) {
        this.feeCode = feeCode;
        this.passengerType = passengerType;
        this.feeValue = Double.valueOf(feeValue);
        this.feeCurrency = feeCurrency;

    }
}