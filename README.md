# API Testing for Spotify Web API

![Presentation1](https://github.com/user-attachments/assets/cb1a4196-4dbb-4e91-aa68-87f9fd49bb9f)

API Testing for **Spotify Web API** involves validating various endpoints to ensure they function as expected. This
includes
operations such as user authentication, fetching playlists, searching for tracks, managing playlists, checking
playback status, etc... 

The goal is to verify response codes, data accuracy, and error handling to ensure a seamless experience
for developers integrating Spotify's API into their applications. The objective is to ensure that the API is **robust**,
**reliable**, **secure**, and performs well under different conditions.


---

## Types of Tests Performed

### 1. Functional Testing

Functional testing verifies the correctness of API endpoints based on the expected behavior and functionality.

- **Basic Functional Tests:** Ensure the API endpoint returns correct responses for given inputs.
- **Status Code Verification:** Validate that appropriate status codes (e.g., `200 OK`, `404 Not Found`) are returned.
- **Input Parameter Testing:** Check both required and optional input parameters for different scenarios.
- **Pagination Functionality:** Verify that the API correctly handles pagination parameters (`page`, `limit`, etc.),
  returning the expected number of items per page and enabling navigation across pages.
- **OAuth2 Functional Testing:** Verify that API endpoints requiring OAuth2 tokens respond correctly with valid tokens
  and return appropriate error codes for invalid, expired, or missing tokens.

### 2. Validation Testing

Validation testing focuses on ensuring that the API response is in the correct format and structure.

- **Schema Validation:** Ensure the response matches the expected JSON or XML schema.
- **Data Type Verification:** Check the data types of the fields in the response body.
- **Pagination Schema Validation:** Verify that paginated responses include required fields like `currentPage`,
  `totalPages`, and `totalCount`, and that these fields have the correct data types.

### 3. Integration Testing

Integration testing verifies that the API works correctly when interacting with other systems or services.

- **System Interaction:** Test API calls in the context of the larger application or system.
- **OAuth2 Integration Testing:** Verify the API's interaction with third-party identity providers (e.g., Google, Azure
  AD) during OAuth2 authorization flows.

### 4. Regression Testing

Regression testing ensures that new changes have not broken existing functionality.

- **Test Suite Execution:** Run a set of pre-defined tests after code updates to detect any regressions.

### 5. Unit Testing

Unit testing involves testing individual API endpoints or components in isolation.

- **Isolated Endpoint Testing:** Verify specific endpoints with mocked dependencies.

### 6. Error Handling Testing

Error handling testing checks how the API responds to incorrect inputs and scenarios.

- **Invalid Input Testing:** Validate the API's response to invalid or malformed inputs.
- **OAuth2 Error Handling:** Verify that the API returns proper error codes (`401 Unauthorized`, `403 Forbidden`) for
  invalid, expired, or missing OAuth2 tokens.

### 7. Smoke Testing

Smoke testing performs a quick check to confirm that the API's core functionalities are working.

- **Basic Functionality Check:** Validate key endpoints for immediate feedback on system health.

### 8. Negative Testing

Negative testing checks the API's behavior with invalid, unexpected, or edge-case inputs.

- **Edge Case Scenarios:** Test the API with invalid data, incorrect parameters, or missing fields.

### 9. Security Testing

Security testing ensures that the API is protected against vulnerabilities and unauthorized access.

- **Authentication and Authorization:** Validate that users can only access authorized resources.
- **OAuth2 Security Testing:** Verify secure implementation of OAuth2, including token generation, expiration, and
  renewal. Test various OAuth2 flows (Authorization Code Flow, Implicit Flow, Client Credentials Flow) and validate
  scope-based access control.

### 10. End-to-End Testing

End-to-end testing ensures the complete workflow of the API, covering all integrated components and user flows.

- **Full Workflow Verification:** Validate the entire API flow from start to end, including all related services and
  dependencies.

### 11. Edge Testing

Edge testing focuses on evaluating the API's behavior at the boundaries of input limits.

- **Boundary Value Testing:** Test the API with maximum and minimum allowed values for inputs to identify any issues at
  the edges.

### 12. Data-Driven Testing

Data-driven testing involves using different input datasets to validate the API's response.

- **Multiple Data Set Testing:** Execute tests with various sets of input data to ensure the API handles different
  inputs consistently and correctly.

---

## Tools Used

### Manual Testing

- **Postman**: Used for functional testing, validation, and exploratory testing. It was particularly helpful for
  verifying status codes, parameters, and inspecting responses in a user-friendly interface.

### Automation Testing

- **Java**: Used for scripting the logic of automated tests.
- **Rest Assured**: Used for making API requests and validating responses in automation scripts.
- **TestNG**: Used for managing test execution and reporting results.

---

## Testing Process

1. **Manual Testing**: Conducted exploratory tests, verified individual endpoints, and handled OAuth2 validation
   manually using **Postman**.
2. **Automation Testing**: Automated tests for regression, smoke, end-to-end and data-driven using **Java**, **Rest Assured**,
   and **TestNG**.

---

## Tech Used are:-

- Java
- Rest Assured
- TestNG
- Postman
- Extent Report
- Maven
- Log4j
- Jenkins
- IntelliJ IDE
- Git
- GitHub

---

## HTML Report

![img](https://github.com/user-attachments/assets/c4eac93f-6c26-4bf2-a8f6-95d63469d921)
![img_1](https://github.com/user-attachments/assets/2b94f096-f2a4-4286-8139-9ae8a3081349)
![img_2](https://github.com/user-attachments/assets/d883fbcd-216e-4f26-aafd-a2e95b6f534b)
![img_3](https://github.com/user-attachments/assets/fc22c465-ab71-4b45-a6e1-b8b5bf107182)

---

## Jenkins Result

![screencapture-localhost-8080-job-SpotifyAPIAutomation-11-console-2024-11-18-12_06_55](https://github.com/user-attachments/assets/5a59ad07-fdae-4c69-a501-9a3e7ffcb52f)
