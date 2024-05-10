Feature: Job Title

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in

  @Nnadi
  Scenario: add  new job Title
    When user clicks on admin button
    And user clicks on Job button
    And user clicks on Job Title button
    And user clicks on Add Button
    And user enters jobTitle "SDET014710" desc "Automating  and testing website" note "Exceptional well"
    And user clicks on the save button
    And verify same info from backend