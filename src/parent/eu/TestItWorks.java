package parent.eu;

import static org.testng.AssertJUnit.assertTrue;

import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

public class TestItWorks extends TestBase{

	
	private static final int dayInMillis = 86400000;
	HomePage home;
	LoginPage login;
	InstitutionPage institutionPage;
	SideMenu sideMenu;
	CalenderPage calenderPage;
	NewEventPage newEventPage;
	@Override
	protected void innerSetup() {
		login = new LoginPage(driver);
		home= new HomePage(driver);
		institutionPage = new InstitutionPage(driver);
		sideMenu = new SideMenu(driver);
		calenderPage = new CalenderPage(driver);
		newEventPage = new NewEventPage(driver);
		login.baseUrl=siteUrl;
	}
	
	@Test
	public void testAddEventToInstitute1() throws InterruptedException{
		String instituteName = "Institution 1";
		login.navigateToLogin();
		login.doLogin("demo@parent.eu", "123456");
		home.assertAtHomePage();
		home.navigateToInstitution(instituteName);
		Thread.sleep(1000);
		institutionPage.assertInInstitutionPage(instituteName.toUpperCase());
		sideMenu.clickMenuByName("calendar");
		Thread.sleep(1000);
		calenderPage.addNewEvent();
		//newEventPage.addNewEventData();
		long timestamp= System.currentTimeMillis();
		String eventTitle = timestamp+": An Event Title";
		String eventDesc = "Event description";
		//The event date to be 1 day after today 
		String eventDate = getFormatedDate(timestamp+dayInMillis);
		String recipientName = "cat";
		//reply date is today
		String eventReplyDate = getFormatedDate(timestamp);
		newEventPage.addEventData(
				eventTitle, 
				eventDesc, 
				eventDate, 
				recipientName, 
				eventReplyDate);
		Thread.sleep(1000);
		calenderPage.assertNowInClenderPage();
		assertTrue(calenderPage.isEventPresent(eventTitle.toLowerCase()));
	}
	
	//@Test
	public void testEventCreated() throws InterruptedException{
		login.navigateToLogin();
		login.doLogin("demo@parent.eu", "123456");
		home.assertAtHomePage();
		String instituteName = "Institution 1";
		home.navigateToInstitution(instituteName);
		Thread.sleep(1000);
		institutionPage.assertInInstitutionPage(instituteName.toUpperCase());
		sideMenu.clickMenuByName("calendar");
		Thread.sleep(1000);
//		calPage.addNewEvent();
//		newEventPage.addNewEvent();
//		Thread.sleep(1000);
		calenderPage.assertNowInClenderPage();
		assertTrue(calenderPage.isEventPresent("An Event Title".toLowerCase()));
	}
	
	public static String getFormatedDate(long myTime) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MMM/yyyy");
		String myDate = dateFormatter.format(myTime);
		return myDate;
	}	

}
