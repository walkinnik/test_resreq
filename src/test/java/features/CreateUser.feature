Feature: Create a user on ReqRes API

  # Positive case
  Scenario: Create a user successfully
    Given I set the base URL for the ReqRes API
    When I send a POST request to create a user with name "John Doe" and job "Software Engineer"
    Then I should receive a response with status code 201
    And the response body should contain the name "John Doe"
    And the response body should contain the job "Software Engineer"

  # Negative case
  # API always returns 200