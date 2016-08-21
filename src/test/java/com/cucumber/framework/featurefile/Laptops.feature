Feature: Adding a laptop to the Cart

  Scenario: Search Laptop and add it to the cart
    Given : I am at the home page
    When : I click on the laptops search filter
    Then : I should be at the laptop search page with "36 items"
    And : The title should be "Laptops" search page
    Then : I select the "APPLE MacBook Pro Retina" with description as "15-inch, 256GB"
    And : Add it to the cart
    Then : Navigate to user details page and provide the following details
      | Destination | Singapore  |
      | Airline     | AirAsia    |
      | FlightNo    | A089       |
      | FlightDate  | 24/08/2016 |
      | FlightTime  | 5:00       |
      | Terminal    | Terminal 1 |
      | FirstName   | Selenium   |
      | LastName    | Java       |
      | Email       | sq@j.com   |
      | Phone       |  121212121 |
