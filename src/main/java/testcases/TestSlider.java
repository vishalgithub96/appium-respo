package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSlider 
{
	
	public static WebDriver driver;
	
	public static void  captureScreenshot() throws IOException 
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshot/error.jpg"));
	}
	public static void main (String[] args) 
	{
	    driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement iframein =  driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframein); 	
		WebElement divide = driver.findElement(By.xpath("//div[@id='slider']"));
		int width =  divide.getSize().width/3;		
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));	
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
	
		
		
//		
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshot, new File("./screenshot/error.jpg"));
	}
	

	
}
