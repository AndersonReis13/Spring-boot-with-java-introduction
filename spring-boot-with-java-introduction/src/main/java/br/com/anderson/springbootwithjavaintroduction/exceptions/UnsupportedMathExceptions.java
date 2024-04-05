package br.com.anderson.springbootwithjavaintroduction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathExceptions extends RuntimeException {
    public UnsupportedMathExceptions(String msg) {
        super(msg);
    }
}
