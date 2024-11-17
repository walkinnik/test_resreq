Feature: Get a user from ReqRes API

  # Positive case
  Scenario: Update a user successfully
    Given I set the base URL for the ReqRes API
    When I send patch request to update a user with id 1
    Then I should receive a response with status code 200
    And the response body should contain current date

  # Negative case
  # API always returns 200