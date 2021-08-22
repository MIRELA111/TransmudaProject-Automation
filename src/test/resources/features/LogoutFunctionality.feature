@TRNS-356
Feature: Logout Functionality


  Background:
		#@TRNS-353

    Given the user is on the login page

  @TRNS-354
  Scenario Outline: All users can login with valid credentials
    When the user logged in as "<userType>"
    And the user clicks on logout button inside profile info
    Then the user lands on login page

    Examples:

      |userType     |
      |driver       |
      |sales_manager|
      |store_manager|


  @TRNS-355
  Scenario Outline: All <userType> cannot navigate back to homepage after successful logout

    When the user logged in as "<userType>"
    And the "<userType>" logout successfully
    Then the user cannot go to homepage again after successful logout

    Examples:
      |userType     |
      |driver       |
      |sales_manager|
      |store_manager|






