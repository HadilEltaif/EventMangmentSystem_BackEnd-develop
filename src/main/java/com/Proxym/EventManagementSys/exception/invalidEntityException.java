package com.Proxym.EventManagementSys.exception;

import lombok.Getter;

import java.util.List;

public class invalidEntityException extends RuntimeException{
    @Getter
    private com.Proxym.EventManagementSys.exception.errorCodes errorCodes;
    @Getter
    List<String> errors;


    public invalidEntityException(String message ){
        super(message);
    }

    public invalidEntityException(String message , Throwable cause){
        super(message,cause);
    }

    public invalidEntityException(String message , Throwable cause, com.Proxym.EventManagementSys.exception.errorCodes errorCodes ){
        super(message,cause);
        this .errorCodes =errorCodes;
    }

    public invalidEntityException(String message , com.Proxym.EventManagementSys.exception.errorCodes errorCodes){
        super(message);
        this.errorCodes=errorCodes;
    }

    public invalidEntityException(String message , com.Proxym.EventManagementSys.exception.errorCodes errorCodes , List<String> errors){
        super(message);
        this.errorCodes=errorCodes;
        this .errors=errors;
    }

}
