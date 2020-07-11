package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static WebDriver ldriver;
	
	@FindBy(name="uid")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement loginbutton;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	public void doLogin(String un,String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
	}
	
	
	
	
	
	
	
}
