package com.api.example.fixture.invoke.pathparams;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 28/11/2016.
 */
@Builder
public class BasketPathParams extends PathParameters implements IPathParameters {

    private boolean get;
    private boolean empty;
    private String basketId;

    /**
     * @return
     */
    @Override
    public String get() {
        List<String> params = new ArrayList<>();
        if (get && empty) {
            throw new IllegalArgumentException("you have asked to empty and get basket at the same time");
        } else if (!get && !empty) {
            throw new IllegalArgumentException("you have not asked to empty or get basket");
        } else if (get) {
            return basketId;
        } else {
            return basketId + "/empty";
        }
    }
}
