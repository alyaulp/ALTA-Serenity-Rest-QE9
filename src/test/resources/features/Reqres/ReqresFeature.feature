Feature: Reqres API Automation Testing QE-9
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario: Post create new user with valid json file
      Given Create new user with valid json
      When Send request post create user
      Then Status code should be 201 Created
      And Response body name should be "Alia" and jobs is "QE"
      And Validate post new user json schema

  Scenario: Put update user with valid json and valid parameter id
    Given Update user with valid json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Alia" and jobs is "QE"

  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 11 |
      | 2  |










