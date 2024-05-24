package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickMultiMouseOver 
{
	public static void main(String[] args) 
	{
		
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement image = driver.findElement(By.xpath("//p[2]/img"));
		new Actions(driver).contextClick(image).perform();
	WebElement productinfo	= driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']"));
	Actions action = new Actions(driver);
	action.moveToElement(productinfo).perform();
		
	}

}
