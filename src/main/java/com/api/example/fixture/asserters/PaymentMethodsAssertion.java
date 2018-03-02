package com.api.example.fixture.asserters;

import com.api.example.exceptions.ExamplePendingException;
import com.api.example.fixture.asserters.models.ExpectedPaymentMethod;
import com.api.example.fixture.invoke.response.paymentmethods.PaymentMethodsResponse;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for payment methods response object, provides reusable assertions to all tests
 */
public class PaymentMethodsAssertion implements IAssertion {

    private final PaymentMethodsResponse paymentMethodsResponse;

    public PaymentMethodsAssertion(PaymentMethodsResponse paymentMethodsResponse) {
        this.paymentMethodsResponse = paymentMethodsResponse;
    }

    public void paymentMethodsWereReturned() {
        assertThat(paymentMethodsResponse.getPaymentMethods().size()).isGreaterThan(0).withFailMessage("No payment methods were returned.");
    }

    public void thesePaymentMethodsAreReturned(List<ExpectedPaymentMethod> paymentMethods) throws Throwable {
        throw new ExamplePendingException(ExamplePendingException.EasyJetPendingExceptionMessages.TO_BE_DEVELOPED);

    }

    public void thisPaymentMethodWasNotReturned(String paymentMethod) {
        paymentMethodsResponse.getPaymentMethods().get(0).getCode();
        assertThat(paymentMethodsResponse.getPaymentMethods()).extracting("code").doesNotContain(paymentMethod);
    }
}
