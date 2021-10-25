package com.convertorxlstoHtml.demo.exception;

public class UserEntityExistException extends TrueCallerBaseException {
    public UserEntityExistException(String messageValue, Object... messageArgs) {
        super(messageValue, messageArgs);
    }
}
