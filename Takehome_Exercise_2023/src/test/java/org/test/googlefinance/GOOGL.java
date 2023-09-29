package org.test.googlefinance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GOOGL 
{
	ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://google.com/finance");
		Thread.sleep(2000);
	}
	
	@Test
	public void prevClosePrice() throws InterruptedException, IOException
	{
		
		WebElement search=driver.findElement(By.xpath("(//input[@aria-label='Search for stocks, ETFs & more'])[2]"));
		search.sendKeys("GOOGL");
		search.sendKeys(Keys.ENTER);
		//Thread.sleep(5000);
		//WebElement searchbutton=driver.findElement(By.xpath("//button[@aria-label='Search']"));
		//searchbutton.click();
		Thread.sleep(2000);
		
		/*	
		String prev=driver.findElement(By.xpath("//div[@class='pFZ9G']")).getText();
		//String text = prev.replaceAll("[^\\d]*(\\d+)\\..*", "$1");
		String numbers=prev.replaceAll("[^\\d$.]+", "");
		System.out.println("The Prev Closing Price is "+numbers);
		Thread.sleep(1000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		WebElement rightArrow=driver.findElement(By.xpath("//div[@class='zLrlHb EA7tRd']"));
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(rightArrow).moveByOffset(-50, 0).release().build().perform();
		
		Thread.sleep(2000);
		WebElement click=driver.findElement(By.xpath("//div[text()='Benzinga']"));
		click.click();
		Thread.sleep(2000);
		
		String newTabHandle = driver.getWindowHandles().toArray()[0].toString();
		  driver.switchTo().window(newTabHandle);
		  
		  Thread.sleep(6000);
		  
		  js.executeScript("window.scrollTo(0, 0);");
		  Thread.sleep(5000);

		*/
		  
		  WebElement clear=driver.findElement(By.xpath("//button[@aria-label='Clear search']"));
		  clear.click();
		  Thread.sleep(5000);
		  
		  WebElement future=driver.findElement(By.xpath("//div[text()='Futures']"));
		  future.click();
		  
		  Thread.sleep(3000);

		  WebElement gold=driver.findElement(By.xpath("//div[@data-display-name='Gold']"));
		  gold.click();
		  Thread.sleep(3000);
		  String goldprice=driver.findElement(By.xpath("//div[@class='YMlKec fxKbKc']")).getText();
		   System.out.println("Gold Price is "+goldprice);
		
		  Thread.sleep(3000);
		  
		  WebElement share=driver.findElement(By.xpath("(//span[text()='Share' and @jsname='V67aGc'])[2]"));
		  share.click();
		  Thread.sleep(3000);

		  
		    // Create an instance of Actions class
	        Actions actions = new Actions(driver);

	        // Simulate pressing the Tab key twice
	        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
	        
			  Thread.sleep(3000);

	        //String expected= "Please re-enter your password";
			 
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 // Switch to the newly opened tab (index 1)
			 driver.switchTo().window(tabs.get(1));

		    WebElement username = driver.findElement(By.id("email"));
	        username.sendKeys("fadi_njaber@hotmail.com");
	        WebElement password=driver.findElement(By.name("pass"));
	        password.sendKeys("Fnij8688");
	        WebElement loginbutton=driver.findElement(By.name("login"));
	        loginbutton.click();
			Thread.sleep(5000);

			SoftAssert s=new SoftAssert();
			

			try {
	            WebElement errorMessage = null;

	            try {
	                errorMessage = driver.findElement(By.xpath("//div[text()='Please re-enter your password']"));
	                s.assertNotNull(errorMessage, "Error message element not found");
	                System.out.println(errorMessage.getText());
	            } catch (NoSuchElementException e) {
	                System.out.println("Error message element not found");
	            }


	        } finally {
	        	 s.assertAll();
	        }
	            
	            
			  /* try {
				   WebElement errorMessage = null;
				   
				   try {
	                   errorMessage=driver.findElement(By.xpath("//div[text()='Please re-enter your password']"));
				       }
				   catch (NoSuchElementException e) 
				       {
					   s.assertNotNull(errorMessage, "Error message element not found");
			           }
				  
	      //s.assertTrue(errorMessage.isDisplayed());
	      System.out.println(errorMessage.getText());
	        	*/	
			
			
			//FileUtils is a utility class from the Apache Commons IO library that provides various file manipulation methods, including copyFile().
            //The copyFile() method takes two arguments: the source file (f) to be copied and the destination file (new    
	      File f = driver.getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(f,new File("C:\\Users\\fadin\\OneDrive\\Pictures\\first3.png"));
	         
		 
	             
	  	 Thread.sleep(3000);
			   
	  	 
	  	 
	 	
	  	 }   
			 

				  

		  
				  
		//WebElement cashflow=driver.findElement(By.xpath("(//span[text()='Cash Flow'])[2]"));
		//js.executeScript("arguments[0].scrollIntoView();",cashflow);
		//Thread.sleep(5000);
		//cashflow.click();
	
	
	
	@AfterMethod (enabled=true)
	public void tearDown()
	{
		driver.quit();
	}

}
