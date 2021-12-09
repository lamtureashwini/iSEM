package com.iSEM_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC_Login_01 {
	WebDriver driver;
  @BeforeClass
  public void setup() {
	  System.out.println("Launch Url Successfully");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_update\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://localhost:3000/#/login");
  }
  
  @Test 
  public void login() throws InterruptedException {
	  driver.findElement(By.id("nf-email")).sendKeys("jaymaheta");
	  driver.findElement(By.id("nf-password")).sendKeys("admin");
	  driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
	 
      System.out.println("Login Successfullly");
      
}
  
  @AfterClass
  public void close () throws InterruptedException {
	 
	  driver.close();
	  System.out.println("Close window");
  }
}

