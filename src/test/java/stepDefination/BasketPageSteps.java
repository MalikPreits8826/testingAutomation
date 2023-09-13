package stepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BasketPage;

public class BasketPageSteps {
	
	BasketPage basket=new BasketPage(); 

	@When("user add product into the cart")
	public void user_add_product_into_the_cart() {
	     basket.addToCart();
	}
	@Then("validate cart count is {string}")
	public void validate_cart_count_is(String count) {
	basket.validateCartCount(count);
	   
	}

	
}
