@user
Feature: User profile

  Scenario: Saving user first and last name
    Given login page is opened
    And log in to application with authentication token
    When open user profile page
    And enter firstName in First name field
    And enter lastName in Last name field
    And press Save user info button
    Then check user info successfully saved message
    And check user info

  Scenario:  Check validation for saving user info with empty firs/last name
    Given login page is opened
    And log in to application with authentication token
    When open user profile page
    And press Save user info button
    Then check validation for First name input field
    And enter firstName in First name field
    And press Save user info button
    And check validation for Last name input field

  Scenario: Saving payment info
    Given login page is opened
    And log in to application with authentication token
    When open user profile page
    And click on Payment Info
    And enter 1111222233334444 in Card Number field
    And select Visa in payment system dropdown
    And set 10 for day of payment
    And press Save payment info button
    Then check payment info successfully saved message
    And check payment info

  Scenario: Check validation for saving payment info with empty values and default day
    Given login page is opened
    And log in to application with authentication token
    When open user profile page
    And click on Payment Info
    And press Save payment info button
    Then check validation for Card Number input field
    And enter 1111222233334444 in Card Number field
    And press Save payment info button
    And check validation for Payment System input field
    And select MasterCard in payment system dropdown
    And press Save payment info button
    And check payment info successfully saved message
    And check default payment day is displayed
