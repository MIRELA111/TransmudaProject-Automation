
Feature: Navigating to specific pages

  Background:
    Given the user is on the login page

    Scenario: ForgotPassword redirect
      When the user clicks on Forgot your password link on the login page
      Then the "Forgot Password" page should be displayed