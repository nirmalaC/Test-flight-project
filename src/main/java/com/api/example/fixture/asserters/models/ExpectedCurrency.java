package com.api.example.fixture.asserters.models;

import lombok.Builder;
import lombok.Data;

/**
 * Created by daniel on 11/11/2016.
 */
@Data
@Builder
public class ExpectedCurrency {
    private String code;
    private String displaySymbol;
    private int decimalPlaces;
    private boolean isBaseCurrency;
    private boolean isActive;
}
