# ReqRes API Testing Project

This repository contains an automated test suite for the ReqRes API, utilizing **Cucumber**, **RestAssured**, and **TestNG** to validate API functionalities.

---

## **Test Framework**
- **Cucumber**: Behavior-driven development (BDD) framework.
- **RestAssured**: Java library for testing RESTful APIs.
- **TestNG**: Testing framework for managing and executing tests.
- **Java**: Programming language used for writing the test scripts.

---

## **Prerequisites**

1. **Java 11 or Above**  
   Ensure Java is installed on your system. Verify with:
   ```bash
   java -version
   javac -version

2. **MAVEN**
   Maven is required for dependency management and test execution. Verify its installation with:
   ``` bash
   mv -v

3. ReqRes API
   The tests are build to validate the endpoints available on ReqRes API:
* Base URL: https://reqres.in/api

--- 

## **Setting Up the Project** ## 

--- 

## **Test Structure** ##
### Features Tested ###

1. Create User:
   * Sends a POST request to create a user with a name and job.
   * Validates response status code and checks if the name and job match the request payload.

2. Get User:
   * Sends a GET request to retrieve user details by ID.
   * (Validates status code and verifies the email, first name, and last name.

3. Update User:
   * Sends a PATCH request to update a user’s details.
   * Validates status code and checks if the updatedAt field contains the current date.

4. Delete User:
   * Sends a DELETE request to remove a user by ID.
   * Validates response status code.

---

## **Configuration** ##
### The test suite utilizes the following configuration for seamless execution: ###

1. Dependencies: Defined in pom.xml, including:
    * Cucumber: For BDD.
    * RestAssured: For REST API testing.
    * ExtentReports: For detailed test reports.
    * JSON-Simple: For building JSON payloads.

2. TestRunner:
    * Executes all feature files.

--- 

## **Licence** ##
This project is not licensed.
    
 
