package com.api.example.exceptions;

/**
 * Created by dwebb on 12/12/2016.
 * Custom exception class which allows tests errors to be thrown and reported as 'compromised' by Serenity
 */
public class ExampleCompromisedException extends Exception {

    /**
     * @param message the message that you wish to include in the exception being thrown
     */
    public ExampleCompromisedException(ExampleCompromisedExceptionMessages message) {
        super(message.getMessage());
    }

    public ExampleCompromisedException(String message) {
         super(message);
    }

    /**
     * A list of enumerated exception messages
     */
    public enum ExampleCompromisedExceptionMessages {
        INSUFFICIENT_DATA("There was insufficient data available to allow this test to be executed."),
        INSUFFICIENT_CUSTOMER_DATA("There was insufficient customer profiles available in the database."),
        NO_FLIGHTS_IN_OTHERDB("There were no available flights in Other."),
        NO_FLIGHTS_IN_EXAMPLE("There were no available flights in Example"),
        NO_FLIGHTS_IN_OTHERDB_AND_EXAMPLE("There were flights in OtherDB but none of them exist in Example."),
        NO_CUSTOMER_DATA_IN_EXAMPLE("There was no customer data in Example."),
        INSUFFICIENT_UNIQUE_CURRENCY_FLIGHTS("There were not flights with unique base currency"),
        DUPLICATE_BOOKING("A duplicate booking already exists!");

        private String message;

        /**
         * @param message error message string
         */
        ExampleCompromisedExceptionMessages(String message) {
            this.message = message;
        }

        /**
         *
         * @return the error message from the enum
         */
        public String getMessage() {
            return message;
        }

    }
}
