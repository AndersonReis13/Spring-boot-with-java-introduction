package br.com.anderson.springbootwithjavaintroduction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends RuntimeException {
    public ResourceNotFoundExceptions(String msg) {
        super(msg);
    }
}
