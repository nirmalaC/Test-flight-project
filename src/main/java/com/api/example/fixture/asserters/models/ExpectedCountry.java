package com.api.example.fixture.asserters.models;

import lombok.Data;

/**
 * Created by daniel on 11/11/2016.
 */
@Data
public class ExpectedCountry {
    private String countryCode;
    private boolean isActive;
}