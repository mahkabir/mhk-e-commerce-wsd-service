package com.mhk.wsd.ecommerce.common.exceptions;


public abstract class CustomRootException extends RuntimeException {

    private String messageCode;

    public CustomRootException(String messageCode, String messageKey) {
        super(messageKey);
        this.messageCode = messageCode;
    }

    public CustomRootException(String message) {
        super(message);
    }

    public String getMessageCode() {
        return messageCode;
    }

}
