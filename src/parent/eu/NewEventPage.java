package parent.eu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class NewEventPage extends PageBase {

	private By pageMark = By.xpath("//li[@class='last' and contains(.,'Ny begivenhed')]");
	private By txtTitle = By.id("_title");
	private By txtDescription = By.id("_description");
	private By dateEvntDate = By.id("_date");
	private String startTimeteplate = "div[id=_select_starttime] ul li:nth-child(%d) a label";//"//div[@id='_select_starttime']/ul/li[%d]/a/label";
	private By startTime = By.cssSelector("#_select_starttime .dd-selected-text");
	private By endTime = By.cssSelector("#_select_endtime .dd-selected-text");//linkText("Sluttidspunkt");
	private String endTimeTemplate = "div[id=_select_endtime] ul li:nth-child(%d) a label";
	private By txtRecipients = By.id("_recipients");
	private By list1stRecipientInTheList = By.cssSelector(".text-suggestion:nth-child(1)");
	private By replyDate = By.id("_reply_date");
	public NewEventPage(WebDriver driver) {
		super(driver);
	}

	public void addNewEventData() {

		String eventTitle = "An Event Title";
		String eventDesc = "Event description";
		String eventDate = "12/Nov/2017";
		String recipientName = "cat";
		String eventReplyDate = "13/Nov/2107";
		
		addEventData(eventTitle, eventDesc, eventDate, recipientName, eventReplyDate);
	
		//driver.findElement(By.id("i_file_image")).click();
		//driver.findElement(By.id("i_file_image")).clear();
		//driver.findElement(By.id("i_file_image")).sendKeys("C:\\Temp\\Quality.jpg");
		//driver.findElement(By.id("_send")).click();
	}

	public void addEventData(String eventTitle, String eventDesc, String eventDate, String recipientName,
			String eventReplyDate) {
		driver.findElement(txtTitle).clear();
		driver.findElement(txtTitle).sendKeys(eventTitle);
		driver.findElement(txtDescription).clear();
		driver.findElement(txtDescription).sendKeys(eventDesc);
		driver.findElement(dateEvntDate).click();
		driver.findElement(dateEvntDate).clear();
		driver.findElement(dateEvntDate).sendKeys(eventDate);

		// driver.findElement(By.xpath("//form[@id='frmCalendarEvent']/div/div[3]/div[2]/div/div/ul/li/div/div/table/tbody/tr/td[6]")).click();

		driver.findElement(startTime).click();
		waitALitle();
		String time = String.format(startTimeteplate, 7);
		//driver.findElement(By.cssSelector(time)).click();
		((JavascriptExecutor)driver).executeScript("$('"+time+"').click();");
		this.waitALitle();
		driver.findElement(endTime).click();
		waitALitle();
		time = String.format(endTimeTemplate, 6);
		//driver.findElement(By.xpath(endTimeTemplate)).click();
		((JavascriptExecutor)driver).executeScript("$('"+time+"').click();");
		//Add a recipient
		addRecipient(recipientName);
		
		//
		driver.findElement(replyDate).clear();
		driver.findElement(replyDate).sendKeys(eventReplyDate);
		this.waitALitle();
		
		//driver.findElement(By.id("_send")).click();
		((JavascriptExecutor)driver).executeScript("$('#_send').click();");
	}

	public void addRecipient(String recipientName) {
		driver.findElement(txtRecipients).click();
		driver.findElement(txtRecipients).clear();
		driver.findElement(txtRecipients).sendKeys(recipientName);
		driver.findElement(list1stRecipientInTheList).click();
	}
}
