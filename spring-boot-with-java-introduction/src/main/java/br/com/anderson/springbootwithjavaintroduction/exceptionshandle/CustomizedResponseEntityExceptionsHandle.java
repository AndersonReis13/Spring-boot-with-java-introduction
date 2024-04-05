package br.com.anderson.springbootwithjavaintroduction.exceptionshandle;

import br.com.anderson.springbootwithjavaintroduction.exceptions.ExceptionsResponse;
import br.com.anderson.springbootwithjavaintroduction.exceptions.UnsupportedMathExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.rmi.server.ExportException;
import java.util.Date;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionsHandle extends ResponseStatusExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionsResponse> handleAllExceptions(Exception ex,
                                                                        WebRequest request){
            ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
                    new Date(),
                    ex.getMessage(),
                    request.getDescription(false));
            return new ResponseEntity<>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathExceptions.class)
    public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions(Exception ex,
                                                                        WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
            return new ResponseEntity<>(exceptionsResponse, HttpStatus.BAD_REQUEST);
    }

}
