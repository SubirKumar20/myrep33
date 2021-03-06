package dataDrivenFrameworkDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFProdCatSearchTest 
{
	@Test(dataProvider = "ebayData")
	public void CatSearch(String ddValue, String txtValue) 
	{
		WebDriverManager.chromedriver().version("83").setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ebay.com");
		
		WebElement ddCat=driver.findElement(By.id("gh-cat"));
		Select s=new Select(ddCat);
		s.selectByVisibleText(ddValue);


		driver.findElement(By.id("gh-ac")).sendKeys("Selenium");
		driver.findElement(By.id("gh-btn")).click();
		Reporter.log("'"+ txtValue + "'ProductSearch in'" + ddValue + "' Category Test is Successfull",true);

	}

	@DataProvider
	public Object[][] ebayData() throws IOException 
	{
		Object[][] myData=null;
		XSSFWorkbook wb=new XSSFWorkbook(System.getProperty("user.dir")+"\\src\\test\\resources\\ebayData.xlsx");
		XSSFSheet ws=wb.getSheet("Sheet1");
		int rows=ws.getPhysicalNumberOfRows();
		myData =new Object[rows][2];
		for(int i=0;i<rows;i++)
		{
			myData[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
			myData[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
		}
		return myData;

	}
}
