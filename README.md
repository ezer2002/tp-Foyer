# tp-Foyer

Learning project for Spring Boot. This project focuses on the basics of REST, JPA, and MySQL.

## Tech stack
- Java 17
- Spring Boot 3.5.x
- Spring Web, Spring Data JPA
- MySQL
- Lombok
- Maven

## Prerequisites
- JDK 17
- MySQL running locally
- Maven (or use the Maven Wrapper)

## Configuration
Main settings are in `src/main/resources/application.properties`:
- `spring.datasource.url=jdbc:mysql://localhost:3306/TpFoyer?createDatabaseIfNotExist=true`
- `spring.datasource.username=root`
- `spring.datasource.password=`
- `server.port=8088`
- `server.servlet.context-path=/arctic`

Update the database credentials if needed.

## Run
Windows:
```powershell
.\mvnw.cmd spring-boot:run
```

macOS/Linux:
```bash
./mvnw spring-boot:run
```

Or build a jar:
```bash
./mvnw clean package
java -jar target/tp-Foyer-0.0.1-SNAPSHOT.jar
```

App base URL:
- `http://localhost:8088/arctic`

## Project structure
- `src/main/java/tn/esprit/tpfoyer` Spring Boot application and domain code
- `src/main/resources/application.properties` configuration
- `src/test/java` tests

## Notes
This is a learning project. Default configuration uses a local MySQL instance and creates the database if it does not exist.
