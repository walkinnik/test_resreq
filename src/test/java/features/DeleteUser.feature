Feature: Delete a user from ReqRes API

  Background:
    Given I set the base URL for the ReqRes API

  @Positive
  Scenario: Delete a user successfully
    When I send patch request to delete a user with id 1
    Then I should receive a response with status code 204

  # Negative case
  # API always returns 204