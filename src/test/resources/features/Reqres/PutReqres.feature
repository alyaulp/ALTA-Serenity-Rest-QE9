@Tugas
Feature: Reqres API Automation Testing QE-9

@Tugas
Scenario:Put Update user with blank name
  Given Update user with invalid json and parametera id 2
  When Send request put update user
  Then Status code should be 200 OK

  @Tugas
  Scenario:Put Update user with blank job
    Given Update user with invalid job json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK

  @Tugas
  Scenario:Put Update user with blank name and blank job
    Given Update user with blank name and job, json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK

#bug
  @Tugas
  Scenario:Put Update user with ivalid id
    Given Update user with valid json and parameter id 0
    When Send request put update user
    Then Status code should be 200 OK
