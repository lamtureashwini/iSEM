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

public class TC_Sales_04 {
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
		  driver.findElement(By.id("nf-email")).sendKeys("aashvini1");
		  driver.findElement(By.id("nf-password")).sendKeys("admin1");
		  driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
	      System.out.println("Login Successfullly");
	      Thread.sleep(2000);
	}
	  
	  @Test
	  public void vendors() throws InterruptedException {
		  WebElement Sales =driver.findElement(By.xpath("(//a[@class=\"c-sidebar-nav-dropdown-toggle\"])[3]"));
		  JavascriptExecutor executor1=(JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click()",Sales); //Sales Dropdown
		  
		  driver.findElement(By.xpath("//a[@href=\"#/sales/products\"]")).click(); //Product & servicce
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys("Service"); //Name
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])")).sendKeys("Internet Service"); //Description
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys("1510"); //Price
		  driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click(); // Sell this
		  Thread.sleep(8000);

		  WebElement sell =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]"));
		 Select select =new Select(sell);
		  select.selectByIndex(1);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[3]")).click(); //Tax 
		  driver.findElement(By.xpath("//div[@style=\"padding: 5px; cursor: pointer;\"]")).click(); //GST 18%
		  executor1.executeScript("window.scrollBy(0,100)","");
		  Thread.sleep(8000);
		  driver.findElement(By.xpath("//html")).click();
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click(); //Save
		  
		  Thread.sleep(80000);
}
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
