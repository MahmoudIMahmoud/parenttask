package parent.eu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;
	protected String baseUrl ="https://staging.parent.eu";//LoginLocators.getString("LoginPage.baseUrl");
	WebDriverWait wait;
	public void txtType(By locator,String txt) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(txt);
	}
//	public PageBase() {
//		super();
//		
//	}

	public PageBase(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);		
	}

	public void waitALitle() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}