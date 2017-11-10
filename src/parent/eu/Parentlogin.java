package parent.eu;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.support.ui.Select;

public class Parentlogin {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private By txtUserEmail = By.id("username");
	private By txtPassword = By.id("password");
	private By popupError = By.cssSelector("div.flash-notice.error");
	private By btnLogin = By.id("_submit");

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		
		driver = new HtmlUnitDriver(true);//ChromeDriver();//FirefoxDriver();
		baseUrl = "https://staging.parent.eu";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testValidLogin(){
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		login.navigateToLogin();
		login.doLogin("demo@parent.eu", "123456");
		home.assertAtHomePage();
	}
	
	public void testNavigateToInstition(){
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		login.navigateToLogin();
		login.doLogin("demo@parent.eu", "123456");
		home.assertAtHomePage();
		home.navigateToInstitution(0);
		
	}

	//@Test
	public void testParentlogin() throws Exception {
		driver.get(baseUrl + "/login");
		String userMail = "demo@parent.eu";
		String userPswrd = "123456";		
		doLogin(userMail, userPswrd);
		assertEquals(driver.findElement(popupError).getText(), "Invalid username and password combination");
	}

	public void doLogin(String userMail, String userPswrd) {
		txtType(txtUserEmail,userMail);
		txtType(txtPassword,userPswrd);
		
		driver.findElement(btnLogin).click();
	}

	public void txtType(By locator,String txt) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(txt);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
