# URL Shortener with Spring Boot

## Overview
This is a URL Shortener application built using **Spring Boot**, following a clean software architecture with best practices such as Layered Architecture, SOLID principles, and proper exception handling.

## Features
- Shorten long URLs into unique short URLs.
- Retrieve original URLs using shortened versions.
- Basic validation and error handling.
- H2 in-memory database for development.
- RESTful API with structured responses.

---

## Technologies Used
- **Java 21**
- **Spring Boot 3.4.2**
    - Spring Web
    - Spring Data JPA
    - H2 Database
    - Spring Security
- **Maven**
- **Lombok**

---

## Project Structure
```
url.shortener/
│-- src/main/java/com/url/shortener
│   ├── UrlShortenerApplication.java
│   ├── config/
│   │   ├── SecurityConfig.java
│   ├── controller/
│   │   ├── UrlShortenerController.java
│   ├── service/
│   │   ├── UrlShortenerService.java
│   │   ├── impl/
│   │   │   ├── UrlShortenerServiceImpl.java
│   ├── repository/
│   │   ├── UrlRepository.java
│   ├── domain/
│   │   ├── Url.java
│   ├── dto/
│   │   ├── UrlRequestDto.java
│   │   ├── UrlResponseDto.java
│   ├── exception/
│   │   ├── UrlNotFoundException.java
│   │   ├── GlobalExceptionHandler.java
│   ├── util/
│   │   ├── HashingUtil.java
│-- src/main/resources
│   ├── application.yml
└── pom.xml
```

---

## Installation and Setup

### Prerequisites
- Install **Java 21**
- Install **Maven**

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/thanthtooaung-coding/url-shortener.git
   cd url-shortener
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the API via:
    - H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:urlshortenerdb`)

---

## API Endpoints

### 1. Shorten URL
**Endpoint:**
```
POST /api/urls/shorten
```
**Request Body:**
```json
{
  "originalUrl": "https://www.example.com"
}
```
**Response:**
```json
{
  "shortUrl": "abc123"
}
```

### 2. Retrieve Original URL
**Endpoint:**
```
GET /api/urls/{shortUrl}
```
**Response:**
```json
"https://www.example.com"
```

### 3. Invalid URL Handling
**Response:**
```json
{
  "message": "Shortened URL not found"
}
```

---

## Configuration

**`application.yml` Example:**
```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:urlshortenerdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
      
logging:
  level:
    root: INFO
    org.springframework: DEBUG

shortener:
  base-url: http://localhost:8080/
  hash-length: 8
```

---

## Testing
To test the application, you can use:
- **Postman**: Create API requests to shorten and retrieve URLs.
- **cURL**: Example usage:
  ```bash
  curl -X POST http://localhost:8080/api/urls/shorten -H "Content-Type: application/json" -d '{"originalUrl":"https://www.example.com"}'
  ```

---

## Future Improvements
- Integrate with Swagger UI for API documentation.
- Add Redis caching for better performance.
- Implement custom expiration for shortened URLs.
- Develop a frontend using Vue.js or React.
- Add user authentication for personalized URL tracking.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For any queries, please contact [thanthtoo1285@gmail.com](mailto:thanthtoo1285@gmail.com).