package com.api.example.fixture.helpers;

import com.api.example.database.example.models.CustomerModel;
import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.pathparams.CustomerProfilePathParams;
import com.api.example.fixture.invoke.pathparams.GetBookingPathParams;
import com.api.example.fixture.invoke.queryparams.PaymentMethodsQueryParams;
import com.api.example.fixture.invoke.requestbody.PaymentMethodFactory;
import com.api.example.fixture.invoke.requestbody.commitbooking.CommitBooking;
import com.api.example.fixture.invoke.requestbody.commitbooking.CustomerDeviceContext;
import com.api.example.fixture.invoke.requestbody.commitbooking.PaymentMethod;
import com.api.example.fixture.invoke.requests.PaymentMethodsRequest;
import com.api.example.fixture.invoke.requests.ProfileRequest;
import com.api.example.fixture.invoke.requests.booking.CommitBookingRequest;
import com.api.example.fixture.invoke.requests.booking.GetBookingRequest;
import com.api.example.fixture.invoke.response.basket.BasketsResponse;
import com.api.example.fixture.invoke.response.bookingconfirmation.BookingConfirmationResponse;
import com.api.example.fixture.invoke.response.getbookingresponse.GetBookingResponse;
import com.api.example.fixture.invoke.response.paymentmethods.PaymentMethodsResponse;
import com.api.example.fixture.invoke.services.CustomerProfileService;
import com.api.example.fixture.invoke.services.PaymentMethodsService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import com.api.example.fixture.invoke.services.booking.CommitBookingService;
import com.api.example.fixture.invoke.services.booking.GetBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.HttpMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PTR Scaffolder.
 */
@Component
public class BookingHelper {


    private final ServiceFactory serviceFactory;
    private TravellerHelper travellerHelper;
    private BasketHelper basketHelper;
    private CustomerProfileHelper customerProfileHelper;
    private BasketsResponse basket;
    private PaymentMethodsService paymentMethodsService;
    private CommitBookingService commitBookingService;
    private GetBookingService getBookingService;
    private CustomerProfileService customerProfileService;

    @Autowired
    public BookingHelper(ServiceFactory serviceFactory, TravellerHelper travellerHelper, BasketHelper basketHelper, CustomerProfileHelper customerProfileHelper) {
        this.serviceFactory = serviceFactory;
        this.travellerHelper = travellerHelper;
        this.basketHelper = basketHelper;
        this.customerProfileHelper = customerProfileHelper;
    }

    public BasketsResponse getBasketUsed()
    {
        return basket;
    }

    public CommitBookingService getCommitBookingService()
    {
        return commitBookingService;
    }

    public GetBookingService getGetBookingService()
    {
        return getBookingService;
    }

    public CustomerProfileService GetCustomerProfileService(){return customerProfileService;}

    public BookingConfirmationResponse createNewBooking(CommitBookingRequest request) throws Throwable {
        commitBookingService = serviceFactory.get(request);
        commitBookingService.invoke();
        return commitBookingService.getResponse();
    }

    public BookingConfirmationResponse createNewBooking() throws Throwable {
        CommitBookingRequest request = createNewBookingRequestMockPayment();
        return createNewBooking(request);
    }

    public CommitBooking aBooking(BasketsResponse basket, List<PaymentMethod> paymentMethodBody) {
        return CommitBooking.build()
                .basketCode(basket.getBasket().getCode())
                .bookingReason(basket.getBasket().getBookingReason())
                .bookingType(basket.getBasket().getBasketType())
                .customerDeviceContext(
                        CustomerDeviceContext.builder()
                                .device("WHOCARES")
                                .ipAddress("10.10.10.10")
                                .operationalSystem("ZX81")
                                .build()
                )
                .paymentMethods(paymentMethodBody)
                .execute();
    }

