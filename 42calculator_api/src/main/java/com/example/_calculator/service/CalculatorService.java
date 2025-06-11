package com.example._calculator.service;

import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component
public class CalculatorService {

    /**
     * Performs addition of two numbers.
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return The sum of the two numbers.
     */
    public double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    /**
     * Performs subtraction of two numbers.
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return The difference of the two numbers.
     */
    public double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    /**
     * Performs multiplication of two numbers.
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return The product of the two numbers.
     */
    public double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    /**
     * Performs division of two numbers.
     * @param operand1 The numerator.
     * @param operand2 The denominator.
     * @return The quotient of the two numbers.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return operand1 / operand2;
    }
}
