package br.com.anderson.springbootwithjavaintroduction;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong numberTwo = new AtomicLong();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
             @PathVariable(value = "numberOne") String numberOne,
             @PathVariable(value = "numberTwo") String numberTwo){
            return 1D;
    }

}
