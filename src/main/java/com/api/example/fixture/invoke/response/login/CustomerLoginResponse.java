package com.api.example.fixture.invoke.response.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.response.IResponse;
import lombok.ToString;

import javax.annotation.Generated;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "authenticationConfirmation"
})
public class CustomerLoginResponse implements IResponse {

    @JsonProperty("authenticationConfirmation")
    private AuthenticationConfirmation authenticationConfirmation;

    /**
     * @return The authenticationConfirmation
     */
    @JsonProperty("authenticationConfirmation")
    public AuthenticationConfirmation getAuthenticationConfirmation() {
        return authenticationConfirmation;
    }

    /**
     * @param authenticationConfirmation The authenticationConfirmation
     */
    @JsonProperty("authenticationConfirmation")
    public void setAuthenticationConfirmation(AuthenticationConfirmation authenticationConfirmation) {
        this.authenticationConfirmation = authenticationConfirmation;
    }

}
