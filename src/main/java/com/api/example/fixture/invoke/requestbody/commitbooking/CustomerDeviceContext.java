package com.api.example.fixture.invoke.requestbody.commitbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "ipAddress",
        "operationalSystem",
        "device"
})
@Builder
public class CustomerDeviceContext {

    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("operationalSystem")
    private String operationalSystem;
    @JsonProperty("device")
    private String device;

    /**
     * @return The ipAddress
     */
    @JsonProperty("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress The ipAddress
     */
    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return The operationalSystem
     */
    @JsonProperty("operationalSystem")
    public String getOperationalSystem() {
        return operationalSystem;
    }

    /**
     * @param operationalSystem The operationalSystem
     */
    @JsonProperty("operationalSystem")
    public void setOperationalSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    /**
     * @return The device
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * @param device The device
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

}
