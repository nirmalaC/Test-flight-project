package com.api.example.fixture.invoke.pathparams;

import lombok.Builder;
import lombok.Data;

/**
 * Created by daniel on 28/11/2016.
 */
@Data
@Builder
public class GetBookingPathParams extends PathParameters implements IPathParameters {

    private String bookingId;

    @Override
    public String get() {
        if (isPopulated(bookingId)) {
            return bookingId;
        }
        return null;
    }
}
