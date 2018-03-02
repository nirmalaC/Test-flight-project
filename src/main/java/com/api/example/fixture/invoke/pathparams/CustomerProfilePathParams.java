package com.api.example.fixture.invoke.pathparams;

import lombok.Builder;

/**
 * Created by dwebb on 12/2/2016.
 */
@Builder
public class CustomerProfilePathParams extends PathParameters implements IPathParameters {

    private String profileId;

    @Override
    public String get() {
        return profileId + "/profile";
    }

}
