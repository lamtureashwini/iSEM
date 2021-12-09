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

public class TC_Sales_01 {
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
		  driver.findElement(By.xpath("(//a[@href=\"#/sales/estimates\"])")).click(); //Quotes
		  driver.findElement(By.xpath("(//button[@class=\"btn btn-pill\"])[2]")).click(); //Create quote
		  driver.findElement(By.xpath("(//button[@class=\"btn\"])[1]")).click(); //Select CUstomer
		  driver.findElement(By.xpath("(//a[@href=\"#\"])[10]")).click(); // Select customer from list
		 WebElement currency =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[7]"));  //Currency
		 Select USD = new Select (currency);
		 USD.selectByIndex(2);
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[26]")).sendKeys("28/06/2021");  //Date
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[27]")).sendKeys("28/07/2021");  //Expire on
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[28]")).sendKeys("PO.NO.2021.01");  //PO Number
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[29]")).sendKeys("SO.No.2021.02");  //SO Number
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[30]")).sendKeys("SubHeading");  //SubHeading 
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[31]")).sendKeys("Footer");  //Footer
		 driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[7]")).sendKeys("Memo"); // Memo
		 driver.findElement(By.xpath("(//button[@class=\"btn\"])[2]")).click(); //Click on select Item
		 driver.findElement(By.xpath("(//a[@href=\"#\"])[17]")).click(); //Select Item
		 driver.findElement(By.xpath("(//input[@class=\"form-control\"])[34]")).sendKeys("100"); //Quantity
		  Thread.sleep(4000);
		  WebElement Save =driver.findElement(By.xpath("(//button[@class=\"btn btn-pill\"])[2]"));  //Save & Continue
		  JavascriptExecutor save=(JavascriptExecutor)driver;
		  save.executeScript("arguments[0].click()",Save);
		  Thread.sleep(40000);
}
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
