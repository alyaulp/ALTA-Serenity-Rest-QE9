@Tugas
Feature: Reqres API Automation Testing QE-9

#POSITIVE
  @Tugas
  Scenario: Post register new user successful with valid data
    Given Register new user with valid json
    When Send request post register user
    Then Status code should be 200 Created
    And Respose body id should be 4 and token is "QpwL5tke4Pnpja7X4"
    And Validate post register json schema

#NEGATIVE
  @Tugas
  Scenario: Post register new user unsuccessful with invalid data
    Given Register new user with invalid json
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Respose body error should be "Missing password"
    And Validate post register invalid json schema

  @Tugas
  Scenario: register new user with invalid email
    Given Register new user with blank email and valid password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing email or username"
    And Validate post register invalid json schema

  @Tugas
  Scenario: register new user with invalid email and invalid password
    Given Register new user with blank email and blank password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing email or username"
    And Validate post register invalid json schema
