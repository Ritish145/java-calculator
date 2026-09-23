package com.calculator;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public double calculate(
            double firstNumber,
            double secondNumber,
            String operation) {

        return switch (operation) {

            case "add" ->
                    firstNumber + secondNumber;

            case "subtract" ->
                    firstNumber - secondNumber;

            case "multiply" ->
                    firstNumber * secondNumber;

            case "divide" -> {

                if (secondNumber == 0) {

                    throw new ArithmeticException(
                            "Cannot divide by zero"
                    );

                }

                yield firstNumber / secondNumber;
            }

            default ->
                    throw new IllegalArgumentException(
                            "Unknown operation: " + operation
                    );
        };
    }
}
