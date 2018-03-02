package com.api.example.fixture.asserters.models;

import lombok.Data;

/**
 * Created by daniel on 11/11/2016.
 */
@Data
public class ExpectedPassenger {
    private String passengerCode;
    private int minAge;
    private int maxAge;
    private int maxPermitted;
}
