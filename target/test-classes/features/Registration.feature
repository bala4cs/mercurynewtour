Feature: Registration
  Use this below scenarios to test the registration functionality

  @SMOKE
  Scenario: Validate the registration scenario with the valid data
    Given Open the browser url "REGISTRATION_PAGE"
    And Enter the Contact Information
      | FirstName | Bala              |
      | LastName  | Krishnan          |
      | Phone     |        9876543210 |
      | Email     | mercury@gmail.com |
    And Enter the Mailing Information
      | Address    | Address1   |
      | City       | Coimbatore |
      | State      | TamilNadu  |
      | PostalCode |     641107 |
      | Country    | INDIA      |
    And Enter the User Information
      | UserName        | arun |
      | Password        | arun |
      | ConfirmPassword | arun |
    Then Verify the account creation message "arun"

  @SMOKE
  Scenario: Validate the registration scenario with the mandatory parameter alone
    Given Open the browser url "REGISTRATION_PAGE"
    When Enter the User Information
      | UserName        | arun |
      | Password        | arun |
      | ConfirmPassword | arun |
    Then Verify the account creation message "arun"

  @SMOKE
  Scenario: Validate the registration scenario without the password parameter
    Given Open the browser url "REGISTRATION_PAGE"
    When Enter the User Information
      | UserName        | bala |
      | Password        |      |
      | ConfirmPassword |      |
    Then Verify the account creation message "bala"
