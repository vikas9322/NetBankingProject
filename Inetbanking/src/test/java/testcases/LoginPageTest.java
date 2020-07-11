package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;
import testutil.TestUtil;

public class LoginPageTest extends TestBase{
	
	
	
	

	@Test
	public void doLoginTest() throws IOException
	{
		logger.info("url is initialized");
		
		LoginPage loginPage = new LoginPage(driver);
		logger.info("passing credential");
		loginPage.doLogin(username, password);
		logger.info("Login sucessfull ");
			String actTitle = driver.getTitle();
		if(actTitle.equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("Login test passed");
			Assert.assertTrue(true);
		}
		else
		{
			TestUtil.captureScreen(driver, "doLoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			
		}
		
	}
	
	

}
