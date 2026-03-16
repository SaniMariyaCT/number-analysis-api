# Number Analysis API

A Spring Boot REST API that analyzes numbers and stores results in a database.

## Features

- Detects if a number is even or odd
- Calculates square of a number
- Checks if a number is prime
- Categorizes numbers into ranges
- Stores results in a database
- Retrieve history of analyzed numbers
- Query history by number
- API documentation using Swagger

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /number/{num} | Analyze a number |
| GET | /numbers | Analyze multiple numbers |
| GET | /numbers/stats | Get statistics |
| GET | /history | Retrieve analysis history |
| GET | /history/{id} | Retrieve record by ID |
| GET | /history/by-number/{number} | Retrieve records for a number |

---

## Run the Project

Clone the repository and run:

```bash
mvn spring-boot:run
```

---

## Swagger Documentation

Open in browser:

```
http://localhost:8080/swagger-ui/index.html
```

You can test all API endpoints directly from the Swagger interface.

---

## Example API Response

```
GET /number/7
```

```json
{
  "number": 7,
  "even": false,
  "square": 49,
  "prime": true,
  "range": "Less than or equal to 10"
}
```

---

## Author

Sani Mariya