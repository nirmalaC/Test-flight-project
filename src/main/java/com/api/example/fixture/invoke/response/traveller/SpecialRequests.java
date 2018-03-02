package com.api.example.fixture.invoke.response.traveller;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "ssrs",
        "remarks"
})
@Builder
public class SpecialRequests {

    @JsonProperty("ssrs")
    private List<Ssr> ssrs = new ArrayList<Ssr>();
    @JsonProperty("remarks")
    private List<Remark> remarks = new ArrayList<Remark>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The ssrs
     */
    @JsonProperty("ssrs")
    public List<Ssr> getSsrs() {
        return ssrs;
    }

    /**
     * @param ssrs The ssrs
     */
    @JsonProperty("ssrs")
    public void setSsrs(List<Ssr> ssrs) {
        this.ssrs = ssrs;
    }

    /**
     * @return The remarks
     */
    @JsonProperty("remarks")
    public List<Remark> getRemarks() {
        return remarks;
    }

    /**
     * @param remarks The remarks
     */
    @JsonProperty("remarks")
    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
