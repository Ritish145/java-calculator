package com.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operation) {

        return switch (operation) {

            case "add" ->
                    calculator.add(a, b);

            case "subtract" ->
                    calculator.subtract(a, b);

            case "multiply" ->
                    calculator.multiply(a, b);

            case "divide" ->
                    calculator.divide(a, b);

            default ->
                    throw new IllegalArgumentException(
                            "Invalid operation"
                    );
        };
    }
}