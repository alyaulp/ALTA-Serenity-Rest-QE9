@Tugas
Feature: Reqres API Automation Testing QE-9

  #NEGATIVE
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id   |
      | 1000 |
      | 222  |