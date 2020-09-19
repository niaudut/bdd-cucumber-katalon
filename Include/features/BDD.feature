Feature: Login Feature

  #Scenario: Test login with valid credentials
    #Given User navigates to login page
    #When User input username and password
    #And Click on login button
    #Then User is navigated to homepage

    Scenario Outline: Test login with valid credentials
    Given User navigates to login page
    When User input <username> and <password>
    And Click on login button
    Then User is navigated to homepage
    When Click on welcome button
    Then User should see about link
    When User click on admin tab menu
    And Click on nasionalities tab menu
    And Click on add button
    And User input nasionality name
    And Click on save button
    Then User should see new nationality
    When User delete new nationality
    Then User should see notif success deleted
    When Click on my info tab menu
    And Click on edit personal detail button
    And User input middle name, license number, license expiry date, nationality
    And Click on save personal detail button
    Then User should see notif success edited
    
    Examples:
    | username | password                 |
    | Admin    | hUKwJTbofgPU9eVlw/CnDQ== |