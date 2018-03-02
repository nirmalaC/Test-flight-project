package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedError;
import com.api.example.fixture.invoke.response.common.Error;
import com.api.example.fixture.invoke.response.common.Errors;
import org.assertj.core.groups.Tuple;

import java.util.List;


import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for errors response object, provides reusable assertions to all tests
 */
public class ErrorsAssertion implements IAssertion {

    private final Errors errors;

    public ErrorsAssertion(Errors errors) {
        this.errors = errors;
    }

    public void containsText(String expectedErrorMessage) {
        assertThat(errors.getErrors()).extracting("message").contains(expectedErrorMessage);
    }

    public void wereReturned() {
        assertThat(errors.getErrors().size()).isGreaterThan(0);
    }

    public void areReturned(List<ExpectedError> expectedErrors) {
        for (ExpectedError expectedError : expectedErrors) {
            assertThat(errors.getErrors()).extracting("code", "message")
                    .contains(Tuple.tuple(
                            expectedError.getCode(),
                            expectedError.getMessage()));
        }
    }

    public void containsOnly(String code, String message) {
        assertThat(errors.getErrors()).extracting("code", "message")
                .contains(Tuple.tuple(
                        code,
                        message));
    }

    public boolean isNotADuplicateError()
    {
        if (errors.getErrors().get(0).getCode().equals("SVC_100022_2021"))
        {
            return false;
        }
        return true;
    }

    public void isOneOfTheExpectedValidErrors(List<ExpectedError> expectedErrors) {
        for (Error error : errors.getErrors()) {
            boolean errorIsValid = false;
            for (ExpectedError expectedError : expectedErrors) {
                if (error.getCode().equals(expectedError.getCode())
                        && error.getMessage().equals(expectedError.getCode())) {
                    errorIsValid = true;
                }
            }
            assertThat(errorIsValid).isTrue().withFailMessage("The error message was not in the list of expected errors: " + error.toString());
        }

    }

    public void returnedGreaterThan(int numberOfErrors) {
        assertThat(errors.getErrors().size()).isGreaterThan(numberOfErrors);
    }

    public void containedTheCorrectErrorMessageFor(String parameter, List<ExpectedError> validErrors) {
        //set trigger to fail if vlid error does not contain parameter
        boolean errorIsValid = false;
        for (ExpectedError validError : validErrors) {
            if (validError.getParameter().equals(parameter)) {
                assertThat(errors.getErrors()).extracting("code", "message")
                        .contains(Tuple.tuple(
                                validError.getCode(),
                                validError.getMessage()

                        ));
                errorIsValid = true;
            }
        }
        assertThat(errorIsValid).isTrue().withFailMessage("The error message was not in the list of expected errors: " + errors.getErrors().get(0).toString());
    }

    public void containedTheCorrectValueBasedErrorMessageFor(String parameter, List<ExpectedError> validErrors, String value) {
        for (ExpectedError validError : validErrors) {
            if (validError.getParameter().equals(parameter)) {
                assertThat(errors.getErrors()).extracting("code", "message")
                        .contains(Tuple.tuple(
                                validError.getCode(),
                                validError.getMessage().replace("{value}", value)

                        ));
            }
        }
    }

}
