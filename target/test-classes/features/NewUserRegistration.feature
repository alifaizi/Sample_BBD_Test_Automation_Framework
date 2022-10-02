 @RegisteringNewAccount
Feature: New User Registeration
 
  Scenario: Register with Tekschool Test Environment Website
    Given I am on Test Environment Home Page
    When I click on My Account button
    And I click on register link
    And I fill the registration form
    And I subscribe to newsletter
    And I agree to privacy policy
    And I click on continue button
    Then I validate my account is created successfully
