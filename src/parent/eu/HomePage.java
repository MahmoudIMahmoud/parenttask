package parent.eu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {
	private By lblHeader = By.cssSelector(LoginLocators.getString("HomePage.header"));
	private By tblInstitutes = By.cssSelector(LoginLocators.getString("HomePage.institutions"));
	public HomePage(WebDriver driver) {
		super(driver);
	}	
	
	public void assertAtHomePage() {		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(lblHeader));	
	}
	public void navigateToInstitution(int num){
		driver.findElements(tblInstitutes).get(num).click();
	}
	public void navigateToInstitution(String name){
		driver.findElement(By.xpath("//h4[.='"+name+"']")).click();
	}
}
