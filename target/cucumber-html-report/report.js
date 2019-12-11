$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CheckLogin.feature");
formatter.feature({
  "line": 1,
  "name": "TestLogin",
  "description": "Use this below scenarios to test the login functionality",
  "id": "testlogin",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Validate the login scenario with the valid user name and password",
  "description": "",
  "id": "testlogin;validate-the-login-scenario-with-the-valid-user-name-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@SMOKE"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Open the browser url \"LOGIN_URL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Enter the username and password",
  "rows": [
    {
      "cells": [
        "mercury",
        "mercury"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click the Sign-In button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Verify the url \"LANDING_PAGE\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN_URL",
      "offset": 22
    }
  ],
  "location": "LandingPageSteps.open_the_browser_url(String)"
});
formatter.result({
  "duration": 3644396200,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.enter_the_username_and_password(DataTable)"
});
formatter.result({
  "duration": 168378400,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.click_the_Sign_In_button()"
});
formatter.result({
  "duration": 88003570600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LANDING_PAGE",
      "offset": 16
    }
  ],
  "location": "LandingPageSteps.verify_the_url(String)"
});
formatter.result({
  "duration": 10217500,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify the login details with the invalid details",
  "description": "",
  "id": "testlogin;verify-the-login-details-with-the-invalid-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@SMOKE"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "Open the browser url \"LOGIN_URL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Enter the username and password",
  "rows": [
    {
      "cells": [
        "invalidUserName",
        "mercury"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Click the Sign-In button",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Verify the url \"SIGNON_PAGE\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN_URL",
      "offset": 22
    }
  ],
  "location": "LandingPageSteps.open_the_browser_url(String)"
});
formatter.result({
  "duration": 622215000,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.enter_the_username_and_password(DataTable)"
});
formatter.result({
  "duration": 147601400,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.click_the_Sign_In_button()"
});
formatter.result({
  "duration": 1852739400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SIGNON_PAGE",
      "offset": 16
    }
  ],
  "location": "LandingPageSteps.verify_the_url(String)"
});
formatter.result({
  "duration": 8043200,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify the login details with the blank value",
  "description": "",
  "id": "testlogin;verify-the-login-details-with-the-blank-value",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@SMOKE"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "Open the browser url \"LOGIN_URL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "Click the Sign-In button",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "Verify the url \"SIGNON_PAGE\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LOGIN_URL",
      "offset": 22
    }
  ],
  "location": "LandingPageSteps.open_the_browser_url(String)"
});
formatter.result({
  "duration": 628548300,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.click_the_Sign_In_button()"
});
formatter.result({
  "duration": 1913760600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SIGNON_PAGE",
      "offset": 16
    }
  ],
  "location": "LandingPageSteps.verify_the_url(String)"
});
formatter.result({
  "duration": 6066200,
  "status": "passed"
});
formatter.uri("FlightBooking.feature");
formatter.feature({
  "line": 1,
  "name": "FlightBooking",
  "description": "Use this below scenarios to test the flight booking options",
  "id": "flightbooking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Validate the flight booking option with the valid data",
  "description": "",
  "id": "flightbooking;validate-the-flight-booking-option-with-the-valid-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@SMOKE"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Login to the application with the username and password",
  "rows": [
    {
      "cells": [
        "mercury",
        "mercury"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Provide the flight details",
  "rows": [
    {
      "cells": [
        "Type",
        "oneway"
      ],
      "line": 9
    },
    {
      "cells": [
        "Passenger",
        "2"
      ],
      "line": 10
    },
    {
      "cells": [
        "DepartingFrom",
        "London"
      ],
      "line": 11
    },
    {
      "cells": [
        "DepartingTo",
        "New York"
      ],
      "line": 12
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Provide the Preference details",
  "rows": [
    {
      "cells": [
        "Service",
        "Business"
      ],
      "line": 14
    },
    {
      "cells": [
        "Airline",
        "Blue Skies Airlines"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "click the continue button from flight finder page",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "click the continue button from the select flight page",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Book a flight with mandatory params",
  "rows": [
    {
      "cells": [
        "FirstName",
        "Balakrishnan"
      ],
      "line": 19
    },
    {
      "cells": [
        "LastName",
        "Ammaiappan"
      ],
      "line": 20
    },
    {
      "cells": [
        "CardNumber",
        "98765412365789"
      ],
      "line": 21
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "verify the itinerary has been booked",
  "keyword": "Then "
});
formatter.match({
  "location": "GenericSteps.login_to_the_application_with_the_username_and_password(String\u003e)"
});
