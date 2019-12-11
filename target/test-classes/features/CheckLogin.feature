Feature: TestLogin
  Use this below scenarios to test the login functionality

  @SMOKE
  Scenario: Validate the login scenario with the valid user name and password
    Given Open the browser url "LOGIN_URL"
    And Enter the username and password
      | mercury | mercury |
    When Click the Sign-In button
    Then Verify the url "LANDING_PAGE"

  @SMOKE
  Scenario: Verify the login details with the invalid details
    Given Open the browser url "LOGIN_URL"
    And Enter the username and password
      | invalidUserName | mercury |
    When Click the Sign-In button
    Then Verify the url "SIGNON_PAGE"

  @SMOKE
  Scenario: Verify the login details with the blank value
    Given Open the browser url "LOGIN_URL"
    When Click the Sign-In button
    Then Verify the url "SIGNON_PAGE"
