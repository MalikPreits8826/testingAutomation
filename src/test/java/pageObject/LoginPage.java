package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {

	public void enterUserNameAndPassword(String user, String pass) {

		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.sendKeys(user);

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(pass);
	}

	public void clickOnLoginButton() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();
	}

	public boolean validateSucessfulLogin() {
		return driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();

	}

	  public boolean validateErrorMessage() {
		  return driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
	  }
}
