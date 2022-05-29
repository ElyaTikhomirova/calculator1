package pro.skycalculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping("/calculator")
public class WelcomeController {
    private final CalculatorInterface calculatorService;

    public WelcomeController(CalculatorInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) int a, @RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Нет параметра";
        }
        return buildString(a, b, calculatorService.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) int a, @RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Нет параметра";
        }
            return buildString(a, b, calculatorService.minus(a, b), "-");
        }

        @GetMapping("/multiply")
        public String multiply ( @RequestParam(value = "num1", required = false) int a,
        @RequestParam(value = "num2", required = false) int b){
            if (Objects.isNull(a) || Objects.isNull(b)) {
                return "Нет параметра";
            }
                return buildString(a, b, calculatorService.multiply(a, b), "*");
            }


    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) int a,
                         @RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Нет параметра";
        }
            if (b == 0) {
                return "На ноль делить нельзя";
            } else {
                return buildString(a, b, calculatorService.divide(a, b), "/");
            }
    }

        private String buildString(int a, int b, int result, String operation){
        return a + " " + operation + " " + b + " = " + result;

        }
    }

