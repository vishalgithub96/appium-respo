package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;



public class TestProperties 
{
	private static Properties OR = new Properties();
	private static FileInputStream fis;
	private static Properties config = new Properties();
	private static WebDriver driver;
	private static Logger log = Logger.getLogger(TestProperties.class);
	
	public static void main(String[] args) throws IOException
	{
	
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		log.info("Test case execution started ");
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		
		log.info("OR file loaded ");
		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		
		log.info("Config file loaded ");
	    System.out.println(OR.getProperty("username_ID"));
	    
	    System.out.println(config.getProperty("testsiteurl"));
	    
	    if (config.getProperty("browser").equals("chrome")) {
			 
	    	driver = new ChromeDriver();
	    	log.info("launched chrome browser ");
	    	
		}else if(config.getProperty("browser").equals("firefox")) {
			 
	    	driver = new FirefoxDriver();
	    	log.info("launched firefox browser ");
		}
	    driver.get(config.getProperty("testsiteurl"));
	    log.info("Navigated to: " + config.getProperty("testsiteurl"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
	    
	    driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("trainer@way2Automation");
    	log.info("Entering username as trainer@wayautomation.com");

	    driver.findElement(By.xpath(OR.getProperty("password_xpath"))).sendKeys("hjggfg12");
    	log.info("Entering password as hjggfg12");

	    driver.findElement(By.xpath(OR.getProperty("Login_Xpath"))).click();
	    
	}	
	

}
