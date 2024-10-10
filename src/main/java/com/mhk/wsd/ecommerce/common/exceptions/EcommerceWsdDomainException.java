package com.mhk.wsd.ecommerce.common.exceptions;

public class EcommerceWsdDomainException extends CustomRootException{
    public EcommerceWsdDomainException(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }

    public EcommerceWsdDomainException(String message) {
        super(message);
    }
}
