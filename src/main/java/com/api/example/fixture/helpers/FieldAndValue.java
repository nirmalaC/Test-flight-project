package com.api.example.fixture.helpers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by dwebb on 12/12/2016.
 */
@Builder
public class FieldAndValue {

    public FieldAndValue(String field, String value)
    {
        this.setField(field);
        this.setValue(value);
    }

    @Getter
    @Setter
    String field;
    @Getter
    @Setter
    String value;

}
