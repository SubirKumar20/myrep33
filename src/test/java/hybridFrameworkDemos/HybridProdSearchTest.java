package hybridFrameworkDemos;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.BrowserFactory;
import pomPages.CLsEBay;
import pomPages.GetData;

public class HybridProdSearchTest 
{

	@Test(dataProvider = "ebayData")
	public void Search(String ddValue, String txtValue) 
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome","http://ebay.com");

		CLsEBay obj=new CLsEBay(driver);
		obj.fnSearch(txtValue);
		Reporter.log("'"+ txtValue + "'Ebay Search Test is Successfull",true);

	}

	@DataProvider
	public Object[][] ebayData() throws IOException 
	{
		Object[][] myData=GetData.getExcelData(System.getProperty("user.dir")+"\\src\\test\\resources\\ebayData.xlsx");
		return myData;

	}
}
