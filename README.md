# BookMyShow Backend

## Project Description
BookMyShowBackend is a Spring Boot application designed to manage the backend operations for a movie booking platform. The application integrates with Swagger UI for API documentation and testing and includes email functionality for notifications and confirmations. MySQL is used as the database, with JPA and Hibernate handling data persistence.

## Features

- Movie and show management
- Booking management
- Integration with Swagger UI for API documentation
- Email notifications for booking confirmations
- Data persistence using JPA and Hibernate
- MySQL as the database

## Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Swagger UI
- JavaMailSender (for email integration)
- Docker

## Prerequisites

- Java 11 or higher
- Maven
- MySQL
- Postman (for checking endpoints easily)
- Docker & Docker Compose

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/bookMyShowBackend.git
cd bookMyShowBackend
```

### Configure the Database

Create a MySQL database named `cinemaDb`.

Update the `application.properties` file located in `src/main/resources` with your MySQL database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cinemaDb?createTableIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Configure Email Properties

Add your email configuration in the `application.properties` file:

```properties
spring.mail.host=smtp.your-email-provider.com
spring.mail.port=587
spring.mail.username=your_email@example.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### Access Swagger UI

Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

## API Endpoints

The API endpoints are documented and can be tested using the Swagger UI interface. Some key endpoints include:

- `/movie/updateMovie` - Update movie information
- `/movie/addMovies` - Add movies to database
- `/Theater/associateSeats` - Associate physical seats with the theater
- `/Theater/addTheater` - Add new theater
- `/users/addUser` - Add new users
- `/ticket/bookTicket` - Book a ticket
- `/ticket/generateTicket` - Generate a booked ticket
- `/shows/add` - Add a show to the theater

## Email Notifications

The application sends email notifications for booking confirmations. Ensure the email configurations are correctly set in the `application.properties` file for this feature to work.

## Database Schema

The application uses JPA and Hibernate to manage the database schema. Tables include:

- `Movie` - Stores movie information
- `Show` - Stores show details
- `ShowSeat` - Stores seat type details and status
- `Theater` - Stores theater details
- `TheaterSeat` - Stores theater seats
- `Ticket` - Stores ticket information
- `User` - Stores user information

---

# Docker Images Repository Overview

## Repository Structure
The Docker repository for the **BookMyShow-Backend** project contains multiple images to ensure modularity, scalability, and ease of deployment. The repository includes the following images:

1. **bookmyshow-backend** - The primary Spring Boot backend application.
2. **mysql-db** - The MySQL database image.

## Docker Images

### 1. BookMyShow Backend Image (`bookmyshow-backend`)

**Description:** This image contains the Spring Boot backend service, packaged as a Docker container for easy deployment.

**Dockerfile:**
```dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/bookmyshow-backend.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
```

**Build & Push:**
```sh
docker build -t your-dockerhub-username/bookmyshow-backend:latest .
docker push your-dockerhub-username/bookmyshow-backend:latest
```

### 2. MySQL Database Image (`mysql-db`)

**Description:** This image contains a MySQL instance pre-configured for the application.

**Docker Compose Configuration:**
```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    container_name: mysql-db
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: bookmyshow
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql
volumes:
  mysql_data:
```

**Pull & Run:**
```sh
docker pull mysql:8.0
docker-compose up -d
```

---

## Deployment Using Docker Compose
To simplify deployment, use Docker Compose:

```yaml
version: '3.8'
services:
  backend:
    image: your-dockerhub-username/bookmyshow-backend:latest
    container_name: bookmyshow-backend
    ports:
      - "8082:8080"
    depends_on:
      - mysql

  mysql:
    image: mysql:8.0
    container_name: mysql-db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: bookmyshow
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

**Run the Services:**
```sh
docker-compose up -d
```

---

## Repository Structure on Docker Hub
```
bookmyshow-backend
│── latest
│── v1.0.0
│── v1.1.0
│── ...

mysql-db
│── latest
│── v8.0
│── ...
```

This ensures easy versioning, rollback, and scalability of the application. 🚀

## Contact
For any inquiries or issues, please contact [yashpurwar.251198@gmail.com](mailto:yashpurwar.251198@gmail.com).

