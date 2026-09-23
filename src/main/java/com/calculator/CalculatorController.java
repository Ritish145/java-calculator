package com.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CalculatorController {

    private final Calculator calculator;

    private final CalculationHistoryRepository historyRepository;


    public CalculatorController(
            Calculator calculator,
            CalculationHistoryRepository historyRepository) {

        this.calculator = calculator;
        this.historyRepository = historyRepository;

    }


    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operation) {

        CalculationHistory history =
                new CalculationHistory();

        history.setFirstNumber(a);

        history.setSecondNumber(b);

        history.setOperation(operation);

        history.setCreatedAt(
                LocalDateTime.now()
        );


        try {

            double result =
                    calculator.calculate(
                            a,
                            b,
                            operation
                    );


            history.setResult(result);

            history.setStatus(
                    "SUCCESS"
            );


            historyRepository.save(
                    history
            );


            return ResponseEntity.ok(
                    Double.toString(result)
            );

        }

        catch (RuntimeException exception) {

            history.setStatus(
                    "ERROR"
            );


            history.setErrorMessage(
                    exception.getMessage()
            );


            historyRepository.save(
                    history
            );


            return ResponseEntity
                    .badRequest()
                    .body(
                            exception.getMessage()
                    );
        }
    }


    @GetMapping("/history")
    public List<CalculationHistory>
    getHistory() {

        return historyRepository
                .findTop50ByOrderByCreatedAtDesc();

    }


    @DeleteMapping("/history")
    public ResponseEntity<String>
    clearHistory() {

        historyRepository.deleteAll();

        return ResponseEntity.ok(
                "History cleared"
        );

    }
}
