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

public class TC_Sales_03 {
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
		  driver.findElement(By.xpath("//a[@href=\"#/sales/customers\"]")).click();  // CUSTOMERS
		  driver.findElement(By.xpath("//button[@class=\"float-right btn btn-pill\"]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys("Joy"); // First Name
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys("Smith"); // Last Name
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[3]")).sendKeys("customer@gmail.com"); // Email 
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[4]")).sendKeys("8010448618"); // Phone
		  System.out.println("Filled data in Contact");
		  Thread.sleep(2000);
		  
		  
		  executor1.executeScript("window.scrollBy(0,360)","");
		  WebElement currency = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]")); //Currency
		  Select USD = new Select(currency);
		  USD.selectByIndex(1);
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[1]")).sendKeys("Vadodara,Gujrat"); //Address Line 1
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[2]")).sendKeys("Vadodara,Gujrat"); //Address Line 2
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[5]")).sendKeys("Vadoara"); // City Name
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[6]")).sendKeys("390019"); // Postal/Zip Code
		  WebElement country = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[3]"));  // Country
		  Select coun = new Select(country);
		  coun.selectByIndex(0);
		  WebElement state = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[4]"));  // Province/Sate
		  Select State = new Select(state);
		  State.selectByIndex(0);
		  System.out.println("Filled data in billing");
		  Thread.sleep(2000);
		  executor1.executeScript("window.scrollBy(0,360)","");
		  
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[7]")).sendKeys("9145864578"); // Ship to contact
		  WebElement country1 = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[5]"));  // Country
		  Select coun1 = new Select(country1);
		  coun1.selectByIndex(0);
		  WebElement state1 = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[4]"));  // Province/Sate
		  Select State1 = new Select(state1);
		  State1.selectByIndex(0);
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[3]")).sendKeys("Vadodara,Gujrat"); //Address Line 1
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[4]")).sendKeys("Vadodara,Gujrat"); //Address Line 2
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[8]")).sendKeys("Pune"); // City Name
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[9]")).sendKeys("413213"); // Postal/Zip Code
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[5]")).sendKeys("Instruction"); //Delivery Instruction
		  System.out.println("Filled data in shipping");
		  Thread.sleep(2000);

		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[10]")).sendKeys("52416378"); // FAX
		  Thread.sleep(8000);
		  executor1.executeScript("window.scrollBy(0,100)","");
		  driver.findElement(By.xpath("(//button[@class=\"col-md-3 h5 btn\"])")).click(); //Save
		  Thread.sleep(80000);
}
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
