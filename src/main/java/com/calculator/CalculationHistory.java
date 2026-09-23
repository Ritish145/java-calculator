package com.calculator;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "calculation_history")
public class CalculationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_number")
    private Double firstNumber;

    @Column(name = "second_number")
    private Double secondNumber;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private Double result;

    @Column(name = "status")
    private String status;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public CalculationHistory() {
    }


    public Long getId() {
        return id;
    }


    public Double getFirstNumber() {
        return firstNumber;
    }


    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }


    public Double getSecondNumber() {
        return secondNumber;
    }


    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }


    public String getOperation() {
        return operation;
    }


    public void setOperation(String operation) {
        this.operation = operation;
    }


    public Double getResult() {
        return result;
    }


    public void setResult(Double result) {
        this.result = result;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
