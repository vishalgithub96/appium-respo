package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDragandDrop
{
	public static void main (String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement iframein =  driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframein); 
        List<WebElement>frames= driver.findElements(By.tagName("iframe")) ;
		System.out.println(frames.size());
		Thread.sleep(2000);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(draggable, droppable).perform(); 
		
		
	}

}
