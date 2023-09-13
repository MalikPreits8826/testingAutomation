Feature: Login Funtionlity




@Reg
Scenario: login with valid details
When user enter "standard_user" and "secret_sauce"
And user clicks on login button
Then Validate succesful login

