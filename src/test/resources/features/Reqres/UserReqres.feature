@Tugas
Feature: Reqres API Automation Testing QE-9

#POSITIVE
  @Tugas
  Scenario: Get single user with valid paremeter id
    Given Get single user with valid parameter id 2
    When Send request get single user
    Then Status code should be 200 OK
    And Response body first name should be "Janet" and last name is "Weaver"
    And Validate get single user valid json schema

#NEGATIVE
  @Tugas
  Scenario: Get single user with invalid paremeter id
    Given Get single user with valid parameter id 1000
    When Send request get single user
    Then Status code should be 404 Not Found

  @Tugas
  Scenario: Get single user not found
    Given Get single user with valid parameter id 23
    When Send request get single user
    Then Status code should be 404 Not Found
#    And Response body should be null

  @Tugas
  Scenario: Get single user blank id
    Given Get single user with valid parameter id 0
    When Send request get single user
    Then Status code should be 404 Not Found
