package testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import testutil.ReadConfig;
import testutil.TestUtil;

public class TestBase {
	
	ReadConfig readconfig=new ReadConfig();
		
	public 	String url = readconfig.getApplicationURL();
	public 	String username = readconfig.getUsername();
	public	String password = readconfig.getPasword();		
		public static WebDriver driver ;
		public static Logger logger;
		
		@Parameters("browser")
		@BeforeClass
		public void setup(String br)
		{
			logger = Logger.getLogger("ibanking");
			PropertyConfigurator.configure("Log4j.properties");
			if(br.equals("chrome"))
			{
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
				driver=new ChromeDriver();
			}else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
				 driver = new FirefoxDriver();
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAITTIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIMEOUT, TimeUnit.SECONDS);
					
			
		}
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		

}
