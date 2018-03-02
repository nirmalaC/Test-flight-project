package com.api.example.fixture.invoke.requestbody.commitbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.api.example.fixture.invoke.requestbody.IRequestBody;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "basketCode",
        "bookingType",
        "bookingReason",
        "customerDeviceContext",
        "paymentMethods"
})
@Builder(builderClassName = "CommitBookingBuilder", buildMethodName = "execute", builderMethodName = "build", toBuilder = true)
public class CommitBooking implements IRequestBody {

    @JsonProperty("basketCode")
    private String basketCode;
    @JsonProperty("bookingType")
    private String bookingType;
    @JsonProperty("bookingReason")
    private String bookingReason;
    @JsonProperty("customerDeviceContext")
    private CustomerDeviceContext customerDeviceContext;
    @JsonProperty("paymentMethods")
    private List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();

    /**
     * @return The basketCode
     */
    @JsonProperty("basketCode")
    public String getBasketCode() {
        return basketCode;
    }

    /**
     * @param basketCode The basketCode
     */
    @JsonProperty("basketCode")
    public void setBasketCode(String basketCode) {
        this.basketCode = basketCode;
    }

    /**
     * @return The bookingType
     */
    @JsonProperty("bookingType")
    public String getBookingType() {
        return bookingType;
    }

    /**
     * @param bookingType The bookingType
     */
    @JsonProperty("bookingType")
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    /**
     * @return The bookingReason
     */
    @JsonProperty("bookingReason")
    public String getBookingReason() {
        return bookingReason;
    }

    /**
     * @param bookingReason The bookingReason
     */
    @JsonProperty("bookingReason")
    public void setBookingReason(String bookingReason) {
        this.bookingReason = bookingReason;
    }

    /**
     * @return The customerDeviceContext
     */
    @JsonProperty("customerDeviceContext")
    public CustomerDeviceContext getCustomerDeviceContext() {
        return customerDeviceContext;
    }

    /**
     * @param customerDeviceContext The customerDeviceContext
     */
    @JsonProperty("customerDeviceContext")
    public void setCustomerDeviceContext(CustomerDeviceContext customerDeviceContext) {
        this.customerDeviceContext = customerDeviceContext;
    }

    /**
     * @return The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * @param paymentMethods The paymentMethods
     */
    @JsonProperty("paymentMethods")
    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

}
