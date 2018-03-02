package com.api.example.fixture.invoke.response.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "errors"
})
public class Errors {

    @JsonProperty("errors")
    private List<Error> errors = new ArrayList<Error>();

    /**
     * No args constructor for use in serialization
     */
    public Errors() {
    }

    /**
     * @param errors
     */
    public Errors(List<Error> errors) {
        this.errors = errors;
    }

    /**
     * @return The errors
     */
    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * @param errors The errors
     */
    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Errors withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

}
