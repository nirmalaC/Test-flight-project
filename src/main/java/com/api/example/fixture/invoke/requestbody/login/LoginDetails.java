package com.api.example.fixture.invoke.requestbody.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "email",
        "password",
        "rememberMe"
})
@Builder
public class LoginDetails implements IRequestBody {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("rememberMe")
    private Boolean rememberMe;

    /**
     * @return The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public LoginDetails withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * @return The password
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDetails withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return The rememberMe
     */
    @JsonProperty("rememberMe")
    public Boolean getRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe The rememberMe
     */
    @JsonProperty("rememberMe")
    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public LoginDetails withRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }

}
