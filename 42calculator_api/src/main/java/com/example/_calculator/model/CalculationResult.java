package com.example._calculator.model;

import java.io.Serializable;

public class CalculationResult implements Serializable {

    private double operand1;
    private double operand2;
    private String operator;
    private double result;

    // Default constructor (required by Jackson for JSON deserialization if needed)
    public CalculationResult() {
    }

    // Parameterized constructor
    public CalculationResult(double operand1, double operand2, String operator, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
    }

    // Getters and Setters (essential for Jackson to serialize to JSON)
    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    // Optional: toString() for logging/debugging
    @Override
    public String toString() {
        return "CalculationResult{" +
               "operand1=" + operand1 +
               ", operand2=" + operand2 +
               ", operator='" + operator + '\'' +
               ", result=" + result +
               '}';
    }
}
