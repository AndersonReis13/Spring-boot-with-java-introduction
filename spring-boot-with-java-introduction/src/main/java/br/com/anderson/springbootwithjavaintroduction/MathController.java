package br.com.anderson.springbootwithjavaintroduction;

import br.com.anderson.springbootwithjavaintroduction.exceptions.UnsupportedMathExceptions;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong numberTwo = new AtomicLong();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
             @PathVariable(value = "numberOne") String numberOne,
             @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
           throw new UnsupportedMathExceptions("Please set a number");
        }
        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    @RequestMapping(value = "multi/{numberOne}/{numberTwo}")
    public Double multi(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return convertDouble(numberOne) * convertDouble(numberTwo);
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return convertDouble(numberOne)/convertDouble(numberTwo);
    }

    @RequestMapping(value = "square/{numberOne}")
    public Double square(@PathVariable(value = "numberOne") String numberOne){
        if(!isNumeric(numberOne)){
            throw new UnsupportedMathExceptions("Please set a number");
        }
        return Math.sqrt(convertDouble(numberOne));
    }

    @RequestMapping(value = "avarage/{numberOne}/")

    private Double convertDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
