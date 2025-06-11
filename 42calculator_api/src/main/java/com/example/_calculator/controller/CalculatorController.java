package com.example._calculator.controller;

import com.example._calculator.model.CalculationResult;
import com.example._calculator.model.ErrorResponse;
import com.example._calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as a REST Controller
@RequestMapping("/api") // Base path for all endpoints in this controller
public class CalculatorController {

    private final CalculatorService calculatorService; // Inject CalculatorService

    @Autowired // Spring automatically injects an instance of CalculatorService
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * Endpoint for addition.
     * Example: http://localhost:8080/api/add?operand1=3&operand2=4
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return JSON result of the addition.
     */
    @GetMapping("/add") // Maps HTTP GET requests to /api/add
    public ResponseEntity<?> add(
            @RequestParam double operand1, // Extracts operand1 from query parameter
            @RequestParam double operand2) { // Extracts operand2 from query parameter
        try {
            double result = calculatorService.add(operand1, operand2);
            CalculationResult calculationResult = new CalculationResult(operand1, operand2, "add", result);
            return new ResponseEntity<>(calculationResult, HttpStatus.OK); // Returns 200 OK
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                "Calculation failed: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint for subtraction.
     * Example: http://localhost:8080/api/subtract?operand1=10&operand2=5
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return JSON result of the subtraction.
     */
    @GetMapping("/subtract")
    public ResponseEntity<?> subtract(
            @RequestParam double operand1,
            @RequestParam double operand2) {
        try {
            double result = calculatorService.subtract(operand1, operand2);
            CalculationResult calculationResult = new CalculationResult(operand1, operand2, "subtract", result);
            return new ResponseEntity<>(calculationResult, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                "Calculation failed: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint for multiplication.
     * Example: http://localhost:8080/api/multiply?operand1=2.5&operand2=4
     * @param operand1 The first number.
     * @param operand2 The second number.
     * @return JSON result of the multiplication.
     */
    @GetMapping("/multiply")
    public ResponseEntity<?> multiply(
            @RequestParam double operand1,
            @RequestParam double operand2) {
        try {
            double result = calculatorService.multiply(operand1, operand2);
            CalculationResult calculationResult = new CalculationResult(operand1, operand2, "multiply", result);
            return new ResponseEntity<>(calculationResult, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                "Calculation failed: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint for division.
     * Example: http://localhost:8080/api/divide?operand1=10&operand2=2
     * Handles division by zero.
     * @param operand1 The numerator.
     * @param operand2 The denominator.
     * @return JSON result of the division or an error status if division by zero.
     */
    @GetMapping("/divide")
    public ResponseEntity<?> divide(
            @RequestParam double operand1,
            @RequestParam double operand2) {
        try {
            double result = calculatorService.divide(operand1, operand2);
            CalculationResult calculationResult = new CalculationResult(operand1, operand2, "divide", result);
            return new ResponseEntity<>(calculationResult, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(
                "Calculation failed: " + e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                "Calculation failed: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
