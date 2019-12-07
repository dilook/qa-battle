@login
Feature: Login

  Scenario: Log in to application with existing username and password
    Given login page is opened
    When enter username test
    And enter password test
    And hover over 'Hover me faster!' button
    And click 'Sign in' button
    And click 'OK' in first alert popup
    And click 'OK' in second alert popup
    Then existing client page is opened

  Scenario Outline: Log in to application wrong username/password
    Given login page is opened
    When enter username <username>
    And enter password <password>
    And hover over 'Hover me faster!' button
    And click 'Sign in' button
    And click 'OK' in first alert popup
    And click 'OK' in second alert popup
    Then check login failed message

    Examples:
      | username       | password       |
      | test           | wrong_password |
      | wrong_username | test           |

  Scenario Outline: Log in to application with empty username/password
    Given login page is opened
    And enter username test
    And enter password test
    And hover over 'Hover me faster!' button
    And wait for 'Sign in' button is visible
    When clear <input>
    And click 'Sign in' button
    Then check validation for <input> text input

    Examples:
      | input    |
      | username |
      | password |
