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

public class TC_Accounting_01 {
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
	  
	  @Test //(invocationCount = 5, threadPoolSize = 2)
	  public void login() throws InterruptedException {
		 // AtomicInteger sequence = new AtomicInteger(0);
		  //int count= sequence.addAndGet(1);
	       //System.out.println("Test Run Number  "+count + " run by Thread  " + Thread.currentThread().getId());
		  driver.findElement(By.id("nf-email")).sendKeys("jaymaheta");
		  driver.findElement(By.id("nf-password")).sendKeys("admin");
		  driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
	      System.out.println("Login Successfullly");
	      Thread.sleep(2000);
	}
	  @Test
	  public void vendors() throws InterruptedException {
		  WebElement account =driver.findElement(By.xpath("(//a[@class=\"c-sidebar-nav-dropdown-toggle\"])[3]"));
		  JavascriptExecutor executor1=(JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click()",account); //Accounting Dropdown
		  
		  driver.findElement(By.xpath("//a[@href=\"#/accounting/category\"]")).click(); // Category
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click();// Add Category
		  Thread.sleep(8000);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys("TC01"); // Category Code
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys("Test_Case"); // Category Name
		  WebElement operation = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]")); //Operation
		  Select op =new Select(operation);
	      op.selectByIndex(1);
	      Thread.sleep(8000);
		  driver.findElement(By.xpath("(//button[@class=\"btn\"])[1]")).click();  //Debit Account
	      driver.findElement(By.xpath("(//a[@href=\"#\"])[7]")).click();
	      Thread.sleep(8000);
	      driver.findElement(By.xpath("(//button[@class=\"btn\"])[2]")).click();  //Credit Account
	      driver.findElement(By.xpath("(//a[@href=\"#\"])[36]")).click();
	      // Thread.sleep(8000);
	      driver.findElement(By.xpath("(//button[@class=\"btn\"])[3]")).click(); //Tax
	      driver.findElement(By.xpath("(//a[@href=\"#\"])[49]")).click();
	      
	      driver.findElement(By.xpath("//textarea[@class=\"form-control\"]")).sendKeys("Description"); //Description
	      driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click(); //Default radio button
	      // driver.findElement(By.xpath("(//button[@class=\"btn btn-pill\"])")).click();//Save
	      Thread.sleep(800000);
		  
	  }
	  
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
