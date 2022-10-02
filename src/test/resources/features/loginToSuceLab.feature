@login
Feature: Sauce Demo login

Scenario: valid login
When user enters valid username
And user enters valid password
And user click on login button
Then user should be logged in

Scenario: empty password
When user enters valid username
And user leaves passwors field empty
And user click on login button
Then user should see the error message "Epic sadface: Password is required..." displayed on the screen

Scenario: invalid login
When user enters invalid username as "random_username"
And user enters invalid password as "random_password"
And user click on login button
Then user should see the error message "Epic sadface: Username and password do not match any user in this service"