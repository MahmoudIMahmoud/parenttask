package parent.eu;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CalenderPage extends PageBase{
	private By pageCalender=By.cssSelector(".mynews.calendar");
	private By createEvent = By.cssSelector(".half.first .arrow");
	private By newEvent = By.xpath("//span[@class='darker' and (contains(.,'Ny begivenhed') or contains(.,'New event'))]");
	private By prev = By.id("prev");
	private By next = By.id("next");
	
	public CalenderPage(WebDriver driver) {
		super(driver);
	}

	public void assertNowInClenderPage(){
		driver.findElement(pageCalender);
	}
	
	public void addNewEvent(){
		driver.findElement(createEvent).click();
		driver.findElement(newEvent).click();
	}
	public void navigatePrev(){
		driver.findElement(prev).click();
	}
	
	public void navigatenext(){
		driver.findElement(next).click();
	}

	public boolean isEventPresent(String eventTitle){
		try{
			driver.findElement(By.xpath((".//div[starts-with(@class,'event_time_title')]//span[contains(.,'"+eventTitle+"')]")));
			return true;
		}catch(Exception ex){
			System.err.println(ex.getMessage());
			return false;
		}
		
	}

	
}
