package org.test.googlefinance;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import junit.framework.ComparisonFailure;



public class GOOGLPrevClose {
	
	
	//This line declares a variable named driver of type ChromeDriver.
	
	//WebDriverWait w;
	ChromeDriver driver1;
	// annotation from the TestNG testing framework that marks 
	//the following method as a setup method to be executed before each test method
	@BeforeMethod
	public void setUp() 
	{
		// a new instance of ChromeDriver and assigns it to the driver variable, 
		//It creates a new Chrome browser session that can be used to automate interactions with the browser.
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver1 = new ChromeDriver(option);
		driver1.get("https://www.google.com/finance");
		driver1.manage().window().maximize();
		driver1.manage().deleteAllCookies();
		
		/*
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		String op= driver.switchTo().alert().getText();
		System.out.println("The Alert is "+op);
		driver.switchTo().alert().sendKeys("OK");
		*/
	}
	
	@Test (priority = 1)
	public void prevClosingPrice() throws InterruptedException, IOException
	{
			
		//WebElement top=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-tab-id='topStories'])[3]")));
		//top.getText();
		
		WebElement search=driver1.findElement(By.xpath("(//input[@aria-label='Search for stocks, ETFs & more'])[2]"));
		search.sendKeys("googl");
		search.sendKeys(Keys.ENTER);
		
		//driver.navigate().back();
		
		//driver.navigate().forward();
		
		//driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		
		
	}
		

		@Test (priority = 2, enabled = false)
		public void prevClosingPrice1() throws InterruptedException, IOException
		{		
		
		WebElement title=driver1.findElement(By.xpath("//div[text()='Alphabet Inc Class A' and @role='heading']"));
		Actions a = new Actions(driver1);
		a.doubleClick(title).perform();
	
		Thread.sleep(3000);
		
		boolean a1=title.isDisplayed();
		Assert.assertTrue(a1);
		System.out.println("Assert a1 is true");
		
		
		SoftAssert s=new SoftAssert();
		s.assertTrue(a1, "soft assertion passed");
		File f2=driver1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f2, new File("C:\\Users\\fadin\\OneDrive\\Pictures\\softassert.png"));
		
		
		DOMConfigurator.configure("../Takehome_Exercise_2023/Logs.xml");
		Logger l1=Logger.getLogger("GOOGLPrevClose");
		l1.info("soft assert passed");
		
		JavascriptExecutor j1=(JavascriptExecutor)driver1;
		j1.executeScript("window.scrollBy(0,1000)", "");
		//j1.executeScript("windowscrollTo(0,0)", "");
		//j1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//a.contextClick(search).perform();
		//a.doubleClick(search).perform();
		
		//driver1.switchTo().alert();
		//WebElement m=driver1.findElement(By.xpath(""));
		//m.sendKeys(Keys.TAB);
		
		java.util.List<WebElement>links=driver1.findElements(By.xpath("//div[@class='pFZ9G']"));
		System.out.println(links.size());
		
		s.assertAll();
		}
		
		@Test (priority = 3)
		@Ignore
		public void prevClosingPrice2() throws InterruptedException, IOException
		{		
			WebElement title=driver1.findElement(By.xpath("//div[text()='Alphabet Inc Class A' and @role='heading']"));
		if (title.isDisplayed())
		    {
			String prevClose=driver1.findElement(By.xpath("//div[@class='pFZ9G']")).getText();
			
			//replace all non-digit characters (excluding the decimal point) with a space.
			String numerictext=prevClose.replaceAll("[^\\d.]+", " "); 
			System.out.println("the prev closing price is "+numerictext);
		    }
		    else 
	        	{
			    System.out.println("title is not displayed");
	        	}
			
				File f=driver1.getScreenshotAs(OutputType.FILE);
				//FileUtils.copyFile() is a method provided by the Apache Commons IO library,
				FileUtils.copyFile(f, new File("C:\\Users\\fadin\\OneDrive\\Pictures\\firstone100.png"));
				
				//configures log4j using an XML configuration file, creates a logger named "GOOGLPrevClose", 
				//and logs an informational message "No errors" using that logger.
				DOMConfigurator.configure("../Takehome_Exercise_2023/Logs.xml");
				Logger L=Logger.getLogger("GOOGLPrevClose");
				L.info("No errors");
				
				
			    // Code that may throw IOException
		
			    
		Thread.sleep(3000);
		
		//The JavascriptExecutor interface defines the executeScript() and 
		//executeAsyncScript() methods, which enable you to execute JavaScript code and 
		//asynchronously execute JavaScript code, respectively.
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollTo(0, 0);");
		
		
		Thread.sleep(3000);
		driver1.navigate().back();
		Thread.sleep(2000);
		//Assert.assertEquals(driver1.getCurrentUrl(), "https://www.google.com/finance/quote/GOOGL:NASDAQ");
		//System.out.println("Hard Assertion passed");
		
		try {
		    Assert.assertEquals("https://www.google.com/finance/quote/GOOGL:NASDAQ", driver1.getCurrentUrl());
		    System.out.println("Assertion passed");
		    
		    //e is a variable that represents the exception object that was thrown.
		} catch (ComparisonFailure e) {
		    System.out.println("Assertion failed: Expected URL was different - " + e.getMessage());
		    // Perform additional error handling or logging if needed
		}
	}
		
		@Test (priority = 4)
		@DataProvider(name = "myDataProvider")
		public Object[][] provideTestData() {
		    // Return the test data as a 2D array
		    return new Object[][] {
		        { "Test Data 1", 10 },
		        { "Test Data 2", 20 },
		        { "Test Data 3", 30 }
		    };
		
	}
	

	

	@AfterMethod
	public void tearDown()
	{
		
		driver1.quit();
	}

}
