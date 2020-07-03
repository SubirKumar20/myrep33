package PomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.CLsEBay;

public class POMProductSearchTest 
{
	@Test
	public void Search() 
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome","http://ebay.com");
		CLsEBay obj=new CLsEBay(driver);
		obj.fnSearch("Sony");
		Reporter.log("Ebay Product Search Test is Successfull",true);


	}
}
