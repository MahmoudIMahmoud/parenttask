package parent.eu;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBase {

	protected WebDriver driver;
	protected String siteUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public TestBase() {
		super();
	}

	// "https://staging.parent.eu"
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "Browser", "url" })
	public void setUp(@Optional("chrome") String Browser, @Optional("https://staging.parent.eu") String url) throws Exception {
		if (Browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (Browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("HTMLUnit")) 
			driver = new HtmlUnitDriver(true);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		//driver.get(url);
		this.siteUrl=url;
		innerSetup();
	}

	protected abstract void innerSetup();

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}