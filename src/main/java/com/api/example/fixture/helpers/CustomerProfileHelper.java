package com.api.example.fixture.helpers;

import com.api.example.database.example.ExampleCustomersDao;
import com.api.example.database.example.models.CustomerModel;
import com.api.example.exceptions.ExampleCompromisedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import static com.api.example.exceptions.ExampleCompromisedException.ExampleCompromisedExceptionMessages.NO_CUSTOMER_DATA_IN_EXAMPLE;


/**
 * Created by dwebb on 12/2/2016.
 */
@Component
public class CustomerProfileHelper {

    private ExampleCustomersDao exampleCustomerDao;

    @Autowired
    public CustomerProfileHelper(ExampleCustomersDao exampleCustomerDao) {
        this.exampleCustomerDao = exampleCustomerDao;
    }

    static <T> T getRandomItem(List<T> list) throws Throwable {
        Random rand = new Random(System.currentTimeMillis());
        try {
            return list.get(rand.nextInt(list.size()));
        } catch (Exception ex) {
            throw new ExampleCompromisedException(NO_CUSTOMER_DATA_IN_EXAMPLE);
        }
    }

    public CustomerModel findAValidCustomerProfile() throws Throwable {

        return getRandomItem(findValidCustomerProfilesWithShippingAddress());
    }

    public CustomerModel findAValidCustomerProfileWithShippingAddress() throws Throwable {
        return getRandomItem(findValidCustomerProfilesWithShippingAddress());
    }

    public List<CustomerModel> findValidCustomerProfiles() {
        return findValidCustomerProfilesWithShippingAddress();
    }

    private List<CustomerModel> findValidCustomerProfilesWithShippingAddress() {
        return exampleCustomerDao.returnValidCustomerWithShippingAddress();
    }


}
