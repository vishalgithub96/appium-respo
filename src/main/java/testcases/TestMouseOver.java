package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestMouseOver 
{
    public static void main (String[] args) 
    {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.carwale.com/");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement menu = driver.findElement(By.xpath("//*[text()='NEW CARS']"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[text()='Find New Cars']")).click();
        
        
    	
    }

}
