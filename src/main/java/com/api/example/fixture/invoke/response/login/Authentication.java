package com.api.example.fixture.invoke.response.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "accessToken",
        "tokenType",
        "expiresIn",
        "refreshToken",
        "scope"
})
public class Authentication {

    @JsonProperty("accessToken")
    private String accessToken;
    @JsonProperty("tokenType")
    private String tokenType;
    @JsonProperty("expiresIn")
    private Integer expiresIn;
    @JsonProperty("refreshToken")
    private String refreshToken;
    @JsonProperty("scope")
    private String scope;

    /**
     * @return The accessToken
     */
    @JsonProperty("accessToken")
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken The accessToken
     */
    @JsonProperty("accessToken")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return The tokenType
     */
    @JsonProperty("tokenType")
    public String getTokenType() {
        return tokenType;
    }

    /**
     * @param tokenType The tokenType
     */
    @JsonProperty("tokenType")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * @return The expiresIn
     */
    @JsonProperty("expiresIn")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn The expiresIn
     */
    @JsonProperty("expiresIn")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * @return The refreshToken
     */
    @JsonProperty("refreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken The refreshToken
     */
    @JsonProperty("refreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return The scope
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * @param scope The scope
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

}
