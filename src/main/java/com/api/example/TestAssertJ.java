package com.api.example;

import com.api.example.config.ExampleTestConfig;
import com.api.example.fixture.invoke.response.common.Error;
import com.api.example.fixture.invoke.response.common.Errors;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by AndrewGr on 22/12/2016.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:environments/${environment}.properties")
public class TestAssertJ {

//    protected static Logger LOG = LogManager.getLogger(TestApplication.class);

    @Autowired
    private ExampleTestConfig config;

    @Test
    public void testingAssertJ() {

        String expectedErrorMessage = "Airport";

        Error error1 = new Error();
        error1.withCode("aa1").withMessage("NO Date");
        Error error2 = new Error();
        error2.withCode("aa2").withMessage("No Origin Airport");
        Error error3 = new Error();
        error3.withCode("aa3").withMessage("No Passenger");

        List<Error> err = new ArrayList<Error>();
        //err.add(error1);
        err.add(error2);
       // err.add(error3);

        Errors errors = new Errors(err);
        //errors.setErrors(err);

        assertThat(errors.getErrors()).extracting(Error::getMessage).contains(expectedErrorMessage);

        System.out.println();

    }
}
