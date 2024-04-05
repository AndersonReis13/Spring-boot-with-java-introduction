package br.com.anderson.springbootwithjavaintroduction.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multi(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo){
        return numberOne/numberTwo;
    }

    public Double squareRoot(Double number){
       return java.lang.Math.sqrt(number);
    }

}
