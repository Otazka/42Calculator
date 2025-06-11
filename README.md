# 42Calculator API

A straightforward RESTful API built with Java Spring Boot, providing basic arithmetic operations: addition, subtraction, multiplication, and division. Each operation has its own dedicated endpoint, returning results in a consistent JSON format.

## Features

- **Dedicated Endpoints**: One specific endpoint for each operator (`/add`, `/subtract`, `/multiply`, `/divide`).
- **JSON Responses**: All responses (success and error) return a clean JSON object.
- **Clear HTTP Status Codes**:
  - `200 OK`: For successful operations.
  - `400 Bad Request`: For invalid client input (e.g., division by zero).
  - `404 Not Found`: When an incorrect or non-existent API endpoint is called.
  - `500 Internal Server Error`: For unexpected server-side issues during a calculation.

## Technologies Used

- **Java 17+**: The core programming language.
- **Spring Boot 3.2.3**: The framework for building robust, standalone applications.
- **Maven**: The primary build automation tool.
- **JUnit 5 & MockMvc**: For comprehensive testing of both core logic and API endpoints.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:
- Java Development Kit (JDK) 17 or higher
- Maven
- Your preferred Integrated Development Environment (IDE) like IntelliJ IDEA, VS Code, or Eclipse.

### Installation

1. Clone the repository:
```bash
git clone https://github.com/Otazka/42Calculator.git
cd 42Calculator
```

2. Build the project:
```bash
mvn clean install
```

### Running the Application

Once built, you can run the Spring Boot application:

1. From your IDE:
   - Open the project in your IDE.
   - Locate the `Application.java` file (in `src/main/java/com/example/_calculator/`).
   - Run the main method directly.

2. From the command line:
```bash
mvn spring-boot:run
```

The application will launch and be accessible at `http://localhost:8080` by default.

## API Endpoints

All calculator operations are exposed via GET requests. Each endpoint expects two query parameters: `operand1` and `operand2`.

The base URL for all API calls is `http://localhost:8080/api`.

### ➕ Addition

Adds two numbers.

- **Endpoint**: `/add`
- **Example Request**: `http://localhost:8080/api/add?operand1=10&operand2=5`
- **Example Success Response** (HTTP 200 OK):
```json
{
  "operand1": 10.0,
  "operand2": 5.0,
  "operator": "add",
  "result": 15.0
}
```

### ➖ Subtraction

Subtracts the second number from the first.

- **Endpoint**: `/subtract`
- **Example Request**: `http://localhost:8080/api/subtract?operand1=10&operand2=5`
- **Example Success Response** (HTTP 200 OK):
```json
{
  "operand1": 10.0,
  "operand2": 5.0,
  "operator": "subtract",
  "result": 5.0
}
```

### ✖️ Multiplication

Multiplies two numbers.

- **Endpoint**: `/multiply`
- **Example Request**: `http://localhost:8080/api/multiply?operand1=2.5&operand2=4`
- **Example Success Response** (HTTP 200 OK):
```json
{
  "operand1": 2.5,
  "operand2": 4.0,
  "operator": "multiply",
  "result": 10.0
}
```

### ➗ Division

Divides the first number by the second.

- **Endpoint**: `/divide`
- **Example Request**: `http://localhost:8080/api/divide?operand1=10&operand2=2`
- **Example Success Response** (HTTP 200 OK):
```json
{
  "operand1": 10.0,
  "operand2": 2.0,
  "operator": "divide",
  "result": 5.0
}
```

## Error Handling

The API provides clear error responses in JSON format for various scenarios:

### Invalid Input (HTTP 400 Bad Request)
```json
{
  "message": "Invalid input parameter: operand1 should be a number",
  "status": 400,
  "error": "Bad Request"
}
```

### Division by Zero (HTTP 400 Bad Request)
```json
{
  "message": "Calculation failed: Division by zero is not allowed",
  "status": 400,
  "error": "Bad Request"
}
```

### Non-existent Endpoint (HTTP 404 Not Found)
```json
{
  "message": "Endpoint not found: /api/adds",
  "status": 404,
  "error": "Not Found"
}
```

### Server Error (HTTP 500 Internal Server Error)
```json
{
  "message": "Calculation failed: [error details]",
  "status": 500,
  "error": "Internal Server Error"
}
```

