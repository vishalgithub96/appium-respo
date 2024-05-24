package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle
{
	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	     driver.findElement(By.xpath("//input[@class='signinbtn']")).click();
	     Alert alert = driver.switchTo().alert();
	     System.out.println(alert.getText());
	     Thread.sleep(3000);
	     alert.accept();
	   		 
	}

}
