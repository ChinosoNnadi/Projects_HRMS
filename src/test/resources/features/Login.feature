Feature: Login scenarios

  @sprint1 @chinoso @regression @test1
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser