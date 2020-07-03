package PomTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pomPages.BrowserFactory;
import pomPages.CLsEBay;

public class POMProductCatSearchTest 
{
	@Test
	public void CatSearch()
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome","http://ebay.com");
		CLsEBay obj=new CLsEBay(driver);
		obj.fnCatSearch("Cameras & Photos","Sony");
		Reporter.log("Ebay Product Search in a Category Test is Successfull",true);


	}
}
