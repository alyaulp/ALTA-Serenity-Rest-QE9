@Tugas
Feature: Reqres API Automation Testing QE-9

#POSITIVE
  @Tugas
  Scenario: Post login successful
    Given User login with valid json
    When Send request post login
    Then Status code should be 200 OK
    And Respose body token should be "QpwL5tke4Pnpja7X4"
    And Validate post login json schema

#NEGATIVE
  @Tugas
  Scenario: Post login unsuccessful
    Given User login with invalid json
    When Send request post login
    Then Status code should be 400 Bad Request
    And Respose body error should be "Missing password"
    And Validate post login failed json schema

  @Tugas
  Scenario: User login with invalid email
    Given User login with blank email and valid password
    When Send request post login
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing email or username"
    And Validate post login failed json schema

  @Tugas
  Scenario: User login with invalid email and invalid password
    Given User login with blank email and blank password
    When Send request post login
    Then Status code should be 400 Bad Request
    And Response body error should be "Missing email or username"
    And Validate post login failed json schema
