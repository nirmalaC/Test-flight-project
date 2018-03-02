package com.api.example.fixture.asserters.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by daniel on 11/11/2016.
 */
@Data
@AllArgsConstructor
public class ExpectedError {
    private String parameter;
    private String code;
    private String message;
}