package testcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	
	public static void main(String[] args) throws Exception{
		
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://ftc.aai.aero/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		int string_size = 5;
	      System.out.println("The size of the string is defined as: " +string_size);
	      String alpha_numeric = "0123456789" + "abcdefghijklmnopqrstuvxyz";
	      StringBuilder string_builder = new StringBuilder(string_size);
	      for (int i = 0; i < string_size; i++) {
	         int index = (int)(alpha_numeric.length() * Math.random());
	         string_builder.append(alpha_numeric.charAt(index));
	      }
	      String result = string_builder.toString();
	      System.out.println("The random string generated is: " +result);
		
		
		driver.findElement(By.xpath("//input[@name=\"field_full_name[0][value]\"]")).sendKeys(result);
		
		driver.findElement(By.xpath("//input[@name='mail']")).sendKeys(result+"@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='field_address[0][address][address_line1]']")).sendKeys("ghaziabad");
		
		driver.findElement(By.xpath("//input[@name='field_address[0][address][locality]']")).sendKeys("vijaynagar");
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='field_address[0][address][administrative_area]']"));
		
		Select sc = new Select(dropdown);
				sc.selectByValue("Haryana");
		
		Random rm = new Random();
		int max = 999999999;
		int min = 100000000;
		
		String num = String.valueOf(rm.nextInt(4)+6) + String.valueOf(rm.nextInt(min, max));
		
		driver.findElement(By.xpath("//input[@name='field_mobile_number_otp[0][mobile]']")).sendKeys(num);
		
		driver.findElement(By.xpath("//input[@name='field_aadhar[0][value]']")).sendKeys("936114297964");
		
		driver.findElement(By.xpath("//input[@id='edit-field-aadhaar-upload-0-upload']")).sendKeys("D:\\automation\\SeleniumBatch\\dummy.pdf");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='captcha_response']")).sendKeys("14");
		
		driver.findElement(By.xpath("//input[@name='op']")).click();

		
		
		//driver.quit();
		
	}
}
