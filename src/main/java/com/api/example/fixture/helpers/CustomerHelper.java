package com.api.example.fixture.helpers;

import com.api.example.fixture.invoke.ExampleHeaders;
import com.api.example.fixture.invoke.requestbody.RegisterCustomerFactory;
import com.api.example.fixture.invoke.requestbody.login.LoginDetails;
import com.api.example.fixture.invoke.requestbody.registercustomer.RegisterCustomerRequest;
import com.api.example.fixture.invoke.requests.LoginRequest;
import com.api.example.fixture.invoke.requests.RegisterNewCustomerRequest;
import com.api.example.fixture.invoke.services.CustomerProfileService;
import com.api.example.fixture.invoke.services.LoginDetailsService;
import com.api.example.fixture.invoke.services.RegisterCustomerService;
import com.api.example.fixture.invoke.services.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.HttpMethod;

/**
 * Created by AndrewGr on 28/12/2016.
 */

@Component
public class CustomerHelper {

    private static Logger LOG = LogManager.getLogger(CustomerHelper.class);

    private final ServiceFactory serviceFactory;
    private RegisterCustomerFactory registerCustomerFactory;
    private RegisterCustomerService registerCustomerService;
    private CustomerProfileService customerProfileService;
    private LoginDetailsService loginDetailsService;
    private RegisterCustomerRequest request;
    private String knownEmail;

    @Autowired
    public CustomerHelper(RegisterCustomerFactory registerCustomerFactory, ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
        this.registerCustomerFactory = registerCustomerFactory;
    }

    public void aValidRequestToCreateAProfileForCustomer() {
        request = registerCustomerFactory.aDigitalProfile();
    }

    public RegisterCustomerRequest getRequest() {
        return request;
    }

    public void setCustomerPasswordLength(int passwordLength) {
        DataFactory df = new DataFactory();
        request.getPersonalDetails().setPassword(df.getRandomChars(passwordLength));
    }

    public void loginWithValidCredentials() {
        loginWithValidCredentials(null, null, null);
    }

    public void loginWithValidCredentials(String channel) {
        loginWithValidCredentials(channel, null, null);
    }

    public void loginWithInvalidCredentials() {
        String email = "ewjuh88weh@uedgweyewtq.com";
        String password = "ujse83gwev3wy";
        loginWithValidCredentials("", email, password);
    }

    public void loginWithValidCredentials(String channel, String email, String password) {

        if (StringUtils.isBlank(channel)) {
            channel = "Digital";
        }

        if (StringUtils.isBlank(email)) {
            email = request.getPersonalDetails().getEmail();
        }

        if (StringUtils.isBlank(password)) {
            password = request.getPersonalDetails().getPassword();
        }

        LoginDetails loginRequest = LoginDetails.builder().email(email).password(password).rememberMe(false).build();
        loginDetailsService = serviceFactory.get(new LoginRequest(ExampleHeaders.getValid(channel).build(), loginRequest));
        loginDetailsService.invoke();

    }

    public void loginWithInvalidPassword(String channel) {

        if (StringUtils.isBlank(channel)) {
            channel = "Digital";
        }

        LoginDetails loginRequest = LoginDetails.builder().email(request.getPersonalDetails().getEmail()).password("notvalidpass").rememberMe(false).build();
        loginDetailsService = serviceFactory.get(new LoginRequest(ExampleHeaders.getValid(channel).build(), loginRequest));
        loginDetailsService.invoke();

    }

    public LoginDetailsService getLoginDetailsService() {
        return loginDetailsService;
    }

    public void loginWithDifferentEmail(String email) {
        if (StringUtils.isBlank(email)) {
            email = request.getPersonalDetails().getEmail();
        }
        loginWithValidCredentials("", email, null);
    }

    public void customerAccountExistsWithAKnownPassword() {
        request = registerCustomerFactory.aDigitalProfile();
        createCustomerProfileFromRequest(request);
    }

    public void requestCreationOfACustomerProfile() {
        createCustomerProfileFromRequest(request);
    }

