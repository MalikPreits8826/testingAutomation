package stepDefination;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class LoginPageSteps {
	
	LoginPage login= new LoginPage();
	
	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String pass) {
	   login.enterUserNameAndPassword(username,pass);
	}


	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   login.clickOnLoginButton();
	}

	@Then("Validate succesful login")
	public void validate_succesful_login() {
	 Assert.assertTrue(login.validateSucessfulLogin());
	}

	@Then ("validate error message")
	public void validate_error_message() {
		Assert.assertTrue(login.validateErrorMessage());
	}

}
