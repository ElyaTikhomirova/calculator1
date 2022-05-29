package pro.skycalculator.calculator;

import org.springframework.stereotype.Service;
@Service
public class CalculatorService implements CalculatorInterface {

    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }
    public int plus( int a, int b){
        return a+b;
    }
    public int minus (int a, int b) {
        return a-b;
    }
    public int multiply (int a, int b){
    return a*b;
    }
    public int divide(int a, int b){
    return a/b;
    }
}

