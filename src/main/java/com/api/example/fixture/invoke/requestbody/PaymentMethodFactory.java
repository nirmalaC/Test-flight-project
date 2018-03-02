package com.api.example.fixture.invoke.requestbody;

import com.api.example.fixture.invoke.requestbody.commitbooking.PaymentMethod;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.paymentmethods.PaymentMethodsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 28/11/2016.
 */
public class PaymentMethodFactory {

    public static PaymentMethod generatePaymentMethodBodyWithMissingParameter(PaymentMethodsResponse paymentMethodsAvailable, BasketsResponse basket, String parameter) {
        PaymentMethod paymentMethod = generateValidPaymentMethodBody(paymentMethodsAvailable, basket);
        switch (parameter) {
            case ("PaymentMethods"):
                paymentMethod = null;
                break;
            case ("PaymentMethod"):
                paymentMethod.setPaymentMethod(null);
                break;
            case ("PaymentCode"):
                paymentMethod.setPaymentCode(null);
                break;
            case ("PaymentAmount"):
                paymentMethod.setPaymentAmount(null);
                break;
            case ("PaymentCurrency"):
                paymentMethod.setPaymentCurrency(null);
                break;
            case ("PaymentToken"):
                paymentMethod.setToken(null);
                break;
            default:
                throw new IllegalArgumentException("the parameter you provided is not valid.");
        }
        return paymentMethod;
    }

    public static List<PaymentMethod> generatePaymentMethodBodyWithMissingParameterMocked(BasketsResponse basket, String parameter) {

        if (parameter.equals("MissingPaymentMethods")) {
            return new ArrayList<PaymentMethod>();
        }

        List<PaymentMethod> paymentMethods = generatePaymentMethodMocked(basket);

        for (PaymentMethod paymentMethod : paymentMethods) {
            switch (parameter) {
                case ("MissingPaymentMethod"):
                    paymentMethod.setPaymentMethod(null);
                    break;
                case ("MissingPaymentCode"):
                    paymentMethod.setPaymentCode(null);
                    break;
                case ("MissingPaymentAmount"):
                    paymentMethod.setPaymentAmount(null);
                    break;
                case ("MissingPaymentCurrency"):
                    paymentMethod.setPaymentCurrency(null);
                    break;
                case ("MissingPaymentToken"):
                    paymentMethod.setToken(null);
                    break;
                default:
                    throw new IllegalArgumentException("the parameter you provided is not valid.");
            }
        }

        return paymentMethods;
    }

    public static PaymentMethod generateValidPaymentMethodBody(PaymentMethodsResponse paymentMethodsAvailable, BasketsResponse basket) {
        return PaymentMethod.builder()
                .paymentMethod(paymentMethodsAvailable.getPaymentMethods().get(0).getPaymentMethod())
                .paymentCode(paymentMethodsAvailable.getPaymentMethods().get(0).getCode())
                .paymentAmount(basket.getBasket().getTotalAmountWithCreditCard())
                .paymentCurrency(basket.getBasket().getCurrency().getCode())
                .token("343244324")
                .build();

    }

    public static List<PaymentMethod> generatePaymentMethodMocked(BasketsResponse basket) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(PaymentMethod.builder()
                .paymentMethod("CARD")
                .paymentCode("DM")
                .paymentAmount(basket.getBasket().getTotalAmountWithCreditCard())
                .paymentCurrency(basket.getBasket().getCurrency().getCode())
                .savePaymentMethod(true)
                .token("FGSDSFDHD2646346BGSGGS")
                .build()
        );
        return paymentMethods;
    }
}
