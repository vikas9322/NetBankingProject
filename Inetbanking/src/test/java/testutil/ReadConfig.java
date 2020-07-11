package testutil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop;
	
	 public ReadConfig()  
	{
		File src = new File(".\\src\\main\\java\\config\\config.properties");
		
		FileInputStream fs;
		try {
			fs = new FileInputStream(src);
			prop = new Properties();
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("url");
		return url;
		
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
		
	}
	
	public String getPasword()
	{
		String pasword = prop.getProperty("pasword");
		return pasword;
		
	}
	
	public String getChromepath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
		
	}
	public String getFirefoxpath()
	{
		String firefoxoath = prop.getProperty("firefoxpath");
		return firefoxoath;
		
	}
	
	
	
}
