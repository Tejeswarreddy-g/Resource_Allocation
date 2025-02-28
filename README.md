Resource Allocation System:
-----------------------------------

Project Overview:
------------------

The Resource Allocation System is a Spring Boot application that manages resources (employees) 
based on their skills and experience. It provides APIs to retrieve resources that match specific 
skill sets for microservice and cloud-based projects.

Technologies Used:
------------------

Spring Boot (Backend Framework)

MySQL (Database)

Spring Data JPA (ORM for database interactions)

Spring Tool Suite (STS) (IDE for development)

JUnit & Mockito (For testing)

Prerequisites:
--------------

Ensure you have the following installed:

Java 22+ (Download)

Spring Tool Suite (STS) (Download)

MySql 8.0+ (Download)

Maven (Bundled with STS or install separately)

Postman or Browser (To test API endpoints)

Database Setup:
---------------
1. Start MySql and create database:

Run the following command to create the database:

CREATE DATABASE resource_db;

Verify the database is created:

SHOW DATABASES; -- Lists all databases

2️. Update application.properties:

Ensure your src/main/resources/application.properties file has the correct MySQL configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/resource_db
spring.datasource.username=root (your database username)
spring.datasource.password=******** (your database password)
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Running the Application in STS:
-------------------------------

1️. Import Project into STS

Open Spring Tool Suite (STS).

Click File → Import → Existing Maven Projects.

Select the project folder and click Finish.

Wait for dependencies to resolve.

2️. Run the Application

Open ResourceAllocationApplication.java.

Right-click → Run As → Spring Boot App.

Wait for the console to display:

Tomcat started on port 8080
Started ResourceAllocationApplication in X.XXX seconds

Testing the API Endpoints:
--------------------------

Use Postman or your browser to test the API endpoints.

1️. Get Resources for a Microservice Project

📌 Endpoint:

GET http://localhost:8080/api/resources/microservice

📌 Expected Response:

[
    {
        "id": 2,
        "name": "Thompson",
        "experience": 7,
        "skills": [
            "Java",
            "REST API",
            "JavaScript",
            "Redis",
            "Oracle",
            "React",
            "Angular"
        ]
    },
    {
        "id": 6,
        "name": "Kumar",
        "experience": 3,
        "skills": [
            "Java",
            "MySQL",
            "JavaScript",
            "Redis"
        ]
    }
]

2️. Get Resources for a Cloud Project

📌 Endpoint:

GET http://localhost:8080/api/resources/cloud

📌 Expected Response:

[
    {
        "id": 1,
        "name": "Dennis",
        "experience": 4,
        "skills": [
            "Java",
            "JMS",
            "Docker",
            "MySQL",
            "Spring",
            "React",
            "Angular",
            "Web Services",
            "Nodejs"
        ]
    },
    {
        "id": 4,
        "name": "Aisha",
        "experience": 9,
        "skills": [
            "REST API",
            "Docker",
            "PostgreSQL",
            "JavaScript",
            "MySQL",
            "SQL Server",
            "Spring",
            "React",
            "Angular",
            "Nodejs",
            "Web Services"
        ]
    }
]

Running Tests:
--------------

To run JUnit tests, execute the following in the terminal inside the project folder:

1️. Open Terminal in STS

Right-click on the project folder in STS.

Click Show In → Local Terminal.

The terminal will open inside the project folder.

2️. Run Tests

mvn test

✅ Expected Output:

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS

📌 Additional Notes

If you manually update the database, restart the application to reflect changes.

If mvn test fails, check your MySQL connection and schema.

Modify test cases in src/test/java/com/resourceallocation/service/ResourceServiceTest.java as needed.

📩 Contact & Support

For any issues, feel free to raise a question.

+919441968281 | tejeswarreddy.2003@gmail.com

