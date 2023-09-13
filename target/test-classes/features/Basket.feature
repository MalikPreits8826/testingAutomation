Feature: Baseket Functionlity




@Smoke
Scenario: Add to cart from PLP
When user enter "standard_user" and "secret_sauce"
And user clicks on login button
And user add product into the cart
Then validate cart count is "1"
