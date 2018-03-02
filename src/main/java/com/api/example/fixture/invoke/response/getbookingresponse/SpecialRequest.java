
package com.api.example.fixture.invoke.response.getbookingresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ssrs",
    "remarks"
})
public class SpecialRequest {

    @JsonProperty("ssrs")
    private List<Ssr> ssrs = null;
    @JsonProperty("remarks")
    private List<Remark> remarks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ssrs")
    public List<Ssr> getSsrs() {
        return ssrs;
    }

    @JsonProperty("ssrs")
    public void setSsrs(List<Ssr> ssrs) {
        this.ssrs = ssrs;
    }

    @JsonProperty("remarks")
    public List<Remark> getRemarks() {
        return remarks;
    }

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
