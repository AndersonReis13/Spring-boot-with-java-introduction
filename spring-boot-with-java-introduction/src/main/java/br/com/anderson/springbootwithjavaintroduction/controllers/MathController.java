package br.com.anderson.springbootwithjavaintroduction.controllers;

import br.com.anderson.springbootwithjavaintroduction.NumberConverter;
import br.com.anderson.springbootwithjavaintroduction.exceptions.UnsupportedMathExceptions;
import br.com.anderson.springbootwithjavaintroduction.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {

    private static final String template = "Hello, %s!";

    private final AtomicLong numberTwo = new AtomicLong();

    private SimpleMath math = new SimpleMath();
    private NumberConverter converter = new NumberConverter();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
             @PathVariable(value = "numberOne") String numberOne,
             @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return math.sum(converter.convertDouble(numberOne), converter.convertDouble(numberTwo));
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return math.sub(converter.convertDouble(numberOne), converter.convertDouble(numberTwo));
    }

    @RequestMapping(value = "multi/{numberOne}/{numberTwo}")
    public Double multi(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo){
        if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return math.multi(converter.convertDouble(numberOne), converter.convertDouble(numberTwo));
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo){
        if(!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return math.div(converter.convertDouble(numberOne), converter.convertDouble(numberTwo));
    }

    @RequestMapping(value = "square/{numberOne}")
    public Double square(@PathVariable(value = "numberOne") String numberOne) {
        if(!converter.isNumeric(numberOne)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return math.squareRoot(converter.convertDouble(numberOne));
    }
}
