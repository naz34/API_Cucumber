Feature: Pet API Testing
  Scenario: Add a new pet
    Given send a POST request to add a pet with the following details:
      |id    | 12345 |
      |name  | Fluffy|
      |status| available|
    Then the response status code should be 200
    And the response body should contain "Fluffy"


  Scenario: Get pet ID
    Given send a GET request to retrieve pet with ID 12345
    Then the response status code should be 200
    And the response body should contain "Fluffy"

  Scenario: Delete pet invalidID
    Given send a DELETE request to delete pet with ID 741
    Then the response status code should be 404
    And the response body should contain "Not Found"



