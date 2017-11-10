package parent.eu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
	private By txtUserEmail = By.id(LoginLocators.getString("LoginPage.txtUserName")); //$NON-NLS-1$
	private By txtPassword = By.id(LoginLocators.getString("LoginPage.txtPassword")); //$NON-NLS-1$
	private By popupError = By.cssSelector(LoginLocators.getString("LoginPage.lblError")); //$NON-NLS-1$
	private By btnLogin = By.id(LoginLocators.getString("LoginPage.btnLogin")); //$NON-NLS-1$
	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
	}
	public void  navigateToLogin(){
		driver.get(baseUrl );//+ LoginLocators.getString("LoginPage.pathLogin")); //$NON-NLS-1$
	}
	
	public void doLogin(String userMail, String userPswrd) {
		txtType(txtUserEmail,userMail);
		txtType(txtPassword,userPswrd);		
		driver.findElement(btnLogin).click();
	}
	
}
