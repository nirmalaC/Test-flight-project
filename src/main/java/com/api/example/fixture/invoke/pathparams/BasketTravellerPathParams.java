package com.api.example.fixture.invoke.pathparams;

import lombok.Builder;

/**
 * Created by daniel on 28/11/2016.
 */
@Builder
public class BasketTravellerPathParams extends PathParameters implements IPathParameters {

    private String basketId;
    private String travellerId;

    @Override
    public String get() {
        String parameters = "";
        if (isPopulated(basketId)) {
            parameters += basketId;
        } else {
            throw new IllegalArgumentException("You must specify a basketId for this service.");
        }
        if (isPopulated(travellerId)) {
            parameters += "/travellers/" + travellerId;
        } else {
            parameters += "/travellers";
        }
        return parameters;
    }
}
