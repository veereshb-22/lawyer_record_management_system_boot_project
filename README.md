# Lawyer Record Management System (LRMS)

## Overview
The Lawyer Record Management System (LRMS) is a backend application designed to efficiently manage lawyer-related records. It provides CRUD (Create, Read, Update, Delete) operations 
for handling lawyer information and is built using Spring Boot with Java as the primary programming language.

## Features
CRUD Operations: Create, Read, Update, and Delete lawyer records.

Exception Handling: Includes robust exception handling with custom exceptions (e.g., LawyerDetailsNotFoundException).

RESTful API: Fully functional REST API for seamless integration.

Database Integration: Supports relational databases for data persistence.

Layered Architecture: Follows a clean and maintainable structure (Controller, Service, Repository).

## Technologies Used
1. Java (Spring Boot)

2. Spring MVC

3. Hibernate/JPA

4. PostgresSQL (Database)

5. Maven (Build tool)

6. Postman (API testing)

## Project Structure

lrms/
├── data.json                # Sample data file
├── src/main/java/com/pro/lrms/
│   ├── controller/          # Contains REST API controllers
│   ├── entity/              # Defines JPA entities
│   ├── exception/           # Custom exception classes
│   ├── repository/          # DAO layer for database interactions
│   ├── service/             # Service interfaces
│   ├── serviceimp/          # Service implementations
│   └── LrmsApplication.java # Main Spring Boot application
├── src/main/resources/
│   └── application.properties # Configuration file
├── pom.xml                   # Maven build file
└── lrms.sql                  # SQL file for database schema

## API Endpoints

Base URL: /api/lawyers

      * GET /getlawyer: Retrieve all lawyer records
      
      * GET /{lawyerID}: Retrieve lawyer details by ID
      
      * POST /postdata: Create a new lawyer record
      
      * PUT /status/{lawyerID}: Change the status of a lawyer (active/inactive)
      
      * DELETE /delete/{lawyerID}: Delete a lawyer record by ID
      
      * GET /summary: Retrieve a summary of lawyers, including calculated metrics such as win ratio
      
      * GET /active: Retrieve all active lawyers
      
      * GET /domain/{domain}: Retrieve a list of lawyers based on their domain of expertise

## How to Run

  ### Prerequisites

      * Java 17+ 
      
      * Maven
      
      * PostgresSQL Database
      
      * IDE (Spring Tool Suite or Eclipse)

      * PostMan
  
  ### Steps
  
      1. Clone the repository:
      
            git clone https://github.com/veereshb-22/lawyer_record_management_system_boot_project.git
     
      2. Navigate to the project directory:
      
            cd lawyer_record_management_system_boot_project
      
      3. Set up the database:
      
            *  Import the lrms.sql file into your PostgreSQL database.
     
            *  Update application.properties with your database credentials.
     
      4. Build and run the project:
      
            mvn spring-boot:run
      
      5. Access the API via Postman or any HTTP client at
      
            http://localhost:8080/api/lawyers


## Sample Data
   { 
        "lawyerID": "LID002",
        "lawyerName": "Ravi Kumar",
        "lawyerNumber": "8480759962",
        "laywerAddress": "WhiteField,Bengaluru",
        "lawyerDomain": "Divorce",
        "laywerCase": 30,
        "lawyerExperienece": 7,
        "lawyerWinRatio": 0.78,
        "lawyerLicenseNumber": "KA129032",
        "lawyerStatus": "Active"
    }


## License

   ### This project is licensed under the MIT License:
          MIT License

            Copyright (c) 2025 Veeresh B
            
            Permission is hereby granted, free of charge, to any person obtaining a copy
            of this software and associated documentation files (the "Software"), to deal
            in the Software without restriction, including without limitation the rights
            to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
            copies of the Software, and to permit persons to whom the Software is
            furnished to do so, subject to the following conditions:
            
            The above copyright notice and this permission notice shall be included in all
            copies or substantial portions of the Software.
            
            THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
            IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
            FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
            AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
            LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
            OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
            SOFTWARE.

            
  ## Developer Contact
    
    For any queries or contributions, feel free to reach out:
    
      Developer: Veeresh B 
      
      Email: veerub231@gmail.com
      
      GitHub: veereshb-22
  
  
