package com.convertorxlstoHtml.demo.exception;

import java.text.MessageFormat;

public class TrueCallerBaseException extends Exception {
    private Object[] messageArgs;

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }

    public TrueCallerBaseException(String messageValue, Object... messageArgs) {

        super(MessageFormat.format(messageValue, messageArgs));
        this.messageArgs = messageArgs;
    }

}
