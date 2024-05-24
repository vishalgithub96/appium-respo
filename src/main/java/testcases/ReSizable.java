package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReSizable {

	public static void main (String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement iframein =  driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframein); 
		Thread.sleep(2000);
		
		WebElement half = driver.findElement(By.xpath("//div[@id='resizable']"));
		int  width = half.getSize().width/2;
		WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));	
		
		new Actions(driver).dragAndDropBy(resize, width, 00).perform();
		
		
	}
}
