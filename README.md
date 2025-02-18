# BookMyShowBackend

## Project Description

BookMyShowBackend is a Spring Boot application designed to manage the backend operations for a movie booking platform. The application integrates with Swagger UI for API documentation and testing, and includes email functionality for notifications and confirmations. MySQL is used as the database, with JPA and Hibernate handling data persistence.

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

## Prerequisites

- Java 11 or higher
- Maven
- MySQL
- postman (for checking endpoints easily).

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

- `/movie/updateMovie` - update movie information
- `/movie/addMovies` - adds movies to db
- `/Theater/associateSeats` - assosiate the physical seats to the theater
- `/Theater/addTheater` - adds new Theater
- `/users/addUser` - adds new Users
- `/ticket/bookTicket` - for booking ticket
- `/ticket/generateTicket` - generates the ticket booked
- `shows\add` - for adding a show into theater

## Email Notifications

The application sends email notifications for booking confirmations. Ensure the email configurations are correctly set in the `application.properties` file for this feature to work.

## Database Schema

The application uses JPA and Hibernate to manage the database schema. Tables include:

- `Movie` - Stores movie information
- `Show` - Stores show details
- `ShowSeat` - stores seatType details and status
- `Theater` - Stores theater details
- `TheaterSeat` - stores theater seats
- `Ticket` - stores information of tickets
- `User` - stores user information

## Contact

For any inquiries or issues, please contact [prathik7890@gmail.com ](mailto:prathik7890@gmail.com).

---

This `README.md` file provides an overview of the BookMyShowBackend project, detailing its features, technologies used, and instructions for setting up and running the application.