    public CommitBookingRequest createNewBookingRequest() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        basket = basketHelper.getBasketService().getResponse();
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), "Digital", basket.getBasket().getCode() );
        //get payment methods
        List<PaymentMethod> paymentMethods = getPaymentMethods();
        return new CommitBookingRequest(ExampleHeaders.getValid("Digital").build(), aBooking(basket, paymentMethods));
    }

    public CommitBookingRequest createNewBookingRequestMockPayment() throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        basket = basketHelper.getBasketService().getResponse();
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), "Digital", basket.getBasket().getCode() );
        //get payment methods
        List<PaymentMethod> paymentMethods = PaymentMethodFactory.generatePaymentMethodMocked(basket);
        //get customer profile
        String customerid = customerProfileHelper.findAValidCustomerProfileWithShippingAddress().getUid();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(customerid).build();
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();
        //commit booking
        return new CommitBookingRequest(ExampleHeaders.getValid("Digital").build(), aBooking(basket, paymentMethods));
    }


    private List<PaymentMethod> getPaymentMethods() throws Throwable {
        PaymentMethodsQueryParams paymentMethodsQueryParams = PaymentMethodsQueryParams.builder().basketId(basketHelper.getBasketService().getResponse().getBasket().getCode())
                .bookingTypeCode("standard_customer").customerId(customerProfileHelper.findAValidCustomerProfileWithShippingAddress().getCustomerid()).build();
        paymentMethodsService = serviceFactory.get(new PaymentMethodsRequest(ExampleHeaders.getValid("Digital").xTest("true").build(), paymentMethodsQueryParams));
        paymentMethodsService.invoke();
        paymentMethodsService.assertThat().paymentMethodsWereReturned();
        PaymentMethodsResponse paymentMethodsAvailable = paymentMethodsService.getResponse();
        PaymentMethod paymentMethodBody = PaymentMethodFactory.generateValidPaymentMethodBody(paymentMethodsAvailable, basket);
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(paymentMethodBody);
        return paymentMethods;
    }

    public CommitBookingRequest createNewBookingRequestWithMissingParameterInPaymentMethodBody(String parameter) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        basket = basketHelper.getBasketService().getResponse();
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), "Digital", basket.getBasket().getCode() );
        //get payment methods
        List<PaymentMethod> paymentMethods = getInvalidPaymentMethods(parameter);
        return new CommitBookingRequest(ExampleHeaders.getValid("Digital").build(), aBooking(basket, paymentMethods));
    }

    private List<PaymentMethod> getInvalidPaymentMethods(String parameter) throws Throwable {
        //PaymentMethodsQueryParams paymentMethodsQueryParams = PaymentMethodsQueryParams.builder().basketId(basketHelper.getBasketService().getResponse().getBasket().getCode())
        //        .bookingTypeCode("standard_customer").customerId(customerProfileHelper.findAValidCustomerProfileWithShippingAddress().getCustomerid()).build();
        //paymentMethodsService = serviceFactory.get(new PaymentMethodsRequest(ExampleHeaders.getValid("Digital").build(), paymentMethodsQueryParams));
        //paymentMethodsService.invoke();
        //PaymentMethodsResponse paymentMethodsAvailable = paymentMethodsService.getResponse();
        //TODO: remove mock when working
        return PaymentMethodFactory.generatePaymentMethodBodyWithMissingParameterMocked(basket, parameter);
    }

    public GetBookingResponse getBookingDetails(String bookingRef) {
        return getBookingDetails(bookingRef, "Digital");
    }

    public GetBookingResponse getBookingDetails(String bookingRef, String channel) {
        GetBookingPathParams params = GetBookingPathParams.builder().bookingId(bookingRef).build();
        getBookingService = serviceFactory.get(new GetBookingRequest(ExampleHeaders.getValid(channel).build(), params));
        getBookingService.invoke();
        return getBookingService.getResponse();
    }

    public CommitBookingRequest createNewBookingRequestForError(String parameter) throws Throwable {
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult");
        basket = basketHelper.getBasketService().getResponse();
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), "Digital", basket.getBasket().getCode() );
        //get a customer profile id
        CustomerModel dbCustomer = customerProfileHelper.findAValidCustomerProfile();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();

        //TODO: refactor this entire things as it's horrible
        if (parameter.startsWith("Invalid") || parameter.startsWith("Payment")) {
            //TODO: remove mock when payment methods working
            List<PaymentMethod> paymentMethods = PaymentMethodFactory.generatePaymentMethodMocked(basket);
            CommitBooking commitBooking = aBooking(basket, paymentMethods);
            switch (parameter) {
                case ("InvalidBasket"):
                    commitBooking.setBasketCode("Sample");
                    break;
                case ("InvalidBookingType"):
                    commitBooking.setBookingType("Sample");
                    break;
                case ("InvalidBookingReason"):
                    commitBooking.setBookingReason("Sample");
                    break;
                case "PaymentMismatched":
                    commitBooking.getPaymentMethods().get(0).setPaymentAmount (Double.parseDouble("1.36"));
                    break;
                case "InvalidPaymentAmount":
                    commitBooking.getPaymentMethods().get(0).setPaymentAmount (Double.parseDouble("-1.00"));
                    break;
                case "InvalidPaymentMethod":
                    commitBooking.getPaymentMethods().get(0).setPaymentMethod("ONIONS");
                    break;
                case "InvalidPaymentCode":
                    commitBooking.getPaymentMethods().get(0).setPaymentCode("SNAILS");
                    break;
            }
            return new CommitBookingRequest(ExampleHeaders.getValid("Digital").build(), commitBooking);
        } else {
            //get payment methods
            List<PaymentMethod> paymentMethods = getInvalidPaymentMethods(parameter);
            return new CommitBookingRequest(ExampleHeaders.getValid("Digital").build(), aBooking(basket, paymentMethods));
        }
    }

    //THIS CREATES A COMPLETE BOOKING FROM SCRATCH
    public CommitBookingRequest createNewBookingRequestForChannel(String theChannel) throws Throwable {
        //find flights, add to basket and update traveller details
        basketHelper.myBasketContainsAFlightWithPassengerMix("1 Adult", theChannel);
        basket = basketHelper.getBasketService().getResponse();
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), theChannel, basket.getBasket().getCode() );

        //get a customer profile id
        CustomerModel dbCustomer = customerProfileHelper.findAValidCustomerProfile();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        //MUST USE CHANNEL HERE
        //TODO: Always check after merge that thi uses CHANNEL
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid(theChannel).build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();

        //TODO: Replace when working
        //get payment methods and create the request
        List<PaymentMethod> paymentMethods = PaymentMethodFactory.generatePaymentMethodMocked(basket); // getPaymentMethods();
        return new CommitBookingRequest(ExampleHeaders.getValid(theChannel).build(), aBooking(basket, paymentMethods));
    }

    public CommitBookingRequest createNewBookingRequestForChannelBasedOnBasket(String channel, BasketsResponse basket) throws Throwable
    {
        basketHelper.updateTravellersForChannel(travellerHelper.CreateValidRequestToAddAllTravellersForBasket(basket), channel, basket.getBasket().getCode() );
        //get a customer profile id
        CustomerModel dbCustomer = customerProfileHelper.findAValidCustomerProfile();
        CustomerProfilePathParams profilePathParams = CustomerProfilePathParams.builder().profileId(dbCustomer.getUid()).build();
        customerProfileService = serviceFactory.get(new ProfileRequest(ExampleHeaders.getValid(channel).build(), HttpMethod.GET, profilePathParams));
        customerProfileService.invoke();

        //TODO: Replace when working
        List<PaymentMethod> paymentMethods = PaymentMethodFactory.generatePaymentMethodMocked(basket); // getPaymentMethods();
        return new CommitBookingRequest(ExampleHeaders.getValid(channel).build(), aBooking(basket, paymentMethods));
    }
}