    public void createCustomerProfileFromRequest(RegisterCustomerRequest request) {
        registerCustomerService = serviceFactory.get(new RegisterNewCustomerRequest(ExampleHeaders.getValid("Digital").build(), HttpMethod.POST, request));
        registerCustomerService.invoke();
    }

    public RegisterCustomerService getRegisterCustomerService() {
        return registerCustomerService;
    }

    public void customerRequestWithMissingField(String channel, String field) {
        request = registerCustomerFactory.aCustomerRequestWithMissingField(channel, field);
    }

    public void setCustomerPasswordWithSpace() {
        DataFactory df = new DataFactory();
        String password = df.getRandomChars(15);
        password = password.replace(password.charAt(2), ' ');
        request.getPersonalDetails().setPassword(password);
    }

    public void setCustomerPasswordWithAGuessableWord(String password) {
        request.getPersonalDetails().setPassword(password);
    }

    public void setCustomerPasswordWithSymbol(String symbolToInsertIntoPassword) {
        setCustomerProfileFieldWithSymbol("password", symbolToInsertIntoPassword);
    }

    public void setCustomerProfileFieldWithSymbol(String field, String symbol) {
        DataFactory df = new DataFactory();

        char uniChar = '\u0022';
        char symbolToReplace = symbol.charAt(0);

        switch (field) {
            case "password":
                String password = df.getRandomChars(15);
                password = password.replace(password.charAt(2), symbolToReplace);
                request.getPersonalDetails().setPassword(password);
                break;
            case "firstName":
                String firstName = df.getFirstName();
                request.getPersonalDetails().setFirstName(firstName.replace(firstName.charAt(1),symbolToReplace));
                break;
            case "lastName":
                String lastName = df.getLastName();
                request.getPersonalDetails().setLastName(lastName.replace(lastName.charAt(1),symbolToReplace));
                break;
        }
    }

    public void customerAccountExistsWithAKnownEmail() {
        request = registerCustomerFactory.aDigitalProfile();
        knownEmail = request.getPersonalDetails().getEmail();
        createCustomerProfileFromRequest(request);
    }

    public void creatNewCustomerProfielWithpPeviouslyUsedEmail() {
        request = registerCustomerFactory.aDigitalProfile();
        request.getPersonalDetails().setEmail(knownEmail);
        createCustomerProfileFromRequest(request);
    }

    public void creatNewCustomerProfielWithEmail(String email) {
        request = registerCustomerFactory.aDigitalProfile();
        request.getPersonalDetails().setEmail(email);
        createCustomerProfileFromRequest(request);
    }

    public void customerRequestWithFieldAndFieldLength(String field, int length) {

        DataFactory df = new DataFactory();
        String stringDataToUse = df.getRandomText (100);

        switch (field) {
            case "firstName":
                request.getPersonalDetails().setFirstName(stringDataToUse.substring(0,length));
                break;
            case "lastName":
                request.getPersonalDetails().setLastName(stringDataToUse.substring(0,length));
                break;
            case "phoneNumber":
                String phoneNumber;
                if (length == 5) {
                    phoneNumber = Integer.toString(df.getNumberBetween(10000,19999));
                    request.getPersonalDetails().setPhoneNumber(phoneNumber);
                }
                else if (length == 19) {
                    phoneNumber =  Integer.toString(df.getNumberBetween(1000000000,1999999999))+ Integer.toString(df.getNumberBetween(1000000000,1999999990));
                    request.getPersonalDetails().setPhoneNumber(phoneNumber);
                }

                break;
            case "addressLine1":
                request.getContactAddress().get(0).setAddressLine1(stringDataToUse.substring(0,length));
                break;
            case "addressLine2":
                request.getContactAddress().get(0).setAddressLine2(stringDataToUse.substring(0,length));
                break;
            case "city":
                request.getContactAddress().get(0).setCity(stringDataToUse.substring(0,length));
                break;
            case "country":
                request.getContactAddress().get(0).setCountry(stringDataToUse.substring(0,length));
                break;
            case "postalCode":
                request.getContactAddress().get(0).setPostalCode(stringDataToUse.substring(0,length));
                break;
        }

    }
}
