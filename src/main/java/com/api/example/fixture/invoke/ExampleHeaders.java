package com.api.example.fixture.invoke;

import com.api.example.fixture.helpers.DateFormat;
import lombok.Builder;
import lombok.Data;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by webbd on 10/31/2016.
 * this class represents a set of headers that can be sent to a api service
 * it offers builder pattern construction as well as standard getter/setter instantiation
 * the method get() returns a multivaluedMap which can be passed directly into the jersey client, which it is designed
 * to work with
 */
@Builder
@Data
public final class ExampleHeaders {

    private String prefer = null;
    private String xPosId = null;
    private String acceptLanguage = null;
    private String connection = null;
    private String acceptEncoding = null;
    private String xClientTransactionId = null;
    private String acceptCharset = null;
    private String accept = null;
    private String xForwardedFor = null;
    private String date = null;
    private String debug = null;
    private String xTest = null;
    private String xOfficeId = null;
    private String xCorporateId = null;
    private String xApplicationId = null;

    //PLEASE DO NOT ADD ACCEPT-LANGUAGE TO THE GETVALID METHOD
    //IF YOU NEED TO SET THE LANGUAGE, RETURN THE BUILDER AND ADD THE HEADER!!
    public static ExampleHeadersBuilder getValid(String channel) {

        ExampleHeadersBuilder builder  = ExampleHeaders.builder()
                .prefer("FULL")
                .xPosId(channel)
                .connection("keep-alive")
                .acceptEncoding("application/gzip")
                .xClientTransactionId("Test")
                .acceptCharset("UTF-8")
                .accept("application/json")
                .xForwardedFor("123")
                .date(new DateFormat().Today().AsUK());

        try {
            if (System.getProperty("mocked").equals("true")) {
                builder.xTest("true");
            }
        }
        catch(Exception e){}

        if (channel.toLowerCase().startsWith("publicapi"))
        {
            builder.xOfficeId("test")
                .xCorporateId("test")
                .xApplicationId("test");
        }

        return builder;

    }

    public static ExampleHeadersBuilder getBasic(String channel) {
        return ExampleHeaders.builder()
                .date(new DateFormat().Today().AsUK())
                .accept("application/json")
                .xPosId(channel);
    }

    public static ExampleHeadersBuilder getBuilder() {
        return ExampleHeaders.builder();
    }

    /**
     * @return the MultivaluedMap that is required by the jersey client to set the headers for the request
     */
    public MultivaluedMap<String, Object> get() {
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        if (prefer != null) {
            headers.add("Prefer", prefer);
        }
        if (xPosId != null) {
            headers.add("X-POS-Id", xPosId);
        }
        if (acceptLanguage != null) {
            headers.add("Accept-Language", acceptLanguage);
        }
        if (connection != null) {
            headers.add("Connection", connection);
        }
        if (acceptEncoding != null) {
            headers.add("Accept-Encoding", acceptEncoding);
        }
        if (xClientTransactionId != null) {
            headers.add("X-Client-Transaction-id", xClientTransactionId);
        }
        if (acceptCharset != null) {
            headers.add("Accept-Charset", acceptCharset);
        }
        if (accept != null) {
            headers.add("Accept", accept);
        }
        if (xForwardedFor != null) {
            headers.add("X-Forwarded-For", xForwardedFor);
        }
        if (date != null) {
            headers.add("Date", date);
        }
        if (debug != null) {
            headers.add("X-Debug", debug);
        }
        if (xTest != null) {
            headers.add("X-Test", xTest);
        }
        if (xCorporateId!= null) {
            headers.add("X-Corporate-Id", xCorporateId);
        }
        if (xApplicationId != null) {
            headers.add("X-Application-Id", xApplicationId);
        }
        if (xOfficeId != null) {
            headers.add("X-Office-Id", xOfficeId);
        }
        return headers;
    }

}
