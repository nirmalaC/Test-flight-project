package com.api.example.fixture.invoke.requestbody;

import com.api.example.fixture.invoke.requestbody.registercustomer.ContactAddress;
import com.api.example.fixture.invoke.requestbody.registercustomer.PersonalDetails;
import com.api.example.fixture.invoke.requestbody.registercustomer.RegisterCustomerRequest;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by dwebb on 12/15/2016.
 */
@ToString
@Component
public class RegisterCustomerFactory {

    private static Logger LOG = LogManager.getLogger(RegisterCustomerFactory.class);

    private static Random random = new Random(System.currentTimeMillis());

    private static DataFactory df = new DataFactory();

    private static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                if (field.getName().equals(fieldName)) {
                    try {
                        Field fieldx = clazz.getDeclaredField(fieldName);
                        fieldx.setAccessible(true);
                        fieldx.set(object, fieldValue);
                        return true;
                    } catch (NoSuchFieldException e) {
                        clazz = clazz.getSuperclass();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
        return false;
    }

    public static RegisterCustomerRequest aCustomerRequestWithMissingField (String channel, String field) {

        RegisterCustomerRequest request;

        if (channel.equals("Digital")) {
            request = aDigitalProfile();
        } else {
            request = anADProfile();
        }
        switch (field) {
            case "title":
            case "firstName":
            case "lastName":
            case "email":
            case "password":
            case "phoneNumber":
            case "age": set(request.getPersonalDetails(), field, null);
                 break;
            case "contactAddress": set(request, field, null);
            case "addressLine1":
            case "city":
            case "postalCode": set(request.getContactAddress().get(0), field, null);
                break;
            case "optedOutMarketing": set(request, field, null);
                break;
            }
        return request;
    }


    public static RegisterCustomerRequest anADProfile() {
        return aBasicProfile();
    }

    public static RegisterCustomerRequest aDigitalProfile() {
        DataFactory df = new DataFactory();
        RegisterCustomerRequest request = aBasicProfile();
        request.getPersonalDetails().setPassword(df.getRandomChars(15));
        return request;
    }

    public static String getRandomEmail(int length) {
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() < length) {
            buffer.append(shortUUID());
        }

        //this part controls the length of the returned string
        return buffer.substring(0, length) + "@" + buffer.substring(0, length) + ".com";

    }

    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    private static RegisterCustomerRequest aBasicProfile() {
        return RegisterCustomerRequest.builder()
                .personalDetails(
                        PersonalDetails.builder()
                                .age(26)
                                .email(getRandomEmail(10))
                                .firstName(df.getFirstName() + getRandomString(5))
                                .lastName(df.getLastName() + getRandomString(5))
                                .phoneNumber(Integer.toString(df.getNumberBetween(1000000, 1000000000)))
                                .title("mr")
                                .ejPlusCardNumber("")
                                .nifNumber("")
                                .flightClubId("")
                                .flightClubExpiryDate("")
                                .build()
                )
                .contactAddress(
                        new ArrayList<ContactAddress>() {
                            {
                                add(ContactAddress.builder()
                                        .addressLine1(df.getAddressLine2() + getRandomString(5))
                                        .addressLine2(df.getAddressLine2())
                                        .postalCode(df.getRandomChars(6))
                                        .city(getRandomString(6))
                                        .country(df.getCity())
                                        .build());
                            }
                        }
                )
                .optedOutMarketing(
                        new ArrayList<String>() {
                            {
                                add("EASYJET");
                            }
                        }
                )
                .build();
    }
}



