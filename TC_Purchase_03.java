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

public class TC_Purchase_03 {

	WebElement element;

	WebDriver driver;
	  @BeforeClass 
	  public void setup() {
		  System.out.println("Launch Uel Successfully");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\system1\\eclipse-workspace\\selenium-java-3.141.59\\chromedriver_win\\chromedriver.exe");
		    driver= new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get("http://www.isem.somee.com/#/login");
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
		  WebElement PurcDrop =driver.findElement(By.xpath("(//a[@class=\"c-sidebar-nav-dropdown-toggle\"])[1]"));
		  JavascriptExecutor executor1=(JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click()",PurcDrop); //Purchases Dropdown
		  driver.findElement(By.xpath("(//a[@href=\"#/purchases/vendors\"])")).click();    // Vendors
		  driver.findElement(By.xpath("(//button[@class=\"float-right btn btn-pill\"])")).click();  //Add Vendor
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys("Automation Vendor");  //Vendor Name
		  driver.findElement(By.xpath("(//input[@type=\"radio\"])")).click();  //Type Radio Button
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys("Automation"); //First Name
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[3]")).sendKeys("Vendor"); //Last Name
		  WebElement Currency =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]"));  //Currency
		  Select currency = new Select (Currency);
		 currency.selectByIndex(1);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[4]")).sendKeys("auotmatio@gmail.com"); //Email
		 WebElement Country =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[3]"));  //Country
		 Select country = new Select (Country);
		  country.selectByIndex(1);
		  Thread.sleep(2000);
		 WebElement State =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[4]"));  //Province/State
		  Select state = new Select (State);
		   state.selectByIndex(1);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[1]")).sendKeys("Vadodara, Gujrat 390019"); //Address Line 1
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[2]")).sendKeys("Vadodara, Gujrat 390019"); //Address Line 2
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[5]")).sendKeys("Vadodara"); //City
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[6]")).sendKeys("390019"); //Postal/Zip Code
		  Thread.sleep(2000);
		 
		  WebElement Save =driver.findElement(By.xpath("(//button[@type=\"button\"])[6]"));  //Save
		  JavascriptExecutor save=(JavascriptExecutor)driver;
		  save.executeScript("arguments[0].click()",Save);
		  Thread.sleep(8000);
	  }
	  
	  
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
