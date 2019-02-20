# new feature
# Tags: optional
@TestngScenario
Feature: Login functionality

  Background:
    Given I am on the home page

  Scenario Outline: Verify Login Functionality
    Then I fill UserID with "<uid>" and Password with "<password>"
    And I click Login
    Then I should see "<heading>" heading
    Examples:
      | uid | password | heading |
      | mngr177129 | byqunar | Guru99 Bank Manager HomePage |
      | wrongusername | test | Guru99 Bank Home Page |


