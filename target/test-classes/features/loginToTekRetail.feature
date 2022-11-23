#Created by Jan Ali Faizi for demonstration and learning purposes only.
@loginToTekRetailSite
Feature: Tek School Retail Page login

  Scenario: Validate user is able to login to tek school retail website successfully
    Given User is on Retail website
    And User click on My Account
    When User click on Login
    When user enters username
    And user enters password
    And user clicks on login button
    Then user logged into the tek school retail account successfully
