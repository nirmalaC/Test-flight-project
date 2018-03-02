package com.api.example.fixture.invoke.queryparams;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dwebb on 11/9/2016.
 */
@Data
@Builder
public class FindBookingQueryParams extends QueryParams implements IQueryParams {

    private String referenceNumber = "";
    private String bookingType = "";
    private String bookingStatus = "";
    private String bookingFromDate = "";
    private String bookingToDate = "";
    private String travelFromDate = "";
    private String travelToDate = "";
    private String searchInBooker = "false";
    private String searchInPax = "false";
    private String title = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String postcode = "";
    private String dob = "";
    private String contactNumber = "";
    private String travelDocumentType = "";
    private String travelDocumentNumber = "";
    private String ipAddress = "";
    private String cardNumber = "";
    private String paymentAmount = "";
    private String currencyIsoCode = "";
    private String transactionDate = "";
    private String channel = "";
    private String ejPlusNumber = "";
    private String flightClubNumber = "";
    private String employeeNumber = "";
    private String flightNumber = "";
    private String seatNumber = "";
    private String sequenceNumber = "";
    private String ssrCode = "";
    private String sortField = "";

    public Map<String, String> getParameters() {
        Map<String, String> queryParams = new HashMap<>();
        if (isPopulated(referenceNumber)) {
            queryParams.put("referencenumber", referenceNumber);
        }
        if (isPopulated(bookingType)) {
            queryParams.put("bookingtype", bookingType);
        }
        if (isPopulated(bookingStatus)) {
            queryParams.put("bookingstatus", bookingStatus);
        }
        if (isPopulated(bookingFromDate)) {
            queryParams.put("bookingfromdate", bookingFromDate);
        }
        if (isPopulated(bookingToDate)) {
            queryParams.put("bookingtodate", bookingToDate);
        }
        if (isPopulated(travelFromDate)) {
            queryParams.put("travelfromdate", travelFromDate);
        }
        if (isPopulated(travelToDate)) {
            queryParams.put("traveltodate", travelToDate);
        }
        if (isPopulated(searchInBooker)) {
            queryParams.put("searchinbooker", String.valueOf(searchInBooker));
        }
        if (isPopulated(searchInPax)) {
            queryParams.put("searchinpax", String.valueOf(searchInPax));
        }
        if (isPopulated(title)) {
            queryParams.put("title", title);
        }
        if (isPopulated(firstName)) {
            queryParams.put("firstname", firstName);
        }
        if (isPopulated(lastName)) {
            queryParams.put("lastname", lastName);
        }
        if (isPopulated(email)) {
            queryParams.put("email", email);
        }
        if (isPopulated(postcode)) {
            queryParams.put("postcode", postcode);
        }
        if (isPopulated(contactNumber)) {
            queryParams.put("contactnumber", contactNumber);
        }
        if (isPopulated(dob)) {
            queryParams.put("dob", dob);
        }
        if (isPopulated(travelDocumentNumber)) {
            queryParams.put("traveldocumenttype", travelDocumentNumber);
        }
        if (isPopulated(travelDocumentNumber)) {
            queryParams.put("traveldocumentnumber", travelDocumentNumber);
        }
        if (isPopulated(ipAddress)) {
            queryParams.put("ipaddress", ipAddress);
        }
        if (isPopulated(cardNumber)) {
            queryParams.put("cardnumber", cardNumber);
        }
        if (isPopulated(paymentAmount)) {
            queryParams.put("paymentamount", paymentAmount);
        }
        if (isPopulated(currencyIsoCode)) {
            queryParams.put("currencyisocode", currencyIsoCode);
        }
        if (isPopulated(transactionDate)) {
            queryParams.put("transactiondate", transactionDate);
        }
        if (isPopulated(channel)) {
            queryParams.put("channel", channel);
        }
        if (isPopulated(ejPlusNumber)) {
            queryParams.put("ejplusnumber", ejPlusNumber);
        }
        if (isPopulated(flightClubNumber)) {
            queryParams.put("flightclubnumber", flightClubNumber);
        }
        if (isPopulated(employeeNumber)) {
            queryParams.put("employeenumber", employeeNumber);
        }
        if (isPopulated(flightNumber)) {
            queryParams.put("flightnumber", flightNumber);
        }
        if (isPopulated(seatNumber)) {
            queryParams.put("seatnumber", seatNumber);
        }
        if (isPopulated(sequenceNumber)) {
            queryParams.put("sequencenumber", sequenceNumber);
        }
        if (isPopulated(ssrCode)) {
            queryParams.put("ssrcode", ssrCode);
        }
        if (isPopulated(sortField)) {
            queryParams.put("sortfield", sortField);
        }

        return queryParams;
    }

    public void setParameter(String parameter, String value) {
        switch (parameter) {
            case "referencenumber":
                this.referenceNumber = value;
                break;
            case "bookingtype":
                this.bookingType = value;
                break;
            case "bookingstatus":
                this.bookingStatus = value;
                break;
            case "bookingfromdate":
                this.bookingFromDate = value;
                break;
            case "bookingtodate":
                this.bookingToDate = value;
                break;
            case "travelfromdate":
                this.travelFromDate = value;
                break;
            case "traveltodate":
                this.travelToDate = value;
                break;
            case "searchinbooker":
                this.searchInBooker = value;
                break;
            case "searchinpax":
                this.searchInPax = value;
                break;
            case "title":
                this.title = value;
                break;
            case "firstname":
                this.firstName = value;
                break;
            case "lastname":
                this.lastName = value;
                break;
            case "email":
                this.email = value;
                break;
            case "postcode":
                this.postcode = value;
                break;
            case "dob":
                this.dob = value;
                break;
            case "contactnumber":
                this.contactNumber = value;
                break;
            case "traveldocumenttype":
                this.travelDocumentType = value;
                break;
            case "traveldocumentnumber":
                this.travelDocumentNumber = value;
                break;
            case "ipaddress":
                this.ipAddress = value;
                break;
            case "cardnumber":
                this.cardNumber = value;
                break;
            case "paymentamount":
                this.paymentAmount = value;
                break;
            case "currencyisocode":
                this.currencyIsoCode = value;
                break;
            case "transactiondate":
                this.transactionDate = value;
                break;
            case "channel":
                this.channel = value;
                break;
            case "ejplusnumber":
                this.ejPlusNumber = value;
                break;
            case "flightclubnumber":
                this.flightClubNumber = value;
                break;
            case "employeenumber":
                this.employeeNumber = value;
                break;
            case "flightnumber":
                this.flightNumber = value;
                break;
            case "seatnumber":
                this.seatNumber = value;
                break;
            case "sequencenumber":
                this.sequenceNumber = value;
                break;
            case "ssrcode":
                this.ssrCode = value;
                break;
            case "sortfield":
                this.sortField = value;
                break;
            default:
                throw new IllegalArgumentException("The parameter you have provided is not a valid query parameter for findBooking.  You provided: " + parameter);
        }

    }
}


