@Tugas
Feature: Reqres API Automation Testing QE-9

#POSITIVE
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


 #NEGATIVE
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