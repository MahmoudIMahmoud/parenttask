package parent.eu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends PageBase{
//	driver.findElement(By.linkText("Nyheder")).click();
//  xpath =//a[contains(text(),'Nyheder')]
	
	
	public SideMenu(WebDriver driver) {
		super(driver);
	}
	
	public void clickMenuByName(String name){
		driver.findElement(By.xpath("//ul/li/a[contains(@href,'"+name+"')]")).click();
				//"//h4[.='"+name+"']")).click();
	}
	
}
