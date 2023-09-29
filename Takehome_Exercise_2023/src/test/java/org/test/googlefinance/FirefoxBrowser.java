/*package org.test.googlefinance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxBrowser {
    FirefoxDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/finance/");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void getLastGoogleFinance() throws InterruptedException {
        // Code to search the Google ticker
        WebElement search = driver.findElement(By.xpath("(//input[@aria-label='Search for stocks, ETFs & more'])[2]"));
        search.sendKeys("Google");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(6000); // Using sleep for 6 seconds to load all the web elements

        String text = driver.findElement(By.xpath("//div[@class='pFZ9G']")).getText();
        String numericText = text.replaceAll("[^\\d.]+", ""); // Removes all non-digit and non-decimal characters
        // float floatValue = Float.parseFloat(numericText);   // No Need
        System.out.println("Previous closing price is " + numericText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
*/

package org.test.googlefinance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxBrowser {
    FirefoxDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\fadin\\OneDrive\\Desktop\\Classes\\Java\\geckodriver.exe"); // Set the path to geckodriver executable
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/finance/");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void getLastGoogleFinance() throws InterruptedException {
        // Code to search the Google ticker
        WebElement search = driver.findElement(By.xpath("(//input[@aria-label='Search for stocks, ETFs & more'])[2]"));
        search.sendKeys("Google");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(6000); // Using sleep for 6 seconds to load all the web elements

        String text = driver.findElement(By.xpath("//div[@class='pFZ9G']")).getText();
        String numericText = text.replaceAll("[^\\d.]+", ""); // Removes all non-digit and non-decimal characters
        // float floatValue = Float.parseFloat(numericText);   // No Need
        System.out.println("Previous closing price is " + numericText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}