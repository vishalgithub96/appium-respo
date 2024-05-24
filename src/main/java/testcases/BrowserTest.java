package testcases;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserTest 
{
	public static String browser= "chrome";
	public static RemoteWebDriver driver;
	
	public static void main(String[] args)
	{
			
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

			
		}
		else if (browser.equals("firefox")){
			driver = new FirefoxDriver();
			
		}
		else if (browser.equals("edge")){
			driver = new EdgeDriver();
			
		}
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
	List<WebElement> value = driver.findElements(By.tagName("option"));
	System.out.println(value.size());
	
	for (int i = 0; i < value.size();i++) 
	{
		System.out.println(value.get(i).getText());
		
	}
	List<WebElement> link = driver.findElements(By.tagName("a"));
	System.out.println(link.size());
	
		for(WebElement links: link) 
		{
			System.out.println(links.getText()+ "_________ "+ links.getAttribute("href"));
		}
		
	}

}
