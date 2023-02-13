@Tugas
Feature: Reqres API Automation Testing QE-9

#TUGAS GET
  @Tugas
  Scenario: Get single user with valid paremeter id
    Given Get single user with valid parameter id 2
    When Send request get single user
    Then Status code should be 200 OK
    And Response body first name should be "Janet" and last name is "Weaver"
    And Validate get single user valid json schema

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


  @Tugas
  Scenario: Get list resource user
    Given Get list resource user with valid data
    When Send request get list resource user
    Then Status code should be 200 OK
    And Validate get list Resource body

  @Tugas
  Scenario: Get single resource user
    Given Get single resource user with id 2
    When Send request get single resource user
    Then Status code should be 200 OK
    And Response body id should be 2 and name is "fuchsia rose"
    And Validate get single resource body

  @Tugas
  Scenario: Get single resource not found
    Given Get single resource user with id 23
    When Send request get single resource user
    Then Status code should be 404 Not Found

  @Tugas
  Scenario: Get single resource blank id
    Given Get single resource user with id 0
    When Send request get single resource user
    Then Status code should be 404 Not Found