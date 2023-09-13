package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Name;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	public static Properties pro;
	public static WebDriver driver;

	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/envTest.properties");
			pro = new Properties();
			pro.load(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@After
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot t = (TakesScreenshot) driver;
			File test = t.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(test,
					new File("Screenshots/demo.png")); /*
														 * this will overwrite the photo(screenshot) because everytime
														 * screenshot is captured by the name of demo.. from demo name
														 * everytime a new photo(Ss) will be saved.... so to overcome
														 * this problem, inducing the following change in the code
														 */

			// FileHandler.copy(test, new File("Screenshots/" + s.getName()+".png")); this
			// code will everytime save
			// a ss with different name eg:testcase Name.. s.getname will take the scenario
			// tc name.

		}
		driver.quit();
	}

	public void selectTextByFromDropDown(WebElement ele, String value) {
		Select s1 = new Select(ele);
		s1.selectByVisibleText(value);

	}
	
	public void selectIndexByDropDown(WebElement ele1, int num) {
		Select s= new Select(ele1);
		s.selectByIndex(num);
	}

	public void mouseHover(WebElement ele2) {
		Actions a = new Actions(driver);
		a.moveToElement(ele2);
	}

	public void WaitForExpectedElement(WebElement ele3) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(ele3));

	}

	public void bootstrapDownload(List<WebElement> dropDown, String ExpectedValue) {
		for (WebElement e : dropDown) {
			String value = e.getText();
			if (value.equals(ExpectedValue)) {
				e.click();
				break;
			}

		}
	}

	public void  takescreenshot() throws IOException {
			
			TakesScreenshot t=(TakesScreenshot)driver;
			File test=t.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(test, new File("Screenshots/" +System.currentTimeMillis()+".png"));  // ss on the basis of time..
		
	}
	
	public void javaScriptClick(WebElement ele4) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele4);
		
	}
	
	public void alertPopUp() {
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	public void click(WebElement ele5) {
		try {
			ele5.click();
		}
		catch(Exception e){
			javaScriptClick(ele5);
		}
	}
		
}	
