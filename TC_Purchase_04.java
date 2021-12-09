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

public class TC_Purchase_04 {
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
		  driver.findElement(By.xpath("//a[@href=\"#/purchases/products\"]")).click(); //Product & Services
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click(); // Add a Product or Services
		  
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[1]")).sendKeys("Test_Services");  //Name
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])")).sendKeys("Details Of Product"); // Description
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[2]")).sendKeys("Test_Services");  //Price
		  
		  driver.findElement(By.xpath("(.//input[@type=\"checkbox\"])[1]")).click();
		  Thread.sleep(4000);
		  WebElement Incomeaccount =  driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]"));  //Income account
		  Thread.sleep(6000);
		  Select income = new Select (Incomeaccount);
		  income.selectByIndex(1);
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[3]")).click();  //Sale Tax
		  driver.findElement(By.xpath("//div[@style=\"padding: 5px; cursor: pointer;\"]")).click(); //Tax 18%
		  WebElement Save =driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]"));  //Save
		  JavascriptExecutor save=(JavascriptExecutor)driver;
		  save.executeScript("arguments[0].click()",Save);
		  Thread.sleep(6000);
}
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }  
}
