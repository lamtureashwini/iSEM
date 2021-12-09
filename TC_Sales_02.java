package com.iSEM_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Sales_02 {
	WebElement element;

	WebDriver driver;
	  @BeforeClass 
	  public void setup() {
		  System.out.println("Launch Uel Successfully");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\system1\\eclipse-workspace\\selenium-java-3.141.59\\chromedriver_win\\chromedriver.exe");
		    driver= new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get("http://localhost:3000/#/login");
	  }
	  
	  @Test 
	  public void login() throws InterruptedException {
		  driver.findElement(By.id("nf-email")).sendKeys("jaymaheta");
		  driver.findElement(By.id("nf-password")).sendKeys("admin");
		  driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
	      System.out.println("Login Successfullly");
	      Thread.sleep(2000);
	}
	  
	  @Test
	  public void vendors() throws InterruptedException {
		  WebElement Sales =driver.findElement(By.xpath("(//a[@class=\"c-sidebar-nav-dropdown-toggle\"])[2]"));
		  JavascriptExecutor executor1=(JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click()",Sales); //Sales Dropdown
		  driver.findElement(By.xpath("(//a[@href=\"#/sales/invoice/\"])")).click();  //Invoices
		  driver.findElement(By.xpath("//button[@class=\"float-right btn btn-pill\"]")) .click(); //Create Invoice
		  executor1.executeScript("window.scrollBy(0,360)","");
		  driver.findElement(By.xpath("//p[@class=\"text-center p-1\"]")).click(); //Add customer
		  driver.findElement(By.xpath("//div[@style=\"padding: 5px; cursor: pointer;\"]")).click(); // Select Customer
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[19]")).sendKeys("PO2021"); // PO Number
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[20]")).sendKeys("SO2021"); //SO number
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[21]")).sendKeys("29/06/2021");  // Invoice Date
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[22]")).sendKeys("30/06/2021");  // Payment Date
		  
		  Thread.sleep(4000);
		  WebElement item = driver.findElement(By.xpath("//div[@class=\"text-center col-sm-12\"]")); //Add Item
		 JavascriptExecutor executor2=(JavascriptExecutor)driver;
	     executor2.executeScript("arguments[0].scrollIntoView(true);", item);    
		 item.click();
		 // WebDriverWait wait2 = new WebDriverWait(driver, 10);
		 // wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"text-center col-sm-12\"]")));
		 // driver.findElement(By.xpath("//div[@class=\"text-center col-sm-12\"]")).click();

		  
		  driver.findElement(By.xpath("(//div[@class=\"Productlistitem\"])[1]")).click();  //Select Item
		  
		  Thread.sleep(4000);
		  executor2.executeScript("window.scrollBy(0,200)","");
		  Thread.sleep(4000);
		  WebElement USD = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[9]"));
		  Select usd = new Select (USD);
		  usd.selectByIndex(1);
		  WebElement add = driver.findElement(By.xpath("//b[text()=\"Add Note \"]"));
		  JavascriptExecutor executor3=(JavascriptExecutor)driver;
		     executor3.executeScript("arguments[0].click;", add);    
		     add.click();
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[9]")).sendKeys("Extra Notes"); //Add Notes
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click();
		  Thread.sleep(4000);
}
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}