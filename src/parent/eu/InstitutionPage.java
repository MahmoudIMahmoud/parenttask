package parent.eu;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstitutionPage extends PageBase {
	private By InstitutionSpan = By.cssSelector(".sideOverviewData span");

	public InstitutionPage(WebDriver driver) {
		super(driver);
	}

	public void assertInInstitutionPage(String name) {
		assertEquals(driver.findElement(InstitutionSpan).getText().toLowerCase(), name.toLowerCase());
	}
	
	
	
}
