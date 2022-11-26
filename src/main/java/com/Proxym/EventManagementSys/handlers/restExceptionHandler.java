package com.Proxym.EventManagementSys.handlers;

import com.Proxym.EventManagementSys.exception.entityNotFoundException;
import com.Proxym.EventManagementSys.exception.invalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class restExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(entityNotFoundException.class)
    public ResponseEntity<errorDto> handleException(entityNotFoundException exception, WebRequest webRequest){
         final HttpStatus notFound = HttpStatus.NOT_FOUND;



        final errorDto errorDto= com.Proxym.EventManagementSys.handlers.errorDto.builder()
                .code(exception.getErrorCodes())
                 .codeHttp(notFound.value())
                 .message(exception.getMessage())
                 .build();

         return new ResponseEntity<>(errorDto,notFound);
    }

    @ExceptionHandler(invalidEntityException.class)
    public ResponseEntity<errorDto>handleException(invalidEntityException exception, WebRequest webRequest)
    {
        final  HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final errorDto errorDto = com.Proxym.EventManagementSys.handlers.errorDto.builder()
                .code(exception.getErrorCodes())
                .codeHttp(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        return  new ResponseEntity<>(errorDto,badRequest);
    }

}
