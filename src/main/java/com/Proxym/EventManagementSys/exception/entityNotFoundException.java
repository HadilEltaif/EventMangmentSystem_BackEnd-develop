package com.Proxym.EventManagementSys.exception;

import lombok.Getter;

public class entityNotFoundException extends RuntimeException {

    @Getter
    private com.Proxym.EventManagementSys.exception.errorCodes errorCodes;

    public entityNotFoundException(String message ){
        super(message);
    }

    public entityNotFoundException(String message , Throwable cause){
        super(message,cause);
    }

    public entityNotFoundException(String message , Throwable cause, com.Proxym.EventManagementSys.exception.errorCodes errorCodes ){
        super(message,cause);
        this .errorCodes =errorCodes;
    }

    public entityNotFoundException(String message , com.Proxym.EventManagementSys.exception.errorCodes errorCodes){
        super(message);
        this.errorCodes=errorCodes;
    }

}
