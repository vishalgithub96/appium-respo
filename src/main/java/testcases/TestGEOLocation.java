package testcases;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.emulation.Emulation;

public class TestGEOLocation 
{ 
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Emulation.setGeolocationOverride(Optional.of(51.500149),Optional.of(-0.126240),Optional.of(100)));
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.gps-coordinates.net/#google_vignette");
		
	}

}
