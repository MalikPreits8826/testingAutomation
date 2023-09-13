package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;


public class BasketPage extends Base {
	
	public void addToCart() {
		
	WebElement addToCartBtn=driver.findElement(By.xpath("(//div[@class='inventory_item'])[1]//button"));
	
			addToCartBtn.click();
		
			 
		
	}
	
	public void validateCartCount(String count) {
WebElement cartCount=driver.findElement(By.xpath("//div[@id='shopping_cart_container']//span"));
     String cartCountText= cartCount.getText();
     Assert.assertEquals(count,cartCountText);
     
	}

}
