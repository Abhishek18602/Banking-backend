\### Description



This is a simple Banking Management System built using Spring Boot, Spring Data JPA, and MySQL.

The application demonstrates core CRUD operations on bank accounts such as creating, updating, fetching, and deleting accounts.



It follows a 3-layer architecture (Controller → Service → Repository) and uses DTO-Entity mapping for clean and scalable data transfer between layers.





\### Features



➕ Create Account – Add new accounts



📋 View All Accounts – Retrieve all account records



🔍 View Account by ID – Get specific account details



💰 Update Account Balance – Modify an account’s balance



❌ Delete Account – Remove a customer account





\### Tools

Component	Technology

Backend	Spring Boot 3

Language	Java 17+

ORM	Spring Data JPA (Hibernate)

Database	MySQL

Tools	Maven, IntelliJ IDEA

Lombok	For boilerplate code reduction




\### Project Structure


com.Bank.Banking

│

├── controller        # REST Controllers

├── dto               # Data Transfer Objects

├── entity            # JPA Entities (Database Tables)

├── entity.mapper     # DTO <-> Entity conversion

├── repository        # JPA Repositories

├── service           # Service Interfaces

└── service.impl      # Service Implementations




\### Configuration to use 
git clone https://github.com/<your-username>/Banking-Application.git

git clone https://github.com/<your-username>/Banking-Application.git


spring.datasource.url=jdbc:mysql://localhost:3306/banking\_db

spring.datasource.username=root

spring.datasource.password=yourpassword

mvn spring-boot:run

http://localhost:8080/api/accounts







\## Screenshots



Here are some screenshots from the project:



!\[Screenshot 1](screenshots/Screenshot1.png)

!\[Screenshot 2](screenshots/Screenshot2.png)

!\[Screenshot 3](screenshots/Screenshot3.png)





