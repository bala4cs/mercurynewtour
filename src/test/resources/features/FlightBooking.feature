Feature: FlightBooking
  Use this below scenarios to test the flight booking options

  @SMOKE
  Scenario: Validate the flight booking option with the valid data
    Given Login to the application with the username and password
      | mercury | mercury |
    When Provide the flight details
      | Type          | oneway   |
      | Passenger     |        2 |
      | DepartingFrom | London   |
      | DepartingTo   | New York |
    And Provide the Preference details
      | Service | Business            |
      | Airline | Blue Skies Airlines |
    When click the continue button from flight finder page
    And click the continue button from the select flight page
    And Book a flight with mandatory params
      | FirstName  | Balakrishnan   |
      | LastName   | Ammaiappan     |
      | CardNumber | 98765412365789 |
    Then verify the itinerary has been booked
    
