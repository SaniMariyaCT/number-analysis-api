# Number Analysis API

Spring Boot REST API that analyzes numbers and stores results in a database.

## Features

- Check if a number is even
- Check if a number is prime
- Calculate square
- Categorize number range
- Store results in database
- Retrieve history of analyzed numbers
- Swagger API documentation

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger / OpenAPI

## API Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html


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