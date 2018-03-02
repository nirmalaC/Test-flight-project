package com.api.example.exceptions;

import cucumber.api.PendingException;

/**
 * Created by daniel on 29/11/2016.
 * Custom pending exception with enumerated
 */
public class ExamplePendingException extends PendingException {

    /**
     * @param message enumerated message that you wish to throw
     */
    public ExamplePendingException(EasyJetPendingExceptionMessages message) {
        super(message.get());
    }

    public enum EasyJetPendingExceptionMessages {
        TO_BE_DEVELOPED("This test code has not been developed");

        private String message;

        /**
         * @param message the message string
         */
        EasyJetPendingExceptionMessages(String message) {
            this.message = message;
        }

        /**
         *
         * @return the message string
         */
        public String get() {
            return message;
        }

    }

}
