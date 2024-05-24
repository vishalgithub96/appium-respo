package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;



public class TestRelativeLocators {
	public static void main(String[] args) {
			
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://way2automation.com/way2auto_jquery/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	 WebElement above =   driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
	 above.sendKeys("vishal123@gmail.com");
	
	 WebElement below =   driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
	 below.sendKeys("Delhi");
	 
	WebElement rightof = driver.findElement(RelativeLocator.with(By.xpath("(//input[@type='password'])[2]")).toRightOf(By.tagName("label")));
	 rightof.sendKeys("rrr1111");
}
}