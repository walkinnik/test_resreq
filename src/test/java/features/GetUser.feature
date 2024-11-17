Feature: Get a user from ReqRes API

  # Positive case
  Scenario: Get a user successfully
    Given I set the base URL for the ReqRes API
    When I send get request to retrieve a user with id 1
    Then I should receive a response with status code 200
    And the response body should contain the email "george.bluth@reqres.in"
    And the response body should contain the first name "George"
    And the response body should contain the last name "Bluth"

  # Negative case
  Scenario: Get a user unsuccessfully
    Given I set the base URL for the ReqRes API
    When I send get request to retrieve a user with id 999
    Then I should receive a response with status code 404